package graphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author swethavarnaa
 */

// CSES
// Todo: Learn Union by Rank and Path Compression
public class BuildingRoads {
    private static int[] parentIds;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        int noOfNodes = Integer.parseInt(stringTokenizer.nextToken());
        int noOfEdges = Integer.parseInt(stringTokenizer.nextToken());

        int[][] edges = new int[noOfEdges][2];

        for(int i=0; i<noOfEdges; i++){
            StringTokenizer input = new StringTokenizer(reader.readLine());
            edges[i][0] = Integer.parseInt(input.nextToken());
            edges[i][1] = Integer.parseInt(input.nextToken());
        }

        parentIds = new int[noOfNodes+1];
        for(int i=1; i<=noOfNodes; i++){
            parentIds[i] = i;
        }

        // Step 1 Union - Find Connected Cities
        union(edges);

        // Step 2 Find Parents of Connected Cities
        // No Of Parents - 1 == k
        List<Integer> citiesToBeConnected = new ArrayList<>();
        for(int i=1; i<=noOfNodes; i++){
            if(parentIds[i] == i){
                citiesToBeConnected.add(i);
            }
        }



        StringBuilder result = new StringBuilder();
        result.append(citiesToBeConnected.size()-1).append("\n");
        for(int i=1; i<citiesToBeConnected.size(); i++){
            result.append(citiesToBeConnected.get(i - 1)).append(" ").append(citiesToBeConnected.get(i)).append("\n");
        }

        System.out.println(result.toString());
    }

    private static void union(int[][] edges){
       for(int[] edge: edges){
           int i = findParent(edge[0]);
           int j = findParent(edge[1]);

           parentIds[i] = j;
       }
    }

    private static int findParent(int vertex){
        while (parentIds[vertex] != vertex){
            vertex = parentIds[vertex];
        }
        return vertex;
    }
}
