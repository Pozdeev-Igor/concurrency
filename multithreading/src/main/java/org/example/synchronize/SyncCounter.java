package org.example.synchronize;

public class SyncCounter {
    private long count = 0;

    public synchronized void incrementCount() {
        this.count++;
    }

    public synchronized long getCount() {
        return this.count;
    }
}
