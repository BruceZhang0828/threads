package com.zhy.zhy_22;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer2<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition provider = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t) {

        try {
            lock.lock();
            while (MAX == lists.size()) {
                provider.await();
            }
            lists.add(t);
            count++;
            consumer.signalAll();//通知所有消费者启动
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public T get() {
        T t = null;

        try {
            lock.lock();
            while (lists.size() == 0) {
                consumer.await();
            }
            t = lists.removeFirst();
            count--;
            provider.signalAll();//通知生产者生产
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

        return t;
    }


    public static void main(String[] args) {
        MyContainer2<String> container01 = new MyContainer2();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    System.out.println(container01.get());
                }
            },"c"+i).start();
        }


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
