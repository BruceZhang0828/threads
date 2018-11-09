package com.zhy.zhy_27;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class T12_ForkJoinPool {
    static final int MAX_NUM = 50000;
    static final  int[] arrays = new int[1000000];
    static {

        Random r = new Random();
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] =r.nextInt(100);
        }
        int sum = Arrays.stream(arrays).sum();
        System.out.println(sum);
    }


    static class  AddTaks extends RecursiveAction {
        int start,end;

        public AddTaks(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {

            if (end-start<MAX_NUM){
                int sum = 0;
                for (int i =start; i <end ; i++) {
                    sum+=arrays[i];
                    System.out.println("form:"+start+"to"+end+"="+sum);
                }
            }else {
                int midle = start+(end-start)/2;
                AddTaks a1 = new AddTaks(start,midle);
                AddTaks a2 = new AddTaks(midle,end);
                a1.fork();
                a2.fork();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        ForkJoinPool fjp = new ForkJoinPool();
        AddTaks addTaks = new AddTaks(0,arrays.length);
        fjp.execute(addTaks);

        System.in.read();
    }


}
