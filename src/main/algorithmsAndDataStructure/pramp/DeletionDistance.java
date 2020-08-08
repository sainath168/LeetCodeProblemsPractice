package main.algorithmsAndDataStructure.pramp;

/**
 * Deletion Distance
 * The deletion distance of two strings is the minimum number of characters you need to delete in the two
 * strings in order to get the same string.
 * For instance, the deletion distance between "heat" and "hit" is 3:
 *
 * By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
 * We cannot get the same string from both strings by deleting 2 letters or fewer.'
 *
 * Given the strings str1 and str2, write an efficient function deletionDistance that returns the
 * deletion distance between them. Explain how your function works, and analyze its time and space complexities.
 *
 * Examples:
 *
 * input:  str1 = "dog", str2 = "frog"
 * output: 3
 *
 * input:  str1 = "some", str2 = "some"
 * output: 0
 *
 * input:  str1 = "some", str2 = "thing"
 * output: 9
 *
 * input:  str1 = "", str2 = ""
 * output: 0
 * Constraints:
 *
 * [input] string str1
 * [input] string str2
 * [output] integer
 */
public class DeletionDistance {

    public int deletionDistance(String str1, String str2) {

        if (str1.equalsIgnoreCase(str2)) {
            return 0;
        } else {
            // str1 should be always smaller than str2, so it will be easy for us to loop through str1 and check all
            // all the characters existence is str2 (larger one)
            if (str1.length() > str2.length()) {
                String temp = str1;
                str1 = str2;
                str2 = temp;
            }


            int matchingChars = 0;
            int pos = -1;
            for (int i = 0; i < str1.length(); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < str1.length(); j++) {
                    sb.append(str1.charAt(j));
                    if (str2.contains(sb)) {
                        int currentPos = str2.indexOf(sb.toString());
                        if (currentPos > pos) {
                            pos = currentPos;
                            matchingChars++;
                        }
                    }
                }
            }

            return (str1.length() - matchingChars) + (str2.length() - matchingChars);
        }
    }

    public static void main(String[] args) {
        DeletionDistance problem1 = new DeletionDistance();
        System.out.println(problem1.deletionDistance("awesome", "awesome"));
    }
}
