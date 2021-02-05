package graphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author swethavarnaa
 */

// DFS Solution - Print All Paths
public class MessageRoutesII {

    private static Map<Integer, Set<Integer>> graph;
    private static Set<Integer> visited = new HashSet<>();
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        graph = new HashMap<>();
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

        HashSet<Integer> path = new HashSet<>();
        path.add(1);
        depthFirstSearch(1, path);

    }

    private static void depthFirstSearch(int vertex, HashSet<Integer> path) {

        if (vertex == n) {
            printResult(path);
            return;
        }

        visited.add(vertex);
        for (int i : graph.get(vertex)) {
            if (!visited.contains(i)) {
                path.add(i);
                visited.add(i);
                depthFirstSearch(i, path);
                path.remove(i);
                visited.remove(i);
            }
        }


    }

    public static void printResult(Set<Integer> path) {
        System.out.println(path.size());
        StringBuilder result = new StringBuilder();
        for (int i : path) {
            result.append(i).append(" ");
        }
        System.out.println(result.toString());
    }
}
