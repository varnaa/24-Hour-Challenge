package Medium;

/**
 * @author swethavarnaa
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        StringBuilder current = new StringBuilder("1");

        for (int i = 2; i <= n; i++) {
            int x = 0;
            int length = current.length();
            StringBuilder result = new StringBuilder();
            while (x < length) {
                char c = current.charAt(x);
                int j = x;

                while (j < length && current.charAt(j) == c) {
                    j++;
                }

                int count = j - x;
                result.append(count).append(c);
                x = j;
            }

            current = result;
        }

        return current.toString();
    }
}
