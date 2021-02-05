package graphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author swethavarnaa
 */

// General BFS
// TLE

public class MessageRoute {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.putIfAbsent(i, new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer edge = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(edge.nextToken());
            int y = Integer.parseInt(edge.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        Map<Integer, Integer> parents = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        queue.offer(1);
        parents.put(1, -1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == n) {
                break;
            }
            for (int neighbour : graph.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    parents.put(neighbour, current);
                    queue.offer(neighbour);
                }
            }
        }

        if (parents.get(n) == null) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        StringBuilder result = new StringBuilder();
        int k = 0;
        while (n != -1) {
            result.insert(0, n).insert(0, " ");
            n = parents.get(n);
            k++;
        }
        result.deleteCharAt(0);
        System.out.println(k);
        System.out.println(result.toString());
    }

}
