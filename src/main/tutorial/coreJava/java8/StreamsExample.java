package main.tutorial.coreJava.java8;

import java.util.Arrays;
import java.util.List;

public class StreamsExample {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens"),
                new Person("Lewis", "Carroll"),
                new Person("Thomas", "Carlyle")
        );

        people.stream()
                .filter(person -> person.getLastName().startsWith("D")) //this accepts Predicate<> which target basically a lambda (and returns boolean)
                .forEach(person -> System.out.println(person));
    }
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
