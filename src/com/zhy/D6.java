package com.zhy;

public class D6 {

    public synchronized void  m1(){
        System.out.println("m1启动。。。。。。");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1结束......");
    }

    public synchronized void m2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"m2");

    }


    public static void main(String[] args) {
        D6 d6 = new D6();

        new Thread(()->d6.m1(),"t1").start();
        new Thread(()->d6.m2(),"t1").start();
    }
}
