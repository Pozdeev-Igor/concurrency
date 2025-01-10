package com.example.cache.first_example;

public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException;
}
