package DynamicProgramming;

/**
 * @author swethavarnaa
 */

// leetcode
public class MinimumFallingPathSum {
    private int[][] memo;
    private int rowLength;
    private int colLength;

    // Dynamic Programming
    public int minFallingPathSum(int[][] matrix) {
        int length = matrix.length;
        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j < length; j++) {

                int currentBest = matrix[i + 1][j];
                if (j > 0) {
                    currentBest = Math.min(currentBest, matrix[i + 1][j - 1]);
                }

                if (j + 1 < length) {
                    currentBest = Math.min(currentBest, matrix[i + 1][j + 1]);
                }

                matrix[i][j] += currentBest;
            }
        }


        int minSum = Integer.MAX_VALUE;
        for (int i : matrix[0]) {
            minSum = Math.min(i, minSum);
        }


        return minSum;
    }

    // recursion + memoization
    public int minFallingPathSumII(int[][] matrix) {

        rowLength = matrix.length;
        if (rowLength == 0) {
            return 0;
        }
        colLength = matrix[0].length;
        if (colLength == 0) {
            return 0;
        }

        memo = new int[rowLength][colLength];
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < colLength; j++) {
            minSum = Math.min(minSum, pathMin(0, j, matrix));
        }

        return minSum;
    }

    private int pathMin(int i, int j, int[][] matrix) {

        if (i < 0 || j < 0 || i >= rowLength || j >= colLength) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int left = pathMin(i + 1, j - 1, matrix);
        int mid = pathMin(i + 1, j, matrix);
        int right = pathMin(i + 1, j + 1, matrix);

        int result = min(left, mid, right);
        memo[i][j] = matrix[i][j] + (result == Integer.MAX_VALUE ? 0 : result);

        return memo[i][j];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
