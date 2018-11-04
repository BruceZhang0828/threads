package com.zhy;

public class Demo01 {

    private int count = 10;
    private Object o = new Object();//申请锁 o的对象；互斥锁

    public void m(){
        synchronized (o){//任何线程执行下边的代码需要拿到o的锁
            count++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //线程概念
        //启动线程
//        基本的线程同步  synchronized

    }
}
