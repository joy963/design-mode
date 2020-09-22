package com.wang.designmode.immutableobject;

/**
 * define a integer immutable object class
 */
public final class IntegerAccumulator {
    /**
     * define imutable init value
     */
    private final int init;

    public IntegerAccumulator(int init) {
        this.init = init;
    }

    public int getValue() {
        return this.init;
    }

    public IntegerAccumulator(IntegerAccumulator accumulator, int init) {
        this.init = accumulator.getValue() + init;
    }

    public IntegerAccumulator add(int i) {
        return new IntegerAccumulator(this, i);
    }

}
