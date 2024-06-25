package kotlin.ranges;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: UIntRange.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u0013\u0010\f\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u00020\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u00020\u0002X\u0082\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b!¨\u0006\u000f"}, d2 = {"Lkotlin/ranges/UIntProgressionIterator;", "", "Lkotlin/UInt;", "first", "last", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", "", "next", "next-pVg5ArA", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class UIntProgressionIterator implements Iterator<UInt>, KMappedMarker {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    public /* synthetic */ UIntProgressionIterator(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (r2 <= 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        if (r2 >= 0) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private UIntProgressionIterator(int r4, int r5, int r6) {
        /*
            r3 = this;
            r3.<init>()
            r3.finalElement = r5
            r0 = 1
            r1 = 0
            if (r6 <= 0) goto L10
            int r2 = kotlin.UByte$$ExternalSyntheticBackport0.m$2(r4, r5)
            if (r2 > 0) goto L17
            goto L18
        L10:
            int r2 = kotlin.UByte$$ExternalSyntheticBackport0.m$2(r4, r5)
            if (r2 < 0) goto L17
            goto L18
        L17:
            r0 = r1
        L18:
            r3.hasNext = r0
            int r6 = kotlin.UInt.m247constructorimpl(r6)
            r3.step = r6
            boolean r6 = r3.hasNext
            if (r6 == 0) goto L25
            goto L26
        L25:
            r4 = r5
        L26:
            r3.next = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.UIntProgressionIterator.<init>(int, int, int):void");
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ UInt next() {
        return UInt.m241boximpl(m1379nextpVg5ArA());
    }

    /* renamed from: next-pVg5ArA  reason: not valid java name */
    public int m1379nextpVg5ArA() {
        int i = this.next;
        if (i != this.finalElement) {
            this.next = UInt.m247constructorimpl(this.step + i);
        } else if (!this.hasNext) {
            throw new NoSuchElementException();
        } else {
            this.hasNext = false;
        }
        return i;
    }
}
