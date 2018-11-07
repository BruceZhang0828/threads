package com.zhy.zhy_25;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TicketSeller03 {
    static List<String> lists = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            lists.add("票号"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    //这里将size+remove形成了相同的原子性
                    synchronized (lists){
                        if (lists.size()>0){
                            try {
                                TimeUnit.MILLISECONDS.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("销售了----"+lists.remove(0));
                        }
                    }
                }
            }).start();
        }
    }

}
