package com.wang.designmode;

import com.wang.designmode.observable.ObservableThread;
import com.wang.designmode.observable.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignModeApplicationTests {

    @Test
    void contextLoads() {
        new ObservableThread<String>(new Task() {
            @Override
            public Object call() {
                return "test call";
            }
        }).start();
    }

}
