package com.zhy.zhy_21;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentriantlock用于代替synchronized
 * 本例中由于m1锁定this，只有m1执行完的时候m2才能执行
 * 这里是复习synchronized的原始的语义
 */
public class ReentriantLock1 {
    synchronized void m1(){
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
    synchronized void m2(){
        System.out.println("m2...");
    }

    public static void main(String[] args) {
        ReentriantLock1 r1 = new ReentriantLock1();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r1::m2);
    }
}
