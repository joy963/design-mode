package com.wang.designmode.observable;

public class DemoLifecycle<T> implements TaskLifecycle<T> {
    @Override
    public void onStart(Thread thread) {
        System.out.println("on starting");
    }

    @Override
    public void onRunning(Thread thread) {
        System.out.println("on running");
    }

    @Override
    public void onFinish(Thread thread, T result) {
        System.out.println("finished");
    }

    @Override
    public void onError(Thread thread, Exception e) {
        System.out.println("error");
    }
}
