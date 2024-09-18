package org.example.lockusage;

public class Synchronizer {

    Lock lock = new Lock();

    public void doSynchronized() {
        try {
            this.lock.lock();
            //critical section, do a lot of work which takes a long time
            this.lock.unlock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
