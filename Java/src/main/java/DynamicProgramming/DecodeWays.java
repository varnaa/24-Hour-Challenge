package DynamicProgramming;

/**
 * @author swethavarnaa
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = s.length();
        int[] dpTable = new int[length + 1];

        // base case
        dpTable[0] = 0; // empty string
        dpTable[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i < length; i++) {
            if (s.charAt(i - 1) != '0') {
                dpTable[i] += dpTable[i - 1];
            }

            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dpTable[i] += dpTable[i - 2];
            }
        }

        return dpTable[length];
    }
}
