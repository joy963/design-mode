package com.wang.designmode.future;

import java.util.concurrent.Callable;

public class FutureServiceImpl<T> implements FutureService<T> {
    @Override
    public Future<Void> submit(Runnable runnable) {
        final FutureTask<Void> futureTask = new FutureTask<>();
        new Thread(() -> {
            runnable.run();
            futureTask.finish(null);
        }).start();
        return futureTask;
    }

    @Override
    public Future<T> submit(Callable<T> runnable) {
        final FutureTask<T> futureTask = new FutureTask<>();
        new Thread(() -> {
            T result = null;
            try {
                result = runnable.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
            futureTask.finish(result);
        }).start();
        return futureTask;
    }
}
