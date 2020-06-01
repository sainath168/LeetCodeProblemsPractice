package tutorial.coreJava.oopConcepts;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class SampleClass {
    public static void main(String[] args) {




        /**
         * ArrayIndexOutOfBoundsException example
         * int[] arr = new int[2];
        System.out.println(arr[-1]);*/


        Queue<Integer> dummyQueue = new PriorityQueue<>();
        dummyQueue.add(5);

        dummyQueue.remove();

        /**
         *
         * Deque example
         *
            Deque<Integer> dummy = new ArrayDeque<Integer>();
            dummy.addFirst(2);
            dummy.addLast(3);
        */

        /*SampleObject sampleObject1 = new SampleObject();

        SampleObject sampleObject2 = new SampleObject();

        sampleObject1.a = 1;

        try
        {
            sampleObject2 = (SampleObject) sampleObject1.clone();
        }
        catch(Exception e) {
            System.out.println("some error");
        }

        sampleObject1.a = 2;

        System.out.println(sampleObject2.a);*/

    }

    static class SampleObject implements Cloneable {
        int a;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
