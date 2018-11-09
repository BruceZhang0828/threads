package com.zhy.zhy_27;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T14_ParallelStream {

    public static void main(String[] args) {
        List<Integer> nums =  new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i <1000 ; i++) {
            nums.add(1000000+r.nextInt(100000));
        }
        long start = System.currentTimeMillis();
        nums.stream().forEach(i -> isPrime(i));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        long start2 = System.currentTimeMillis();
        nums.parallelStream().forEach(i->isPrime(i));
        long end2 = System.currentTimeMillis();

        System.out.println(end2 - start2);

    }


    static boolean isPrime(int n){
        for (int i = 2;i<n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
