package org.example.synchronize;

public class SyncCounterMain {
    public static void main(String[] args) {
        var counter = new SyncCounter();

        var thread1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.incrementCount();
            }
            System.out.println(counter.getCount());
        });

        var thread2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.incrementCount();
            }
            System.out.println(counter.getCount());
        });

        thread1.start();
        thread2.start();
    }
}
