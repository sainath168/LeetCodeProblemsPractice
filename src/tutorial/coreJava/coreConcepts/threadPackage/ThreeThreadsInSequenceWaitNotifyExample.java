package tutorial.coreJava.coreConcepts.threadPackage;

public class ThreeThreadsInSequenceWaitNotifyExample {

    /**
     * Problem statement:
     * Print sequence of natural numbers using Three (3) Threads
     * - we can keep a limit here for example, 1...10
     */

    public static void main(String[] args) {

        RunnableTarget runnableTarget1 = new RunnableTarget(1);
        RunnableTarget runnableTarget2 = new RunnableTarget(2);
        RunnableTarget runnableTarget3 = new RunnableTarget(0);

        Thread thread1 = new Thread(runnableTarget1);
        Thread thread2 = new Thread(runnableTarget2);
        Thread thread3 = new Thread(runnableTarget3);

        thread1.start();
        thread2.start();
        thread3.start();

    }


}

class RunnableTarget implements Runnable {

    // here we create 3 threads with this Runnable class as target and for demo purpose,
    // we want to use an static dummy object for locking purpose
    static Object lock = new Object();



    //let's start with 1 and have this as static, so that you can use the same reference and print/increment everywhere
    static int number = 1;

    //remainder - this decides what thread to give permission to print and put other threads on wait
    //note: thread1 should hold always this value as 1, and thread2 as 2, and thread3 as 3 and so on based on the threads in the problem statement
    int remainder;

    RunnableTarget(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {

        synchronized (lock) {
            // once any thread enters into this then that's it other threads has to wait until current thread release this block
            // because thread objects created using this class looks for same "lock" object we created above

            while (number <= 10) {  //note: there might be few threads already entered into sync block and goto wait state so never expect only 10 numbers will be printed, if really want to avoid other threads to print more than 10, then put condition for sout stmt
                while (number % 3 != remainder) {  // 3 will be changed based on the no. of threads in the prob statment
                    //any thread that enters other than the thread we want, then we will make that thread wait and release lock object for other threads
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        System.out.println("some error while making thread to wait");
                    }
                }
                //it comes here if current thread is what we want to print the number
                System.out.println(number + " from Thread " + number % 3);
                number++;

                //release this lock object
                lock.notifyAll();
            }
        }

    }
}

