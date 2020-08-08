package main.tutorial.coreJava.coreConcepts.strings;

import java.util.Objects;

public class Palindrome {

    static boolean isPalindrome(String str) {
        boolean isPalindrome = true;
        if (Objects.nonNull(str)) {
            for (int i = 0; i < (str.length() / 2); i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    isPalindrome = false;
                    break; //avoid unnecessary loop iterations
                }
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        if (isPalindrome("sainathsaddsa")) {
            System.out.println("Is Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
