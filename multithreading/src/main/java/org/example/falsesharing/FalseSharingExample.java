package org.example.falsesharing;

public class FalseSharingExample {

    public static void main(String[] args) {

        var counter1 = new Counter();
        var counter2 = counter1;

        long iterations = 1_000_000_000;

        Thread thread1 = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for(long i=0; i<iterations; i++) {
                counter1.count1++;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("total time: " + ((endTime - startTime)/1000.0));
        });
        Thread thread2 = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for(long i=0; i<iterations; i++) {
                counter2.count2++;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("total time: " + ((endTime - startTime)/1000.0));
        });

        thread1.start();
        thread2.start();
    }
}
