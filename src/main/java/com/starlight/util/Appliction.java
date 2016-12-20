package com.starlight.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by thomas.wang on 2016/12/20.
 */
public class Appliction {
    public static  ApplicationContext getAct() {
        ApplicationContext act =
                new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
        return act;
    }
}
