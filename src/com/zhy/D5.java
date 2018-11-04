package com.zhy;

public class D5 implements Runnable {
    private  int count = 10;
    @Override
    public /*synchronized*/ void run() { //synchronized原子操作
        count--;
        System.out.println(Thread.currentThread().getName()+"count"+count);
    }

    public static void main(String[] args) {
        D5 d5 = new D5();
        for (int i = 0; i < 5; i++) {
            new Thread(d5,"Thread"+i).start();
        }
    }
}
