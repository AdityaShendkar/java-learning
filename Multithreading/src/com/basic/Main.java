package com.basic;

import com.basic.runnable.MyThreadRunnable;
import com.basic.threadclass.MyThreadClass;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Creating Thread methods");
        //==============Using Runnable Interface(implements)
        MyThreadRunnable t1 = new MyThreadRunnable();
        Thread thread1 = new Thread(t1);

        //==============Using Thread class"
        MyThreadClass t2 = new MyThreadClass();
        thread1.start();
        t2.start();
    }
}