package com.zhy.zhy_22;

import com.zhy.zhy_20.MyContainer01;

import java.util.LinkedList;

public class MyContainer1<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;
    private int count =0;

    public synchronized void put(T t){
        while(list.size()==MAX){
            try {
                this.wait();//
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(t);
        count++;
        this.notifyAll();//通知消费者线程进行消费
    }

    public synchronized T get(){
        T t = null;
        while (list.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        t = list.removeFirst();
        count--;
        this.notifyAll();

        return t;
    }

    public static void main(String[] args) {
        MyContainer1<String> container01 = new MyContainer1();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    System.out.println(container01.get());
                }
            },"c"+i).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) {
                    container01.put(Thread.currentThread().getName()+" "+j);
                }
            },"p"+i).start();
        }
    }
}
