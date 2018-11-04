package com.company;

//1.继承Thread 重写run方法。
//2.线程启动：创建对象 调用start（）方法。
public class Rabbit extends Thread {
    @Override
    public void run() {
        //线程体
        for (int i = 0; i <100 ; i++) {

            System.out.println("兔子跑了"+i+"步");
        }
    }
}
