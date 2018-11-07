package com.zhy.zhy_26;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList读的效率高 写的效率低
 * 适合写很少 读很多的
 */
public class T02_CopyOnWriteList {
    public static void main(String[] args) {
        List<String> list =
                //new ArrayList<>();
                //new Vector();
                new CopyOnWriteArrayList<>();
        Random r = new Random();
        Thread[] ths = new Thread[100];
        for (int i = 0; i < ths.length; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        list.add("a"+ r.nextInt(10000));
                    }
                }
            };
            ths[i] = new Thread(task);

        }
        runAndComputeTime(ths);
        System.out.println(list.size());
    }

     static void runAndComputeTime(Thread[] ths) {
         long start = System.currentTimeMillis();
         Arrays.stream(ths).forEach(thread -> {
             thread.start();
         });
         Arrays.stream(ths).forEach(t->{
             try {
                 t.join();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         });

         long end = System.currentTimeMillis();
         System.out.println(end-start);
     }
}
