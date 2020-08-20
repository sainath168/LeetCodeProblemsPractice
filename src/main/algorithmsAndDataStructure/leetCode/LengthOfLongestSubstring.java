package main.algorithmsAndDataStructure.leetCode;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb")); //3
        /*System.out.println(lengthOfLongestSubstring("abca"));  //3
        System.out.println(lengthOfLongestSubstring("abaa"));  //2
        System.out.println(lengthOfLongestSubstring(" "));  //1
        System.out.println(lengthOfLongestSubstring(""));  //0*/
    }

    private static int lengthOfLongestSubstring(String s) {
        /*
        Approach 1: O(n)   (may be call it as DP way)
        - while looping through all elements, keep hold of the characters in a str variable (call it as non-repeated subStr)
        and reset this everytime you see a character that is already present in your str variable
        - just before the reset make sure you get the length of the str variable which was your non-repeated subStr, ONLY if the previous subStr length is less than current subStr
        */

        int maxLengthOfSubStr = 0;
        StringBuilder longestSubStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));
            int index = longestSubStr.indexOf(temp);
            if (index == -1) {
                longestSubStr.append(temp);
            } else {
                longestSubStr = new StringBuilder(String.valueOf(s.charAt(index + 1)));
                s = s.substring(index + 1);
                i = 0;
            }

            int subStrLen = longestSubStr.length();
            if (maxLengthOfSubStr < subStrLen) {
                maxLengthOfSubStr = subStrLen;
            }
        }

        return maxLengthOfSubStr;

    }
}
