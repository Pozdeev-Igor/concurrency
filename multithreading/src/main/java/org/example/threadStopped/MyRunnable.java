package org.example.threadStopped;

public class MyRunnable implements Runnable {
    private boolean doStop = false;

    public synchronized void stop() {
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        return this.doStop = false;
    }

    @Override
    public void run() {
        while (keepRunning()) {
            System.out.println("Running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}
