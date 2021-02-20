package DynamicProgramming;

/**
 * @author swethavarnaa
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dpTable = new int[len1 + 1][len2 + 1];

        for (int i = 1; i < dpTable.length; i++) {
            char first = text1.charAt(i - 1);
            for (int j = 1; j < dpTable[0].length; j++) {
                char second = text2.charAt(j - 1);

                // case 1;
                if (first == second) {
                    dpTable[i][j] = 1 + dpTable[i - 1][j - 1];
                } else {
                    dpTable[i][j] = Math.max(dpTable[i - 1][j], dpTable[i][j - 1]);
                }
            }
        }

        return dpTable[len1][len2];
    }
}
