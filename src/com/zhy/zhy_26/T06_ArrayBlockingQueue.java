package com.zhy.zhy_26;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue {
    static BlockingQueue<String> str = new ArrayBlockingQueue<String>(10);
    static Random r = new Random();
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            str.put("a"+i);
        }

        //str.put("aaaaa");//队列满了就进行等待，程序阻塞
        //str.add("aaaaa");//添加报错
        //str.offer("aaaaa");//通过返回值来判断是否添加成功
        str.offer("aaaaa",10, TimeUnit.SECONDS);//根据时间来等待

        System.out.println(str);

    }
}
