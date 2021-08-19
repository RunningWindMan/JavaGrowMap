package com.devil.test;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import com.devil.spring.DevilSpringApplication;
import org.junit.jupiter.api.Test;
import org.redisson.api.*;
import org.redisson.client.protocol.ScoredEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * redisson测试
 *
 * @author devil
 * @date Created in 2021/7/20 9:19
 */
@SpringBootTest(classes = {DevilSpringApplication.class})
public class RedissonTest {

    private static final Logger log = LoggerFactory.getLogger(RedissonTest.class);

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void commonTest() {
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void putTest() {
        RBucket<String> bucket = redissonClient.getBucket("test");
        bucket.set("123");
        log.info("第一次塞值： {}", bucket.get());
        boolean isUpdated = bucket.compareAndSet("123", "4934");
        log.info("更新后： {}", bucket.get());
        String prevObject = bucket.getAndSet("321");
        log.info("再更新后： {}", bucket.get());
        boolean isSet = bucket.trySet("901");
        log.info("再再更新后： {}", bucket.get());
        long objectSize = bucket.size();

        // set with expiration
        bucket.set("value", 10, TimeUnit.SECONDS);
        boolean isNewSet = bucket.trySet("nextValue", 10, TimeUnit.SECONDS);

        log.info("size {}", objectSize);
    }

    @Test
    public void putTest2() {
        RScoredSortedSet<String> memberList = redissonClient.getScoredSortedSet("memberList");
        int count = 20000;
        while (count > 0) {
            String curTime = String.valueOf(System.currentTimeMillis());
            memberList.add(count, curTime + "-" + count + "-" + curTime);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
        }
    }

    @Test
    public void getTest() {
        RScoredSortedSet<String> memberList = redissonClient.getScoredSortedSet("memberList");
        long startTime = System.currentTimeMillis();
        int total = memberList.size();
        int index = 0;
        while (index < total) {
            Collection<ScoredEntry<String>> scoredEntries = memberList.entryRange(index, 100);
            index += 100;
            for (ScoredEntry<String> entry : scoredEntries) {
                if (entry.getValue().contains("1629187357901")) {
                    index = total;
                    break;
                }
            }
        }
        long interval = System.currentTimeMillis() - startTime;
        // 平均100ms
        System.out.println("用时： " + interval + "ms");
    }

}
 