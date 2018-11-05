package com.zhy.zhy_21;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可以代替完成同样的功能
 * 需要注意的是，必须要手动释放锁
 * 使用syn锁定的遇到异常jvm会自动释放锁，但是lock必须手动释放锁；因此经常在finally中释放锁
 */
public class ReentriantLock2 {
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
    synchronized void m2(){
        lock.lock();
        System.out.println("m2...");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentriantLock1 r1 = new ReentriantLock1();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r1::m2).start();
    }
}
