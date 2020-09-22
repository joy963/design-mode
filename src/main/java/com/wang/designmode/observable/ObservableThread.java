package com.wang.designmode.observable;

/**
 * observer(send date) role,execute task and send state to the observed(receive date).
 *
 * @param <T>
 */
public class ObservableThread<T> extends Thread implements Observable {
    /**
     * define object how to execute when state changed
     */
    private final TaskLifecycle<T> lifecycle;
    /**
     * define a task
     */
    private final Task<T> task;
    /**
     * has the state of a task
     */
    private Cycle cycle;

    public ObservableThread(Task<T> tTask) {
        this(new DemoLifecycle<>(), tTask);
    }

    public ObservableThread(TaskLifecycle<T> lifecycle, Task<T> tTask) {
        super();
        if (tTask == null) {
            throw new RuntimeException("the task is required!");
        }
        this.lifecycle = lifecycle;
        this.task = tTask;
    }

    @Override
    public void run() {
        this.update(Cycle.STARTED, null, null);
        this.update(Cycle.RUNNING, null, null);
        T object = task.call();
        System.out.println(object);
        this.update(Cycle.DONE, null, null);
        this.update(Cycle.ERROR, null, new RuntimeException("test exception"));
    }

    /**
     * send date to the observed
     *
     * @param cycle
     * @param result
     * @param e
     */
    private void update(Cycle cycle, T result, Exception e) {
        //send state to object,that can get the state by method
        this.cycle = cycle;
        if (cycle == null) {
            return;
        }
        switch (cycle) {
            case STARTED:
                this.lifecycle.onStart(currentThread());
                break;
            case RUNNING:
                this.lifecycle.onRunning(currentThread());
                break;
            case DONE:
                this.lifecycle.onFinish(currentThread(), result);
                break;
            case ERROR:
                this.lifecycle.onError(currentThread(), e);
                break;
        }
    }

    @Override
    public Cycle getCycle() {
        return this.cycle;
    }
}
