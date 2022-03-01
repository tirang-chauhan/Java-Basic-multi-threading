package com.Assignment6;
import java.util.Random;
import java.util.concurrent.Callable;

public class Question3 implements Callable{

        public static void main(String[] args) throws Exception {

  Question3 q=new Question3();
            System.out.println("Callable Method: "+q.call());
        }

        @Override
        public Object call() throws Exception {
            Random generator = new Random();

            Integer randomNumber = generator.nextInt(5);
            Thread.sleep(randomNumber * 1000);
            return randomNumber;
        }

}
