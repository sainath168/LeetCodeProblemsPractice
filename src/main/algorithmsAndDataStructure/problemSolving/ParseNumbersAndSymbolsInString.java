package main.algorithmsAndDataStructure.problemSolving;

public class ParseNumbersAndSymbolsInString {
    public static void main(String[] args) {
        String s = "1+4-2+1";
        System.out.println(addNumbers(s));
    }

    private static int addNumbers(String str) {

        // "1+3"  =>  4
        // "1+4-2"  =>  3

        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean isAdd = c == '+';
            boolean isSubtract = c == '-';
            if (isAdd || isSubtract) {
                i = i + 1;
                if (i >= str.length()) {
                    break;
                }
                if (isAdd) {
                    total += Character.getNumericValue(str.charAt(i));
                } else {
                    total -= Character.getNumericValue(str.charAt(i));
                }
            } else {
                total += Character.getNumericValue(c);
            }
        }

        return total;
    }
}
