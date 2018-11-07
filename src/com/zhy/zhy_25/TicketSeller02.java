package com.zhy.zhy_25;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class TicketSeller02 {
    static Vector<String> lists = new Vector<>();

    static {
        for (int i = 0; i < 1000; i++) {
            lists.add("票号"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                //判断与执行是分离的
                while (lists.size()>0){

                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("销售了----"+lists.remove(0));
                }
            }).start();
        }
    }

}
