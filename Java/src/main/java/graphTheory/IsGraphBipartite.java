package graphTheory;

import java.util.*;

/**
 * @author swethavarnaa
 */

// leetcode
public class IsGraphBipartite {

    // If adjaceny list is provided

    private Map<Integer, Set<Integer>> edgeList;
    private int[] vertexColors;

    public boolean isBipartite(int[][] graph) {
        int noOfNodes = graph.length;
        edgeList = new HashMap<>();
        vertexColors = new int[graph.length];
        for (int i = 0; i < noOfNodes; i++) {
            edgeList.put(i, new HashSet<>());
            for (int j : graph[i]) {
                edgeList.get(i).add(j);
            }
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < noOfNodes; i++) {
            if (!visited.contains(i)) {
                if (depthFirstSearch(i, 0, visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean depthFirstSearch(int vertex, int color, Set<Integer> visited) {
        visited.add(vertex);
        vertexColors[vertex] = color;

        if (edgeList.get(vertex) != null) {
            for (int neighbour : edgeList.get(vertex)) {
                if (!visited.contains(neighbour)) {
                    if (depthFirstSearch(neighbour, ~color, visited)) {
                        return true;
                    }
                } else {
                    if (vertexColors[vertex] == vertexColors[neighbour]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // If the given input is like the one in leetcode
    public boolean isBipartiteII(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; ++start) {
            if (color[start] == -1) {
                Stack<Integer> stack = new Stack();
                stack.push(start);
                color[start] = 0;

                while (!stack.empty()) {
                    Integer node = stack.pop();
                    for (int nei : graph[node]) {
                        if (color[nei] == -1) {
                            stack.push(nei);
                            color[nei] = color[node] ^ 1;
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }


}
