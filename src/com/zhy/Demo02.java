package com.zhy;

public class Demo02 {
    private int count = 10;

    public void m(){
        synchronized (this){//synchronized 锁的是对象。
            count--;
            System.out.println(Thread.currentThread().getName());
        }
    }
}
