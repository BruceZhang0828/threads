package com.zhy;

import java.util.concurrent.TimeUnit;

/**
 * 在写操作中枷锁  读方法上不加
 * 容易产生脏读
 *
 */

public class D7 {
    String name;
    double blance;

    public synchronized void set(String name,double blance){
        this.name = name;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.blance = blance;
    }


    public /*synchronized 进行解决*/ double getBlance(String name){
        return this.blance;
    }

    public static void main(String[] args) {
        D7 d7 = new D7();

        new Thread(()->d7.set("zhangsan",100.0)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(d7.getBlance("zhangsan"));
    }
}

