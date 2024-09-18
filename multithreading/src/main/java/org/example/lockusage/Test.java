package org.example.lockusage;

public class Test {
    public static void main(String[] args) {
        var lock = new Synchronizer();
        var thread1 = new Thread(lock::doSynchronized);
        var thread2 = new Thread(lock::doSynchronized);
        var thread3 = new Thread(lock::doSynchronized);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
