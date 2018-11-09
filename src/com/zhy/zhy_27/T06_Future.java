package com.zhy.zhy_27;

import java.util.concurrent.*;

public class T06_Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task = new FutureTask<Integer>(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });

        new Thread(task).start();

        System.out.println(task.get());//阻塞

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> f = executorService.submit(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 1;
        });


        System.out.println(f.isDone());
        System.out.println(f.get());
        System.out.println(f.isDone());
    }




}
