package com.company;

public class Programer implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println("一边敲代码 一遍睡觉。。。");
        }
    }
}
