package com.wang.designmode.utils;

import java.util.concurrent.TimeUnit;

public class TaskSimulation {

    public static void executeTask(int time) {
        try {
            TimeUnit.MICROSECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void executeTask() {
        try {
            TimeUnit.MICROSECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
