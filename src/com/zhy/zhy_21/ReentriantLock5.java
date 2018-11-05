package com.zhy.zhy_21;

import java.util.concurrent.locks.ReentrantLock;

/**
 *ReentrantLock还可以指定为公平锁
 */
public class ReentriantLock5 extends Thread {
    private static ReentrantLock lock = new ReentrantLock(true);//参数TRUE表示公平锁开启
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {

                System.out.println(Thread.currentThread().getName()+"获得了锁");
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentriantLock5 r = new ReentriantLock5();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }


}
