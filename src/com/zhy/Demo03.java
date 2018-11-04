package com.zhy;

public class Demo03 {

    private int count = 10;

    public synchronized void m() {//等同 synchronized (this)

        count--;
        System.out.println(Thread.currentThread().getName());

    }
}
