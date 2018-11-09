package com.zhy.zhy_27;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class T13_ThreadPoolExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 3,
                60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
    }
}
