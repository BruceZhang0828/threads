package com.zhy;

import java.util.concurrent.TimeUnit;

/**
 * volatile  将缓存区的内容进行了同步。 这个是线程可见。。。。
 */
public class D11 {
    /*volatile*/ boolean running = true;

    void m(){
        System.out.println("m start");
        while(running){

        }
        System.out.println("m end");

    }


    public static void main(String[] args)  {
        D11 d11 = new D11();

        new Thread(d11::m,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        d11.running=false;
    }

}
