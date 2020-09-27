package com.wang.designmode;

import com.wang.config.starter.config.TestAutoBean;
import com.wang.config.starter.config.TestAutoBean2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DesignModeApplicationTests {

    @Resource
    private TestAutoBean testBean;

    @Resource
    private TestAutoBean2 testBean2;

    @Test
    void contextLoads() {
        System.out.println(testBean.getAge());
        System.out.println(testBean.isEnable());
        testBean2.print();
    }

}
