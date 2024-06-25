import base64
from pwn import xor


b64 = base64.b64decode("FRsIAQ8PVBUVEREIVERbBkURFkUIBxVQVkAYFxJfV0FYVkIVQgo=")
key = b"swifties!"
flag = xor(b64, key)
print(flag)

# flag{f1f4bfa202c60e2aaa9339de61513141}
