package com.zhy;

import java.util.concurrent.TimeUnit;

public class D10 {
    int count = 0;

    public synchronized void m(){
        System.out.println(Thread.currentThread().getName()+"   start");
        while (true){
            count++;
            System.out.println(Thread.currentThread().getName()+"  count:"+count);
            try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


            if (count==5){
                int a = 1/0;//此处出现异常 锁将被释放。
            }
        }
    }


    public static void main(String[] args) {
        D10 d10 = new D10();
        new Thread(d10::m,"thread").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(d10::m,"thread2").start();
    }
}
