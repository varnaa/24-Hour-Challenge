package DynamicProgramming;

import java.util.TreeSet;

/**
 * @author swethavarnaa
 */
public class LongestIncreasingSubsequence {

    // O(n^2)
    public int lengthOfLIS_DP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int[] dpTable = new int[length];
        int maxLength = 1;

        for (int i = 0; i < length; i++) {
            dpTable[i] = 1;
            for (int j = 0; j < i; j++) {
                // For all numbers from index 0..j
                // if nums[j] < nums[i], then nums[i] can be appended in the sequence
                // Update the max length if optimal.
                if (nums[j] < nums[i] && dpTable[i] < 1 + dpTable[j]) {
                    dpTable[i] = 1 + dpTable[j];
                }
            }
            maxLength = Math.max(maxLength, dpTable[i]);
        }

        return maxLength;
    }

    // O(n logn)
    public int lengthOfLIS_BinarySearch(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int lengthOFLIS = 1;
        int[] sequence = new int[length + 1];
        sequence[lengthOFLIS] = nums[0];

        for (int i = 1; i < length; i++) {
            if (nums[i] > sequence[lengthOFLIS]) {
                sequence[++lengthOFLIS] = nums[i];
            } else {
                int start = 1, end = lengthOFLIS;
                while (start < end) {
                    int mid = start + (end - start) / 2;
                    if (sequence[mid] < nums[i]) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                sequence[start] = nums[i];
            }
        }

        return lengthOFLIS;
    }

    // O(n logn)
    public int lengthOfLIS_InBuilt(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            Integer lastElement = set.ceiling(i);
            if (lastElement != null) {
                set.remove(lastElement);
            }
            set.add(i);
        }

        return set.size();
    }
}
