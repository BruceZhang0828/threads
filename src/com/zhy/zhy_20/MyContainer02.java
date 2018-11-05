package com.zhy.zhy_20;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**&
 * t2中的判断不准确
 * t2浪费cpu
 */
public class MyContainer02 {
    //添加volatile 关键字 让t2可见
    volatile List lists =  new ArrayList<>();

    public void  add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        MyContainer02 myContainer02 =new MyContainer02();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                myContainer02.add(new Object());
                System.out.println("add"+i);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"t1").start();

        new Thread(()->{
            while (true){
                if(myContainer02.size()==5){
                    break;
                }
            }
            System.out.println("t2 结果");
        },"t2").start();
    }

}
