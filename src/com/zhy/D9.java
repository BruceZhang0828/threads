package com.zhy;

import java.util.concurrent.TimeUnit;

/**
 * 同一个
 * synchronized:锁的重入的
 */
public class D9 {
    synchronized void m() {
        System.out.println("m start....");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("m end");
    }

    public static void main(String[] args) {
        new D9c().m();
    }

    static class D9c extends D9 {
        @Override
        synchronized void m() {
            System.out.println("child m start");
            super.m();
            System.out.println("child m end");
        }
    }
}
