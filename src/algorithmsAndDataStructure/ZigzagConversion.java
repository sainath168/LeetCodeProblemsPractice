package algorithmsAndDataStructure;

import java.util.Random;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        String zigzag = "";
        char[][] arr = new char[numRows][s.length()];
        int counter = 0;


        for (int i = 0; counter < s.length(); i++) {
            for (int j = 0; j <= getRandomNumber(numRows) && counter < s.length(); j++) {
                arr[j][i] = s.charAt(counter);
                counter = counter + 1;
            }
        }

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; (arr[i] != null && j < arr[i].length); j++) {
                if (arr[i][j] != 0) {
                    zigzag += arr[i][j];
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        return zigzag;
    }

    //return random number between 1 to boundary
    int getRandomNumber(int bound) {
        Random random = new Random();
        return random.nextInt(bound - 1) + 1;
    }

    public static void main(String[] args) {
        ZigzagConversion obj = new ZigzagConversion();
        System.out.println(obj.convert("PAYPALISHIRING", 3));
    }
}
