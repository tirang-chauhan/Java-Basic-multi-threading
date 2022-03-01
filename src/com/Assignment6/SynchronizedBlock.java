package com.Assignment6;
class MyOtherClass {
    int counter;

    void increment() {
        synchronized (this) {
            counter++;
        }
    }

    void workerOne() {
        increment();
    }

    void workerTwo() {
        increment();
    }
}
public class SynchronizedBlock {
    public static void main(String[] args) {
        System.out.println("Thread starting: " + Thread.currentThread().getName());
        MyOtherClass myOtherClass = new MyOtherClass();
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1500; i++)
                    myOtherClass.workerOne();
            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1500; i++)
                    myOtherClass.workerTwo();
            }
        });
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter: " + myOtherClass.counter);
        System.out.println("Thread exiting: " + Thread.currentThread().getName());
    }
}
