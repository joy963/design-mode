package com.wang.designmode.IntegerAccumulator;

import com.wang.designmode.immutableobject.IntegerAccumulator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IntegerAccumulatorTest {
    @Test
    public void testRunnable() {
        IntegerAccumulator integerAccumulator = new IntegerAccumulator(0);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> integerAccumulator.add(1)).start();
        }
        System.out.println(integerAccumulator.getValue());
    }
}
