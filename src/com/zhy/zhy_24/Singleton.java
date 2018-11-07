package com.zhy.zhy_24;

/**
 *实现一个线程安全的 单例模式
 */
public class Singleton {

    private Singleton(){

    }

    public static class Inner{
        private static Singleton s = new Singleton();
    }

    public Singleton getInstance(){
        return Inner.s;
    }


    public static void main(String[] args) {

    }
}
