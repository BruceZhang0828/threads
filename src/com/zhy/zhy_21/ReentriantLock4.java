package com.zhy.zhy_21;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentriantLock4 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(()->{

            try {
                lock.lock();
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                System.out.println("t1 interrupted");
            }finally {
                lock.unlock();
            }
        });
        t1.start();
        Thread t2 = new Thread(()->{
            boolean locked = false;
            try {
                //lock.lock();
                locked = lock.tryLock();
                lock.lockInterruptibly();//可以对interrupt方法做出响应
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                System.out.println("t2 interrupted");
            }finally {
                if(locked)lock.unlock();
            }
        });

        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();//打断线程2的锁定
    }
}
