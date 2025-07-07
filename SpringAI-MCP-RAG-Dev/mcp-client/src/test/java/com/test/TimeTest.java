package com.test;

import com.itzixi.Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

/**
 * @ClassName TimeTest
 * @Author 风间影月
 * @Version 1.0
 * @Description TimeTest
 **/
@SpringBootTest(classes = Application.class)
public class TimeTest {

    @Test
    public void testTime() throws InterruptedException {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("任务1");
        Thread.sleep(1000);
        stopWatch.stop();

        stopWatch.start("任务2");
        Thread.sleep(300);
        stopWatch.stop();

        stopWatch.start("任务3");
        Thread.sleep(100);
        stopWatch.stop();

        // 打印任务的耗时统计
        System.out.println(stopWatch.prettyPrint());
        System.out.println(stopWatch.shortSummary());

        // 任务总览s
        System.out.println("所有任务总耗时：" + stopWatch.getTotalTimeMillis());
        System.out.println("任务总数：" + stopWatch.getTaskCount());
    }

}
