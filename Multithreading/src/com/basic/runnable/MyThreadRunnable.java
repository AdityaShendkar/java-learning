package com.basic.runnable;

public class MyThreadRunnable implements Runnable  {
    @Override
    public void run() {
        // task for thread
        for (int i = 0; i < 10 ; i++) {
            System.out.println("Runnable Thread: " + i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
