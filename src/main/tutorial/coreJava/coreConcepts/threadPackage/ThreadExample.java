package main.tutorial.coreJava.coreConcepts.threadPackage;

public class ThreadExample {

    static class Counter {
        int count;
        void inc() {
            count = count+1;
        }
        int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        /**
         * Note: here we are starting 2 threads at the same time, so you can expect that sometimes
         * thread2 can execute the same task while thread1 is still in execution OR vice-versa
         * (to see it practically, i have added 1 sec sleep time in process of each thread execution)
         *
         * for that one (bad) quick way to do is add sleep time between each thread start
         */
        thread1.start();
        thread2.start();

        // this will ask main thread to wait until thread 1 and 2 is done with their job
        thread1.join();
        thread2.join();

        System.out.println("byee - should be last in the output and thread is alive? " + thread1.isAlive() + " or thread2 is alive? " + thread2.isAlive());
    }
}

class Thread1 extends Thread {

    public void run() {
        //whatever present in this run method, it will run using separate thread
        ThreadExample.Counter counter = new ThreadExample.Counter();
        for (int i = 0; i < 5; i++) {
            counter.inc();
            System.out.println(counter.getCount());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        ThreadExample.Counter counter = new ThreadExample.Counter();
        for (int i = 0; i < 5; i++) {
            counter.inc();
            System.out.println(counter.getCount());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}

