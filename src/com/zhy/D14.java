package com.zhy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 解决同类问题更加高效的办法是使用AtomicXXX类
 * AtomicXXX类本身方法都是原子性，但是不能保证多个方法连续调用是原子性。
 */
public class D14 {

    //volatile static int count = 0;
    static AtomicInteger count = new AtomicInteger(0);
    /*synchronized*/  void m(){
        for (int i = 0; i < 10000; i++) {
            //count++;
            if(count.get()<1000)
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        //synchronized
        D14 d = new D14();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(d::m,"thread"+i));
        }
        threads.stream().forEach(thread -> thread.start());
        threads.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        System.out.println(count);
    }
}
