package com.wang.designmode.observable;

/**
 * observable interface
 * define the observer's method
 */
public interface Observable {

    enum Cycle {
        STARTED, RUNNING, DONE, ERROR
    }

    /**
     * get state of current task
     * @return @link com.wang.designmode.observable.Observable.Cycle
     */
    Cycle getCycle();

    /**
     * define the mothod of starting task,and shield the other methods of Thread
     */
    void start();

    /**
     * define the mothod to interrupt thread,and shield the other methods of Thread like start method.
     */
    void interrupt();

}
