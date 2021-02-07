package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author swethavarnaa
 */
public class ClimbingStairs {
    private static final Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {

        // recursion
        System.out.println(usingRecursion(5));

        // recursion + memoization
        System.out.println(usingRecursionAndMemo(10));


        // using dpTable
        System.out.println(usingDp(15));


        // using two variables
        System.out.println(usingVar(25));

    }

    private static int usingRecursion(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        // same as fibonacci series
        return usingRecursion(n - 1) + usingRecursion(n - 2);
    }

    private static int usingRecursionAndMemo(int n) {
        if (n == 1 || n == 2) {
            return n == 1 ? 1 : 2;
        }

        if (memo.get(n) != null) {
            return memo.get(n);
        }

        int result = usingRecursion(n - 1) + usingRecursion(n - 2);
        memo.put(n, result);
        return result;
    }


    private static int usingDp(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return (n == 0 || n == 1) ? 1 : 2;
        }

        int[] dpTable = new int[n + 1];
        dpTable[0] = 1;
        dpTable[1] = 1;

        for (int i = 2; i <= n; i++) {
            dpTable[i] = dpTable[i - 1] + dpTable[i - 2];
        }

        return dpTable[n];
    }

    private static int usingVar(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return (n == 0 || n == 1) ? 1 : 2;
        }

        int first = 1;
        int second = 1;

        for (int i = 2; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}
