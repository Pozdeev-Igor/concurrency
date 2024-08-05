package org.example.threadpriority;

public class ThreadPriority extends Thread {

    @Override
    public void run() {
        System.out.println("Running thread priority is: " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        var threadPriority = new ThreadPriority();
        var threadPriority1 = new ThreadPriority();
        threadPriority.setPriority(Thread.MAX_PRIORITY);
        threadPriority1.setPriority(Thread.MIN_PRIORITY);

        threadPriority.start();
        threadPriority1.start();
    }
}
