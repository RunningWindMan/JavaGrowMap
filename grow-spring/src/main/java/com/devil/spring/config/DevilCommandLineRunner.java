package com.devil.spring.config;

import com.devil.spring.bean.DevilBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Devil
 * @date Created in 2021/9/8 13:54
 */
@Component
public class DevilCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DevilCommandLineRunner.class);

    private final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, r -> {
        Thread t = new Thread(r);
        t.setName("com.devil.spring.Test");
        t.setDaemon(true);
        return t;
    });

    @Override
    public void run(String... args) throws Exception {
        //        while (true) {
        //            DevilBean bean = new DevilBean();
        //            bean.getCount();
        //            TimeUnit.MILLISECONDS.sleep(500);
        //        }
        TestTask testTask = new TestTask();
        this.executorService.scheduleWithFixedDelay(testTask, 0L, 30L, TimeUnit.SECONDS);

    }

    class TestTask implements Runnable {

        TestTask() {
        }

        @Override
        public void run() {
            log.info("任务执行。。。。。。。。。。");
        }
    }
}
