package com.wang.designmode.observable;

/**
 * define the mothods to execute when task's state change
 */
public interface TaskLifecycle<T> {

    /**
     * executed when task's state is starting
     * @param thread
     */
    void onStart(Thread thread);

    /**
     * executed when task's state is running
     * @param thread
     */
    void onRunning(Thread thread);

    /**
     * executed when task's state is finished
     * @param thread
     * @param result
     */
    void onFinish(Thread thread, T result);

    /**
     * executed when task occur error
     * @param thread
     * @param e
     */
    void onError(Thread thread, Exception e);
}
