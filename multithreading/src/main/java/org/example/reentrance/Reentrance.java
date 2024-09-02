package org.example.reentrance;

public class Reentrance {
    private int count = 0;

    public synchronized void increment() {
        this.count++;
    }

    /**
     * Метод increment() будет открыт для исполнения тем же потоком, который
     * выполняет метод incrementAndGet(). Другой поток не сможет выполнить метод increment().
     */
    public synchronized int incrementAndGet() {
        increment();
        return this.count;
    }
}
