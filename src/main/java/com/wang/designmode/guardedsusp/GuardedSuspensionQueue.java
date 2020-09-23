package com.wang.designmode.guardedsusp;

import java.util.LinkedList;

public class GuardedSuspensionQueue<T> {
    private final LinkedList<T> queue = new LinkedList<>();
    private final int LIMIT = 100;

    public void offer(T date) throws InterruptedException {
        synchronized (this) {
            while (queue.size() >= LIMIT) {
                this.wait();
            }
            queue.addLast(date);
            this.notifyAll();
        }
    }

    public T take() throws InterruptedException {
        synchronized (this) {
            while (queue.isEmpty()) {
                this.wait();
            }
            this.notifyAll();
            return queue.removeFirst();
        }
    }
}
