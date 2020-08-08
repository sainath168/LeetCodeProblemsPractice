package main.tutorial.coreJava.coreConcepts.threadPackage;

public class ThreadWithRunnable {

    static class Counter {
        int count;
        void inc() {
            count = count+1;
        }
        int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        Runnable obj1 = new RunnableThread1();
        Runnable obj2 = new RunnableThread2();

        Thread thread1 = new Thread(obj1);
        Thread thread2 = new Thread(obj2);

        thread1.start();
        thread2.start();
        //Note: with above code it will mostly print 1234512345...
        //first 12345 because of thread1 and another 12345 due to thread2...
        //but still once in a while, you may see response like this 1123452345
        //which is because it is async, there is no restriction to say that thread2 should
        //not interfere until thread1 completely done with its job
        //Scheduler assign job to another thread if it has availability...
        //see Synchronized usage for solving this...
        //or cheap trick to add some sleep time b/w the thread's start
    }
}

/**
 * class RunnableThread1 extends Thread {
 *
 * Now, we are not extending any class because we might have multi inheritance problem
 * so it is always better to use interface --> we have Runnable interface which gives us
 * the same functionality of run()
 *
 * but in order to get benefit of thread states (start, wait, join, sleep, stop)
 * you need to have Thread object
 *
 * In order, to solve this Thread has constructor which accepts Runnable type object as parameter
 * and creates/allocates an thread object
 *
 * so here we create a class that implement Runnable interface and we create a object of this
 * class and keep Runnable as type reference, and pass it to Thread constructor.
 *
 * See main function for more details
 *
 * */

class RunnableThread1 implements Runnable {

    public void run() {
        ThreadExample.Counter counter = new ThreadExample.Counter();
        for (int i = 0; i < 5; i++) {
            counter.inc();
            System.out.println(counter.getCount());
            try {
                //Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}

class RunnableThread2 implements Runnable {
    public void run() {
        ThreadExample.Counter counter = new ThreadExample.Counter();
        for (int i = 0; i < 5; i++) {
            counter.inc();
            System.out.println(counter.getCount());
            try {
                //Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}

