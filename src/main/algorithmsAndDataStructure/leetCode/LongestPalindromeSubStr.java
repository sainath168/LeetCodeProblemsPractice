package main.algorithmsAndDataStructure.leetCode;

public class LongestPalindromeSubStr {
    public static void main(String[] args) {
        String s = "abazyxwvutsrqp";

        System.out.println(s.contains("yz"));

        //System.out.println(longestPalindrome(s));
    }

    private static String longestPalindrome(String str) {

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return "not a palindrome";
            }
        }
        return "palindrome";
    }
}
