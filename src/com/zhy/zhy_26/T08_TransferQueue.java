package com.zhy.zhy_26;

import java.util.concurrent.LinkedTransferQueue;

public class T08_TransferQueue {


    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> trans = new LinkedTransferQueue<>();
       /* new Thread(()->{
            try {
                System.out.println(trans.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/


        trans.transfer("aaaa");//找不到消费者  会进阻塞

        new Thread(()->{
            try {
                System.out.println(trans.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
