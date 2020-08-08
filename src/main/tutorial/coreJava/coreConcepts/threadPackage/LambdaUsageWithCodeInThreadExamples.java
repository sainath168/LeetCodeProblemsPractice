package main.tutorial.coreJava.coreConcepts.threadPackage;

public class LambdaUsageWithCodeInThreadExamples {

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
        //this is nothing but creating anonymous class with Runnable interface
        Runnable obj1 = () -> {
            ThreadExample.Counter counter = new ThreadExample.Counter();
            for (int i = 0; i < 5; i++) {
                counter.inc();
                System.out.println(counter.getCount());
                try {
                    //Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        };
        Runnable obj2 = () -> {
            ThreadExample.Counter counter = new ThreadExample.Counter();
            for (int i = 0; i < 5; i++) {
                counter.inc();
                System.out.println(counter.getCount());
                try {
                    //Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        };

        /**
         * We can directly pass the entire thing directly in the constructor like this too
         *
         * Thread thread1 = new Thread(() -> {
         *             ThreadExample.Counter counter = new ThreadExample.Counter();
         *             for (int i = 0; i < 5; i++) {
         *                 counter.inc();
         *                 System.out.println(counter.getCount());
         *                 try {
         *                     //Thread.sleep(1000);
         *                 } catch (Exception e) {
         *
         *                 }
         *             }
         *         });
         */
        Thread thread1 = new Thread(obj1);
        Thread thread2 = new Thread(obj2);

        thread1.start();
        thread2.start();
    }
}
