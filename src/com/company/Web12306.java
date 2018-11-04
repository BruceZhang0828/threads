package com.company;

public class Web12306 implements Runnable {
    private int num =50;
    @Override
    public void run() {
        while (true){
            if (num<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
        }
    }

    public static void main(String[] args) {
        Web12306 web  = new Web12306();
        Thread t1 = new Thread(web,"Jack1");
        Thread t2 = new Thread(web,"Jack3");
        Thread t3 = new Thread(web,"Jack5");
        t1.start();
        t2.start();
        t3.start();
    }
}
