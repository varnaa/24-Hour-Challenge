package graphTheory;

import java.util.*;

/**
 * @author swethavarnaa
 */
// Leetcode
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Step 1 Create the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();

        // initialize graph
        for (int i = 1; i <= n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }

        // Add the edges
        for (int[] time : times) {
            // Key -> Vertex u
            // Value = in[] {vertex v, weight of reaching v from u}
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        // Step 2: Create Distance Array
        int[] distance = new int[n + 1];

        // initialize distance Array
        Arrays.fill(distance, -1);

        // Step 3: Dijkstra Algorithm
        return dijkstraAlgorithm(distance, graph, k, n);
    }

    private int dijkstraAlgorithm(int[] distance, Map<Integer, List<int[]>> graph, int source, int n) {

        // Step 1: Update the distance of source vertex
        distance[source] = 0;


        // Step 2: initialize datastructures required for bfs
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // [0] - Vertex
        // [1] - distance (only used to sort the queue)
        minheap.offer(new int[]{source, distance[source]});


        while (!minheap.isEmpty()) {
            int currentVertex = minheap.poll()[0];
            for (int[] connection : graph.get(currentVertex)) {

                int neighbour = connection[0];
                int weight = connection[1];

                int newDistance = distance[currentVertex] + weight;
                if (distance[neighbour] == -1 || newDistance < distance[neighbour]) {
                    distance[neighbour] = newDistance;
                    minheap.offer(new int[]{neighbour, distance[neighbour]});
                }
            }
        }


        // Step 3: Calculate Max Delay Time
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == -1) {
                return -1; // message failed to reach all destinations
            }
            result = Math.max(result, distance[i]);
        }

        return result;
    }
}
