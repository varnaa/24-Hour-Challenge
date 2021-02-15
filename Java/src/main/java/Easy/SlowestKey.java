package Easy;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author swethavarnaa
 */
public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        HashMap<Character, Integer> map = new HashMap<>();

        map.put(keysPressed.charAt(0), releaseTimes[0]);

        for (int i = 1; i < keysPressed.length(); i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            char current = keysPressed.charAt(i);

            if (map.get(current) == null || map.get(current) < time) {
                map.put(current, time);
            }
        }

        PriorityQueue<Character> maxheap = new PriorityQueue<>((a, b) ->
                map.get(a) == map.get(b) ? a - b : map.get(a) - map.get(b));

        for (char c : map.keySet()) {
            maxheap.offer(c);
            if (maxheap.size() > 1) {
                maxheap.poll();
            }
        }

        return maxheap.poll();
    }
}
