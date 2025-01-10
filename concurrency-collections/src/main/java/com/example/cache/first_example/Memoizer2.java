package com.example.cache.first_example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Этот класс демонстрирует улучшенную конкурентность, но не спасает от того, что потоки будут выполнять одну и ту же
 * работу одновременно.
 * Нужно чтобы потоки могли видеть результат работы других потоков
 */
public class Memoizer2<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A,V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        var result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
