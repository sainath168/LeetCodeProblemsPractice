package main.tutorial.coreJava.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTutorial {

    public static void main(String[] args) {
        LambdaTutorial.example((s) -> System.out.println(s.length()));

        LambdaTutorial.example2((s) -> s.length());
        //above lambda can be replaced with method reference i.e ( Class::MethodName )
        //here, length method in String class is triggered, so that can be written like below
        LambdaTutorial.example2(String::length);
        //another example: System.out::println

    }

    /**
     * we cannot completely say that lambda is nothing but "it is a shortcut of creating anonymous class"
     *
     * in java lambda does "Type Inference"
     * - this means the process of identifying the type of the expression we write
     *
     *
     */

    public static void example(ExampleLambdaInterface it) {
         it.getStringLength("sainath");
    }

    public static void example2(ExampleLambdaInterface2 it) {
        System.out.println(it.getStringLength("sainath"));;
    }

    /**
     * FunctionalInterface is something forces you to have only one abstract method in the interface.
     * example of such interfaces is Runnable interface which has one abstract method i.e run() method
     * this is how java achieved backward compatibility thing after introducing new lambda style expressions
     * with respect to old interfaces
     */
    @FunctionalInterface
    interface ExampleLambdaInterface {
        void getStringLength(String s);
    }

    @FunctionalInterface
    interface ExampleLambdaInterface2 {
        int getStringLength(String s);
    }


    class LambdaExercise {
        public void example() {
            List<Person> people = Arrays.asList(
                    new Person("Charles", "Dickens"),
                    new Person("Lewis", "Carroll"),
                    new Person("Thomas", "Carlyle")
            );

            /**
             * Step1: sort list by last name
             */
            people.sort(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return o1.lastName.compareTo(o2.lastName);
                }
            });

            //now same thing using lambda
            people.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));



            //Step2: Create a method that prints all elements in the list
            for (Person p : people) {
                System.out.println(p);
            }

            //lambda way
            printConditionalList((p) -> true, people);


            //Step3: Create a method that prints all people that have last name beginning with C
            for (Person p : people) {
                if (p.lastName.startsWith("C")) {
                    System.out.println(p);
                }
            }

            //lambda style
            printConditionalList((p) -> p.lastName.startsWith("C"), people);

            //with predicate interface usage (no need of user-defined interfaces)
            printConditionalListWithPredicateInterface((p) -> p.lastName.startsWith("C"), people);

        }

        void printConditionalList(Condition c, List<Person> people) {
            for (Person p : people) {
                if (c.test(p)) {
                    System.out.println(p);
                }
            }
        }

        void printConditionalListWithPredicateInterface(Predicate<Person> c, List<Person> people) {
            for (Person p : people) {
                if (c.test(p)) {
                    System.out.println(p);
                }
            }
        }
    }

    /**
     * we have java.util.function which provides many interface (functional interfaces)
     * for example, Predicate<T> is a functional interface with abstract method test()
     * which accepts one object and returns a boolean
     *
     * so, look the code with Predicate usage
     */
    interface Condition {
        boolean test(Person p);
    }

    class Person {
        String firstName;
        String lastName;

        Person(String f, String l) {
            this.firstName = f;
            this.lastName = l;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return this.firstName + " " + this.lastName;
        }
    }

}
