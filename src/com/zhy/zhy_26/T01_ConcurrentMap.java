package com.zhy.zhy_26;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

public class T01_ConcurrentMap {

    public static void main(String[] args) {
        //Map<String,String> map = new Hashtable<>();


        Map<String,String> map = new ConcurrentSkipListMap<>();//高并发并且排序的map
        //Map<String,String> map = new ConcurrentHashMap<>();

        Random random = new Random();
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j <10000 ; j++) {
                    map.put("a"+random.nextInt(10000),"a"+random.nextInt(10000));
                }
                latch.countDown();
            });
        }
        Arrays.stream(threads).forEach(t->{
            t.start();
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
