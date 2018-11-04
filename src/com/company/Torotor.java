package com.company;

public class Torotor extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("乌龟跑了"+i+"步");
        }
    }
}
