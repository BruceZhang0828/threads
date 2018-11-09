package com.zhy.zhy_26;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> str = new ConcurrentLinkedDeque<>();

        for (int i = 0; i < 10; i++) {
            str.offer("a"+i);//add
        }

        System.out.println(str);

        System.out.println(str.size());

        System.out.println(str.poll());//弹出
        System.out.println(str.size());

        System.out.println(str.peek());//取出还回
        System.out.println(str.size());
    }
}
