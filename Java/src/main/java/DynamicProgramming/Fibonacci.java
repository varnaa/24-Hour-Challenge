package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author swethavarnaa
 */
public class Fibonacci {
    private static final Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        // Basic recursion
        System.out.println(recursion(6));

        // Recursion + Memoization
        System.out.println(memo(10));

        // Dynamic Programming
        System.out.println(dp(25));
    }

    public static int recursion(int n) {
        if (n <= 1) {
            return 1;
        }

        return recursion(n - 1) + recursion(n - 2);
    }

    private static int memo(int n) {
        if (n <= 1) {
            return 1;
        }

        if (map.get(n) != null) {
            return map.get(n);
        }

        int result = memo(n - 1) + memo(n - 2);
        map.put(n, result);
        return result;
    }

    private static int dp(int n) {
        int first = 0;
        int second = 1;

        for (int i = 2; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}
