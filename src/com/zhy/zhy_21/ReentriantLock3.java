package com.zhy.zhy_21;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentriantLock3 {

    ReentrantLock lock = new ReentrantLock();
    synchronized void m1(){
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 使用trylock可以进行尝试锁定，不管锁定与否，方法都将继续执行
     * 可以根据trylock的方法返回值来确定是否已经锁定
     * 也可以指定trylock的时间，会抛出异常 注意unlock的处理
     */
    synchronized void m2(){
//        boolean tryLock = lock.tryLock();
//        System.out.println("m2..."+tryLock);
//        if(tryLock)lock.unlock();
        boolean locked = false;
        try {
            lock.tryLock(5,TimeUnit.SECONDS);
            System.out.println("m2..."+locked);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (locked)lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentriantLock3 r3 = new ReentriantLock3();
        new Thread(r3::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r3::m2).start();
    }
}
