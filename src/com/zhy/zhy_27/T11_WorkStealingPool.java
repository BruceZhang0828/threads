package com.zhy.zhy_27;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T11_WorkStealingPool {

    public static void main(String[] args) throws IOException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newWorkStealingPool();
        executorService.execute(new R(1000));
        executorService.execute(new R(2000));
        executorService.execute(new R(2000));
        executorService.execute(new R(2000));
        executorService.execute(new R(2000));

        //由于产生精灵线程（守护线程，后台线程），主线不阻塞看不到输出
        System.in.read();


    }


    static class R implements Runnable{
        int time;

        public R(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName());
        }
    }
}
