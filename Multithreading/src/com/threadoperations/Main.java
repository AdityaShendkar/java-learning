package com.threadoperations;

public class Main {
    public static void main(String[] args) {
        System.out.println("Started......");
        int sum = 20+20;
        System.out.println(sum);
        // Thread name=======

        Thread t  = Thread.currentThread();
        String tname = t.getName();
        System.out.println("current running thread is " + tname);

        // Thread sleep======
        try{
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // setName ========
        t.setName("MainAppln");
        System.out.println("Thread name changed to:- " + t.getName());

        // getId========

        long id = t.getId();
        System.out.println("Thread id :- " + id);
        System.out.println("Ended......");


    }
}
