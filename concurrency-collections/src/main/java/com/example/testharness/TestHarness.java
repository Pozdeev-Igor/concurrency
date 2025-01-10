package com.example.testharness;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * Использование CountDownLatch для запуска и остановки потоков в тестах с хронометражем
 */
public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final var startGate = new CountDownLatch(1);
        final var endGate = new CountDownLatch(nThreads);

        IntStream.range(0, nThreads).forEachOrdered(i -> {
            new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                }catch (InterruptedException ignored) {}
            }).start();
        });
        var start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        var end = System.nanoTime();
        return end - start;
    }
}
