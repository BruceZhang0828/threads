package com.zhy.zhy_25;

import java.util.ArrayList;
import java.util.List;

/**
 * 有n张火车票 每一张都有一个票号
 * 同时有10个窗口对外售票
 * 请写一个模拟程序
 *
 * 下边程序 会产生什么问题？
 * 重复销售， 超量销售
 */
public class TicketSeller01 {
    static List<String> lists = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            lists.add("票号"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (lists.size()>0){
                    System.out.println("销售了----"+lists.remove(0));
                }
            }).start();
        }
    }

}
