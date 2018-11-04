package com.company;

public class RaceApi {

    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Torotor torotor = new Torotor();

        rabbit.start();
        torotor.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main执行。。。");
        }
    }
}
