package org.example.threadstart;

public class MyThread extends Thread {

    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        var t = new MyThread();
        t.start();
        System.out.println("Main thread is running...");
    }
}
