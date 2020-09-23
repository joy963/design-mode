package com.wang.designmode.future;

/**
 * future interface
 */
public interface Future<T> {
    /**
     * block method
     * wait the thread return result
     * @return
     */
    T get() throws InterruptedException;

    /**
     * get thread's state.
     * @return
     */
    boolean done();
}
