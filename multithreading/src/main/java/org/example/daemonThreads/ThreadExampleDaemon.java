package org.example.daemonThreads;

/**
 * A daemon thread in Java is a thread that does not keep the Java Virtual Machine (JVM) running
 * if the main thread exits the application. A non-daemon thread will keep the JVM running even if the main thread exits
 * the application.
 * You tell a Thread to be a daemon thread via its setDaemon() method. Here is an example of creating a daemon thread in Java
 */
public class ThreadExampleDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Daemon Thread running."));

        thread.setDaemon(true);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
