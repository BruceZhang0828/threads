package com.zhy;

/**
 * 不要以字符串作为锁对象
 * 出现诡异现象：当你使用了一个类库中使用“hello”作为锁对象
 * 自己写的程序也使用了“hello”作为锁对象；会出现了死锁的现象阻塞。
 */
public class D17 {
    String s1 = "hello";
    String s2 = "hello";

    void m1(){
        synchronized (s1){

        }
    }

    void m2(){
        synchronized (s2){

        }
    }

}
