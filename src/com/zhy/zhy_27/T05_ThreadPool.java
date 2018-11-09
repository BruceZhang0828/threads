package com.zhy.zhy_27;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T05_ThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
            executorService.execute(()->{
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        System.out.println(executorService);
        executorService.shutdown();//等待所有任务执行完成后 关闭
        System.out.println(executorService.isTerminated());
        System.out.println(executorService.isShutdown());
        System.out.println(executorService);

        TimeUnit.MILLISECONDS.sleep(5000);

        System.out.println(executorService.isTerminated());
        System.out.println(executorService.isShutdown());
        System.out.println(executorService);
    }
}
