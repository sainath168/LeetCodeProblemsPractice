package tutorial.coreJava.java8;

public class LambdaExampleWithThread {

    //below are examples of anonymous class
     Thread thread = new Thread(new Runnable() {
         @Override
         public void run() {
             printMessage();
         }
     });

    Thread thread3 = new Thread() {
        @Override
        public void run() {
            printMessage();
        }
    };

    //below is same example with lambda

     Thread thread1 = new Thread(() -> printMessage());

    //below is same example with method reference

     Thread thread2 = new Thread(LambdaExampleWithThread::printMessage);


     public static void printMessage() {
         System.out.println("Hello");
     }
}
