package com.zhy.zhy_26;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class T09_SynchronizedQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strings = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(strings.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        //strings.add("a");
        strings.put("a");//阻塞等待消费者消费
        System.out.println(strings.size());
    }
}
