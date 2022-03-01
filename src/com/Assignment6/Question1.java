package com.Assignment6;

public class Question1 implements Runnable {
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("Implement Runnable:  "+i+" "+Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Question1 t1=new Question1();
        Mythread t2=new Mythread();
        Thread t3=new Thread(t1);

        Thread t4=new Thread(t2);
        t3.start();
        t3.join();
        t4.start();
    }
}

class Mythread extends Thread{
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println("2nd threading :"+i+" "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
