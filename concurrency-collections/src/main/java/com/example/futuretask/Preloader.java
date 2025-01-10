package com.example.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Preloader {
    ProductInfo loadProductInfo() throws DataLoadException {
        try {
            return get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private final FutureTask<ProductInfo> future = new FutureTask<>(this::loadProductInfo);

    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws DataLoadException, InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException exception) {
            var cause = exception.getCause();
            if (cause instanceof DataLoadException)
                throw (DataLoadException) cause;
            else
                throw LaunderThrowable.launderThrowable(cause);
        }
    }
}
