package graphTheory;

import java.util.*;

/**
 * @author swethavarnaa
 */

// code forces
// Don't See a point of solving this question :)
public class ValidBFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfNodes = scanner.nextInt();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=1; i<=noOfNodes; i++){
            graph.putIfAbsent(i, new TreeSet<>());
        }

        for(int i=0; i<noOfNodes-1; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // undirected graph
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int[] givenBFS = new int[noOfNodes];
        for(int i=0; i<noOfNodes; i++){
            givenBFS[i] = scanner.nextInt();
        }

        int[] newBFS = new int[noOfNodes];
        int index = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(1);
        visited.add(1);

        int level = 0;
        while (!queue.isEmpty()){
            int currentSize = queue.size();
            for(int i=0; i<currentSize; i++){
                int current = queue.remove();
                newBFS[index++] = current;
                for(int neighbour: graph.get(current)){
                    if(!visited.contains(neighbour)){
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
        }

        if(Arrays.equals(givenBFS, newBFS)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
