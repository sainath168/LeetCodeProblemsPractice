package main.tutorial.coreJava.coreConcepts.threadPackage;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedExample {

    static class Counter {

        /*AtomicInteger counter = new AtomicInteger();*/
        private int counter;

        /*synchronized */void increment() {
            counter++;
            //if Atomic variable is used then use below to increment
            /*counter.incrementAndGet();*/

        }

        int getCounter() {
            return counter;
        }
    }

    public static void main(String[] args) throws Exception {
        Counter obj = new Counter();

        //here main thread increment 2 times because we are calling increment 2 times
        /*obj.increment();
        obj.increment();*/


        //but lets say if i am calling thousand times with one thread and start it
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    obj.increment();
                }
            }
        });

        //lets say if I am creating abother thread and calling the same increment method 1000 times
        // but the problem here is, when i keep executing this code, I don't always see 2000 as a result
        // to solve this you have 2 ways
        // - add "synchronized" keyword for method increment
        // - use Atomic variables
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    obj.increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        //just starting it and let "main" thread to run sout print stmt then it is giving irregular results
        //so we should ask main thread to wait for thread to complete its job
        thread1.join();
        thread2.join();


        System.out.println("Count: " + obj.getCounter());

    }
}

