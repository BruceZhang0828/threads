package com.zhy.zhy_27;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T09_SingleThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();//只有一个线程 顺序执行
        for (int i = 0; i < 5; i++) {
            final int j = i;
            executorService.execute(()->{
                System.out.println(j+Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
    }
}
