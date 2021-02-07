package DynamicProgramming;

/**
 * @author swethavarnaa
 */

// Leetcode easy
public class MinCostClimbingStairs {

    // using dp table
    public int minCostClimbingStairsI(int[] cost) {
        int[] dpTable = new int[cost.length + 1];
        dpTable[0] = 0;
        dpTable[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            dpTable[i] = Math.min(cost[i - 1] + dpTable[i - 1], cost[i] + dpTable[i - 2]);
        }

        return dpTable[cost.length - 1];
    }

    // using input as dp table (more intuitive)
    public int minCostClimbingStairsII(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i] + cost[i - 1], cost[i] + cost[i - 2]);
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
