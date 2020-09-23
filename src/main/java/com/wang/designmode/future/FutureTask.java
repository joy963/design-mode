package com.wang.designmode.future;

public class FutureTask<T> implements Future<T> {
    /**
     * result
     */
    private T result;
    /**
     * thread's state
     */
    private boolean isDone = false;

    /**
     * define a lock
     */
    private final Object LOCK = new Object();

    @Override
    public T get() throws InterruptedException {
        synchronized (LOCK) {
            while (!isDone) {
                LOCK.wait();
            }
            return result;
        }
    }

    @Override
    public boolean done() {
        return isDone;
    }

    protected void finish(T result) {
        synchronized (LOCK) {
            if (isDone) {
                return;
            }
            this.result = result;
            this.isDone = true;
            LOCK.notifyAll();
        }
    }
}
