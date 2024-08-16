package org.example.threadStopped;

public class MyRunnableMain {
    public static void main(String[] args) {
        var myRunnable = new MyRunnable();
        var thread = new Thread(myRunnable);

        thread.start();
        try {
            Thread.sleep(10L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myRunnable.stop();
    }
}
