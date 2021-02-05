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
class Vertex {
    int value;
    Set<Integer> path;

    public Vertex(int value) {
        this.value = value;
        this.path = new HashSet<>();
        addVertexToPath(value);
    }

    public void addVertexToPath(int value) {
        this.path.add(value);
    }
}

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

        Deque<Vertex> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        queue.offer(new Vertex(1));

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            if (current.value == n) {
                printResult(current.path);
                return;
            }
            for (int neighbour : graph.get(current.value)) {
                if (!visited.contains(neighbour)) {
                    Vertex newVertex = new Vertex(neighbour);
                    newVertex.path.addAll(current.path);

                    visited.add(neighbour);
                    queue.offer(newVertex);
                }
            }
        }

        System.out.println("IMPOSSIBLE");
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
