package com.example.cache.first_example;

import com.example.futuretask.LaunderThrowable;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Лучший образец из всех представленных. Демонстрирует очень хорошую конкурентность, но остается окно уязвимости:
 * Блок {@code if} в методе {@code compute} по прежнему является неатомарной последовательностью
 * "проверить-потом-действовать" и два потока могут одновременно вызвать метод {@code compute} с одним и тем же значением
 */
public class Memoizer3<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = () -> c.compute(arg);
            var ft = new FutureTask(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run(); // Вызов c.compute происходит тут
        }
        try {
            return f.get();
        } catch (ExecutionException | InterruptedException exception) {
            throw LaunderThrowable.launderThrowable(exception.getCause());
        }
    }
}
