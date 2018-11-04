package com.zhy;

import java.util.concurrent.TimeUnit;

/**
 *synchronized优化：
 * 同步代码块中的语句越少越好
 * 比较m1和m2
 */
public class D15 {
    int count = 0;
    synchronized void m1(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //业务逻辑中只有下边的语句需要加sync，这时候不应该给整个方法上锁
        count++;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     void m2(){

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //业务逻辑中只有下边的语句需要加sync，这时候不应该给整个方法上锁
         //使用细粒度的锁可以使代码的运行时间变得更加短。
        //count++;
        synchronized (this){
            count++;
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
