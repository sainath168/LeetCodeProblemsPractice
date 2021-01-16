package main.algorithmsAndDataStructure.dp;

public class KnapSackProblem {
    public static void main(String[] args) {

        int[] weights = new int[]{1, 3, 4, 5};
        int[] values = new int[]{10, 40, 50, 70};

        int knapsack = 8;

        // get the max value of the weights that can fit in knapsack
        int result = knapsack(weights, values, knapsack);
        System.out.println(result);

    }


    /**
     * Assumption: the weights input are in ascending order
     * @param weights
     * @param values
     * @param knapsack
     * @return
     */
    static int knapsack(int[] weights, int[] values, int knapsack) {

        // initialize the dp array with size [weights][knapsack]
        // for first weight row, check if can fit in respective column knapsack,
        //          if not set as 0,
        //          if so, then assign the respective weight's value
        // FROM sec weight row, check if can fit in respective column knapsack
        //          if not (w > k), then you can set same that was able to set with previous weights [w-1][k]
        //          if so (w <= k), then check if we can get previous computed value ===========> DYNAMIC PROGRAMMING
        //              i.e lets say for i = 3 i.e. weight = 5, that includes weights = {1,3,4,5}
        //              and j = 7, i.e given knapsack = 7,
        //              then instead of calculating each combination to get how much we can fit in given knapsack,
        //              instead we can use the previous values i.e for weights {1,3,4} in knapsack (7 - 5) i.e. 2
        //              So,        {1,3,4,5} in 7 knapsack  =  (value obtained for {1,3,4} with k = 2)  +  value for {5}
        //              similarly, {1,3,4,5} in 8 knapsack  =  (value obtained for {1,3,4} with k = 3)  +  value for {5}
        //              similarly, {1,3,4} in 5 knapsack  =  (value obtained for {1,3} with k = 1)  +  value for {4}
        //              similarly, {1,3} in 5 knapsack  =  (value obtained for {1} with k = 2)  +  value for {3}
        //              similarly, {1,3} in 6 knapsack  =  (value obtained for {1} with k = 3)  +  value for {3}

        int[][] dp = new int[weights.length][knapsack + 1];

        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j <= knapsack; j++) {
                if (j == 0) {
                    // in 0 weight knapsack, of course you can't fill any weight so put value 0 (optional as default int value will be 0 but helpful algo understanding purpose)
                    dp[i][j] = 0;
                    continue;
                }

                if (i == 0) {
                    if (weights[i] <= j) {
                        // then this weight can fit in 'j' knapsack
                        dp[i][j] = values[i]; // fill the dp with value, as our target is max value and not weight(s)
                    } else {
                        // then this weight cannot fit in 'j' knapsack
                        dp[i][j] = 0; // again this will be 0 by default, but helpful for algo understanding
                    }

                    continue;
                }

                if (weights[i] <= j) {
                    // this should execute only if i > 0 (from second row) where we actually start using the previous values
                    dp[i][j] = Math.max(dp[i-1][j - weights[i]] + values[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }

            }
        }


        return dp[weights.length - 1][knapsack];
    }
}
