package com.wang.designmode.observable;

import java.util.concurrent.Callable;

/**
 * define a task
 * @param <T>
 */
public interface Task<T> extends Callable {
    /**
     * execute task,return result
     * @return
     */
    T call();
}
