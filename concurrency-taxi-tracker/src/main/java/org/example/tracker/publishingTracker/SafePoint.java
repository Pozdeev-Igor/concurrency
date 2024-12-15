package org.example.tracker.publishingTracker;

import net.jcip.annotations.GuardedBy;

public class SafePoint {

    @GuardedBy("this") private int x, y;

    public SafePoint(SafePoint safePoint) {
        this(safePoint.get());
    }

    public SafePoint(int x, int y) {
        this.set(x, y);
    }

    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private SafePoint(int[] array) {
        this(array[0], array[1]);
    }
}
