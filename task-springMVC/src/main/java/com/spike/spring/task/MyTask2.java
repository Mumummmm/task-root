package com.spike.spring.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author spike.lin
 */
@Component
public class MyTask2 {

    @Scheduled(cron = "*/5 * * * * ?")
    public void show() {
        System.out.println("Annotation: is show run");
    }

    @Scheduled(fixedRate = 1000*2)
    public void print() {
        System.out.println("Annotation: print run");
    }
}
