package org.example.threadlocal.withexecutorservice;

public class MyRunnable implements Runnable {

    private final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    @Override
    public void run() {
        threadLocal.set( (int) (Math.random() * 100D) );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println(threadLocal.get());

    }
}
