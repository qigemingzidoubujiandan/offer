package javaTest; /**
 * Created by zhaocl on 2021/10/18 21:35.
 * desc：
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: offer
 * @description:
 * @author: zhaochenliang
 * @create: 2021-10-18 21:35
 **/
public class Test {

    public static StringBuilder stringBuilder = new StringBuilder();

    private static AtomicInteger atomicInteger = new AtomicInteger();

    private static void update(){
        stringBuilder.append("1");
    }

    private static  void  add() {
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(200);
        CountDownLatch countDownLatch = new CountDownLatch(5000);
        for (int i = 0; i < 5000; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    update();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println(stringBuilder.length());
        System.out.println(atomicInteger);
    }
}
