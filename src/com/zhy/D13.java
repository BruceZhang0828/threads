package com.zhy;

import java.util.ArrayList;
import java.util.List;

/**
 * synchronized更重的锁  时间会更加慢
  */
public class D13 {
    /*volatile*/ static int count = 0;
    synchronized  void m(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        //synchronized
        D13 d = new D13();
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
