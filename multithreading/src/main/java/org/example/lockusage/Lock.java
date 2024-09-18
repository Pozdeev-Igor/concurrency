package org.example.lockusage;

public class Lock {

    private boolean isLocked = false;
    private Thread lockingThread = null;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
            System.out.println("lockingThread inside while = " + lockingThread);
        }
        isLocked = true;
        lockingThread = Thread.currentThread();
        System.out.println("lockingThread outside while = " + lockingThread.getName());
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException(
                    "Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        notify();
    }
}
