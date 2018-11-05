package com.zhy.zhy_20;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *这里的使用wait和notify做，wait会释放锁 而 notify不会释放
 * 这里必须 保证让t2先执行，这样才是t2监控作用
 *
 */
public class MyContainer03 {

    //添加volatile 关键字 让t2可见
    volatile List lists =  new ArrayList<>();

    public void  add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        MyContainer03 myContainer02 =new MyContainer03();
        final Object lock = new Object();

        new Thread(()->{
            synchronized (lock){
                System.out.println("t2启动");
                if(myContainer02.size()!=5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结果");
            }

        },"t2").start();

        new Thread(()->{
            System.out.println("t1启动");
            synchronized (lock){
                for (int i = 0; i <10 ; i++) {
                    myContainer02.add(new Object());
                    System.out.println("add"+i);
                    if (myContainer02.size()==5){
                        lock.notify();
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }

        },"t1").start();


    }
}
