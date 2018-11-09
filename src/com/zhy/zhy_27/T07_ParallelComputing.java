package com.zhy.zhy_27;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class T07_ParallelComputing {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       /* long start = System.currentTimeMillis();
        List<Integer> prime = getPrime(1, 200000);
        long end = System.currentTimeMillis();
        System.out.println(end-start);*/

        final int cpuCoreNum = 4;

        ExecutorService executorService =
                Executors.newFixedThreadPool(cpuCoreNum);


        MyTask myTask1 = new MyTask(1, 80000);
        MyTask myTask2 = new MyTask(80001, 130000);
        MyTask myTask3 = new MyTask(130001, 170000);
        MyTask myTask4 = new MyTask(170001, 200000);


        Future<List<Integer>> f1 = executorService.submit(myTask1);
        Future<List<Integer>> f2 = executorService.submit(myTask2);
        Future<List<Integer>> f3 = executorService.submit(myTask3);
        Future<List<Integer>> f4 = executorService.submit(myTask4);

        long star = System.currentTimeMillis();
        List<Integer> integers1 = f1.get();
        List<Integer> integers2 = f2.get();
        List<Integer> integers3 = f3.get();
        List<Integer> integers4 = f4.get();
        long end2 = System.currentTimeMillis();
        System.out.println(end2-star);

        executorService.shutdown();


    }


    static class MyTask implements Callable<List<Integer>>{
        int startPos,endPos;

        public MyTask(int startPos, int endPos) {
            this.startPos = startPos;
            this.endPos = endPos;
        }

        @Override
        public List<Integer> call() throws Exception {
            List<Integer> prime = getPrime(startPos, endPos);
            return prime;
        }
    }

    static boolean isPrime(int num){
        for (int i = 2; i <= num / 2; i++) {
            if (num%i==0){
                return false;
            }
        }

        return true;
    }

    static List<Integer> getPrime(int start,int end){
        List<Integer> results = new ArrayList<>();
        for (int i = start;i<end;i++){
            if(isPrime(i))
            {
                results.add(i);
            }
        }

        return results;
    }
}
