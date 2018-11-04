package com.company;

public class JoinDemo01 extends Thread {

    public static void main(String[] args) throws InterruptedException {

        JoinDemo01 j = new JoinDemo01();
        Thread t = new Thread(j);
        t.start();
        for (int i = 0; i < 100; i++) {
            if(i==50){
                j.join();
            }
            System.out.println("main......");
        }
    }


    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println("thread 。。。。。。");
        }
    }
}
