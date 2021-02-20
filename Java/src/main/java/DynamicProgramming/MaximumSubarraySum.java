package DynamicProgramming;

/**
 * @author swethavarnaa
 */
public class MaximumSubarraySum {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = nums[0];
            int[] dpTable = new int[nums.length + 1];
            dpTable[0] = maxSum;
            for (int i = 1; i < nums.length; i++) {
                dpTable[i] = Math.max(dpTable[i - 1] + nums[i], nums[i]);
                maxSum = Math.max(maxSum, dpTable[i]);
            }
            return maxSum;
        }
    }

    /*
        Goal: Maximum Subarray

        Case 1: Positive Number
                    -> guaranteed to increase our sum
                    -> hence add it to the sum
        Case 2: Negative Number
                    -> Guaranteed to decrease our sum
                    -> Hence discard the sum
    */
    static class SolutionII {
        public int maxSubArray(int[] nums) {
            int result = nums[0];
            int sum = 0;
            for (int i : nums) {
                if (sum >= 0) {
                    sum += i;
                } else
                    sum = i;
                result = Math.max(result, sum);
            }
            return result;
        }
    }

}
