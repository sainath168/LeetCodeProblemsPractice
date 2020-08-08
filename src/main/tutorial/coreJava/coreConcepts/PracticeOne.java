package main.tutorial.coreJava.coreConcepts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeOne {


    public static <E> void printStuff(E[] arr) {
        for (E x : arr) System.out.println(x);
    }


    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int random = (int)(Math.random() * 10) + 1;

        String str = "sainath";
        String str1 = "t";


        List<Integer> abc = IntStream.range(1,10).boxed().collect(Collectors.toList());

        //result = 10; then result * 2 = 20 and then result * 3 = 60;
        /*System.out.println(IntStream.range(2, 4).reduce(10, (x,y) -> x*y));*/

        /*List<int[]> abc = new ArrayList<int[]>();
        int[] arr = {1,2};
        abc.add(arr);

        List<int[]> list = Stream.iterate(new int[]{3,5}, t -> new int[]{t[1], t[0]+t[1]})
                .limit(5)
                .collect(Collectors.toList());

        Stream<int[]> a = Stream.iterate(new int[]{3,5}, t -> new int[]{t[1], t[0]+t[1]})
                .limit(5);


        list.forEach(x -> System.out.println(x[0]));*/

        System.out.println(2%1);

    }
}
