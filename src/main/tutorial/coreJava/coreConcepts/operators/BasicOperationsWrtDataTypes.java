package main.tutorial.coreJava.coreConcepts.operators;

public class BasicOperationsWrtDataTypes {

    static int getCount(String str) {
        int vowelsCount = (int) str.chars()
                .filter(c -> "aeiou".indexOf(c) >= 0)
                .count();


        return vowelsCount;
    }

    public static void main(String[] args) {
        System.out.println(getCount("sainath"));
        System.out.println(getCount("madam"));
    }
}
