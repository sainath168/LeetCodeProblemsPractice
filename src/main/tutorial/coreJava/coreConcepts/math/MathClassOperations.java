package main.tutorial.coreJava.coreConcepts.math;

import java.util.Random;

public class MathClassOperations {
    public static void main(String[] args) {
        boolean aliceWins = false;
        int N = 102;

        int i = 0;
        while (N > 1) {
            i++;
            int chosen = getRandom(N);
            if (chosen == 0) {
                chosen = 1;
            }
            N = N - chosen;
            if (N <= 1) {
                // its time to decide who is the winner, there is no need to give chance to another player as there is only one last chance
                // hence concluded other player is lost
                if (i%2 != 0) {
                    aliceWins = true;
                }
                System.out.println(aliceWins);
                break;
            }
        }
    }

    private static int getRandom(int N) {
        while (true) {
            int random = new Random().nextInt(N - 1);
            if (random % N == 0) {
                return random;
            }
        }
    }
}
