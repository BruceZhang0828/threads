package com.zhy;

import java.util.concurrent.TimeUnit;

/**
 * 锁定某个对象o，若果对顶对象的属性值发生改变是不影响的
 * 但是对象o的引用发生了变化的，则锁定的对象发生改变  这种问题应该避免发生。
 */
public class D16 {
    Object o = new Object();

    void m(){
        synchronized (o){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }


    public static void main(String[] args) {
        D16 d16 = new D16();

        new Thread(d16::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        d16.o = new Object();
        new Thread(d16::m,"t2").start();
    }
}
