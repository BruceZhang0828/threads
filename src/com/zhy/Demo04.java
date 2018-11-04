package com.zhy;

public class Demo04 {
    private static int count = 10;

    public synchronized static void m() {//等同 synchronized (Demo04.class)

        count--;
        System.out.println(Thread.currentThread().getName());

    }

    public static void mm(){
        synchronized (Demo04.class){//不可以 使用this。
            count--;
        }
    }
}
