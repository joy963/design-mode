package com.wang.designmode.future;

import java.util.concurrent.Callable;

/**
 * this interface define two main method to submit task.
 */
public interface FutureService<T> {
    /**
     * there is no return result,invoke get() will return null.
     *
     * @param runnable
     * @return
     */
    Future<?> submit(Runnable runnable);

    Future<T> submit(Callable<T> runnable);

    Future<T> submit(Callable<T> runnable, Callback<T> callback);
}
