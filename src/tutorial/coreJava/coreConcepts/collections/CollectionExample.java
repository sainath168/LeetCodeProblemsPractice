package tutorial.coreJava.coreConcepts.collections;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionExample {
    public static void main(String[] args) {

        ComparableExample listExample = new ComparableExample();
        listExample.example();

    }

    static class CollectionInterfaceExample {
        public void example() {
            Collection values = new ArrayList();

            values.add(4);
            values.add("sai");
            values.add(6);

            //Iterator is an interface and provides some iterates over the collection
            Iterator it = values.iterator();

            //we can use this for getting the value (and next value so on...)
            // it.next();

            //this returns boolean which shows if there is next element or not
            // it.hasNext();

            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }


    static class ListExample {
        /**
         * List interface inherits Collection interface and provides some extra features
         * Remember,
         * - insertion order is preserved
         * - and you can use index numbers to do operations
         */
        public void example() {
            List values = new ArrayList();

            values.add(4);
            values.add("sai");
            values.add(6);

            /**
             * example for index usage
             */
            values.add(2, 10);

            //Iterator is an interface and provides some iterates over the collection
            Iterator it = values.iterator();

            //we can use this for getting the value (and next value so on...)
            // it.next();

            //this returns boolean which shows if there is next element or not
            // it.hasNext();

            /*while (it.hasNext()) {
                System.out.println(it.next());
            }*/

            /**
             * we can use for loop
             */
            for (Object a : values) {
                System.out.println(a);
            }
        }
    }

    static class GenericsExample {
        /**
         * above class shows examples of a list where you can add any datatype values
         * but in java we should make everything as type-safe as much as possible
         */

        public void example() {
            List<Integer> list = new ArrayList<>();
            list.add(4);
            //this below line now throws error, because it will accepts only the type mentioned in generics
            /*list.add("das");*/

            for (Integer a : list) {
                //...
            }
        }
    }

    static class CollectionsClassExample {
        /**
         * Collections is a class that provides you many static utility methods for objects of Collection type
         */
        public void example() {
            List<Integer> list = new ArrayList<>();
            list.add(4);
            list.add(2);
            list.add(10);
            list.add(6);

            Collections.sort(list); //sorts the list in ascending order

            Collections.reverse(list); // reverse the order of the the values in the list

            for (Integer a : list) {
                System.out.println(a);
            }
        }
    }

    static class ComparatorExample {
        public void example() {
            List<Integer> list = new ArrayList<>();
            list.add(404);
            list.add(203);
            list.add(101);
            list.add(622);

            //if i want to sort the values in the list based on the last digit of each number?
            //so, this requires custom sort logic

            /**
             * one of the sort overloaded methods, accept list and Comparator interface type object.
             * As Comparator is an interface, you need to either create a class that implements
             * Comparator interface and override compare() method and write logic...
             * same can be done by creating "anonymous class extending interface" like below
             */

            //Note: below we can also use lambda expression

            Comparator<Integer> comparator = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    //Note: 1 indicates to swap the elements and -1 to not swap
                    if (o1 % 10 > o2 % 10) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            };

            //after converting the above code to lambda expression (also used ternary operator)
            Comparator<Integer> comparator1 = (o1, o2) -> (o1 % 10 > o2 % 10) ? 1 : -1;

            Collections.sort(list, comparator1);   //or list.sort(comparator)

            for (Integer a : list) {
                System.out.println(a);
            }
        }
    }

    static class ComparableExample {
        /**
         * in above example, we have tried to sort Integer using custom sort logic (using comparator)
         * this we were able to do because Integer extends Comparable Interface
         * so basically we can only add/apply sort logic on classes that implements Comparable interface
         * that's why, below user-defined Stud class implement the Comparable interface (like Integer class)
         */
        public void example() {

            List<Stud> studs = new ArrayList<>();

            studs.add(new Stud("sai", 100));
            studs.add(new Stud("nath", 300));
            studs.add(new Stud("kou", 50));

            Collections.sort(studs); // this should sort based on the logic written in compareTo()


            /**
             * Note: we can also pass the Comparator interface type object directly in the sort()
             * you can either do this with Comparator implementation
             * note: any sort logic applied already list would be overridden by comparator
             */

            //Collections.sort(studs, new sortByMarks());

            System.out.println(studs);

        }

        class Stud implements Comparable<Stud> {

            String name;
            int marks;


            Stud(String s, int m) {
                this.name = s;
                this.marks = m;
            }

            @Override
            public int compareTo(Stud o) {
                //remember again, 1 indicates to swap the position and -1 to not to swap
                return marks < o.marks ? 1 : -1;
            }

            @Override
            public String toString() {
                return name + " - " + marks;
            }
        }

        class sortByMarks implements Comparator<Stud> {
            @Override
            public int compare(Stud o1, Stud o2) {
                return o1.marks > o2.marks ? 1 : -1;
            }
        }

    }

    static class SetExample {
        public void example() {
            Set<Integer> values = new HashSet<>();

            values.add(44);
            values.add(36);
            values.add(28);
            values.add(36); // note: this will return false and it will not be added to set

            // note above hashset will not contain duplicate values but also
            // not maintain insertion order
            // but we have Treeset another implementation of Set which preserves the insertion order
            // however, hashset or treeset (any Set implementations) will not contain duplicate values

            Set<Integer> values1 = new TreeSet<>();

            values1.add(44);
            values1.add(36);
            values1.add(28);
            values1.add(36);

            for(Integer a : values1) {
                System.out.println(a);
            }

        }
    }

    static class MapExample {
        public void example() {
            Map<String, String> map = new HashMap<>();
            map.put("key1", "value1");
            map.put("key2", "value2");

            //again here hasmap also will not maintain/preserve insertion order

            map.get("key1"); //returns --> value1
            map.get("keyThatIsNotExisted"); //this will return null

            map.put("key2", "newValue"); //it will replace value of key2 which is already existed above

        }
    }

}
