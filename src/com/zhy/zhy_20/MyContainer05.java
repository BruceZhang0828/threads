package com.zhy.zhy_20;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/*
* 使用门闩
* */
public class MyContainer05 {

    //添加volatile 关键字 让t2可见
    volatile List lists =  new ArrayList<>();

    public void  add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        MyContainer05 myContainer02 =new MyContainer05();
        final Object lock = new Object();
        CountDownLatch latch = new CountDownLatch(1);//1是关闭门闩 0是开始门闩
        new Thread(()->{


            System.out.println("t2启动");
            if(myContainer02.size()!=5){
                try {
                    latch.await();
                    //也可以指定等待时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 结果");


        },"t2").start();

        new Thread(()->{
            System.out.println("t1启动");
            synchronized (lock){
                for (int i = 0; i <10 ; i++) {
                    myContainer02.add(new Object());
                    System.out.println("add"+i);
                    if (myContainer02.size()==5){
                        //打开门闩 t2执行
                       latch.countDown();
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
