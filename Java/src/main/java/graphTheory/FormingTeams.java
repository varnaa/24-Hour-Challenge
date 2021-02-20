package graphTheory;

import java.util.*;

/**
 * @author swethavarnaa
 */

// code forces
// Same as possible - bipartition from leetcode
public class FormingTeams {
    private static Map<Integer, Set<Integer>> graph;
    private static int count = 0;
    private static int[] vertexColors;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfVertex = scanner.nextInt();
        int noOfEdges = scanner.nextInt();

        graph = new HashMap<>();
        for (int i = 1; i <= noOfVertex; i++) {
            graph.put(i, new HashSet<>());
        }
        while (noOfEdges-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        Set<Integer> visited = new HashSet<>();
        vertexColors = new int[noOfVertex + 1];
        for (int i = 1; i <= noOfVertex; i++) {
            if (!visited.contains(i)) {
                depthFirstSearch(i, visited, 1);
            }
        }
        count /= 2;
        if ((noOfVertex - count) % 2 == 1) {
            count++;
        }
        System.out.println(count);
    }

    private static void depthFirstSearch(int vertex, Set<Integer> visited, int color) {
        visited.add(vertex);
        vertexColors[vertex] = color;

        for (int neighbour : graph.get(vertex)) {
            if (!visited.contains(neighbour)) {
                depthFirstSearch(neighbour, visited, getColor(color));
            } else {
                if (vertexColors[vertex] == vertexColors[neighbour]) {
                    count++;
                }
            }
        }
    }

    private static int getColor(int color) {
        return color == 1 ? -1 : 1;
    }
}
