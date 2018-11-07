package com.zhy.zhy_25;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class TicketSeller04 {
    //使用队列进行操作、、、
    static Queue<String> tickes = new ConcurrentLinkedDeque<>();
    static {
        for (int i = 0; i < 100; i++) {
            tickes.add("票 编号："+i);
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    String s = tickes.poll();//取出来队列的最后一个元素  先进后出
                    if (s==null)break;
                    else System.out.println("出售了"+s);
                }
            }).start();
        }
    }
}
