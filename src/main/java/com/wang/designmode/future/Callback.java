package com.wang.designmode.future;

@FunctionalInterface
public interface Callback<T> {
    void run(T t);
}
