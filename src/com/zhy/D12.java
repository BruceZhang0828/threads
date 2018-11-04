package com.zhy;

import java.util.ArrayList;
import java.util.List;

/**
 *volatile保证了线程之间的可见性
 * synchronized：既保证了可见性，也保证了线程之间的原子性。
 */
public class D12 {
    volatile static int count = 0;
    void m(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        //synchronized
        D12 d = new D12();
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
