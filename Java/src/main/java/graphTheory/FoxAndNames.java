package graphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author swethavarnaa
 */

// Modified Alien Dictionary From CodeForces
// ACCEPTED <3
public class FoxAndNames {
    private static Map<Character, Set<Character>> graph;
    private static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        String[] authorNames = new String[length];
        for(int i=0; i<length; i++){
            authorNames[i] = reader.readLine();
        }

        // Step 1 : Construct graph
        constructGraph(authorNames,length);

        // Step 2 : Topological Sorting
        Deque<Character> queue = new ArrayDeque<>();
        for(char key: graph.keySet()){
            if(indegree[key-'a'] == 0){
                queue.offer(key);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()){
            char current = queue.poll();
            result.append(current);
            for(char c: graph.get(current)){
                indegree[c-'a']--;
                if(indegree[c-'a'] == 0){
                    queue.offer(c);
                }
            }
        }

        if(result.length() == 26){
            System.out.println(result.toString());
        }else{
            System.out.println("Impossible");
        }
    }

    private static void constructGraph(String[] authorNames, int length){

        graph = new HashMap<>();
        indegree = new int[26];

        // Step 1: initialize Graph
        for(char i ='a'; i<='z'; i++){
            graph.putIfAbsent(i, new HashSet<>());
        }

        for(int i=1; i<length; i++){
            String author1 = authorNames[i-1];
            String author2 = authorNames[i];

            int len1 = author1.length();
            int len2 = author2.length();

            if(author1.startsWith(author2) && len1 > len2){
                graph.clear();
                return;
            }

            int minLen = Math.min(len1, len2);

            for(int j=0; j<minLen; j++){
                char out = author1.charAt(j);
                char in = author2.charAt(j);

                if(out != in){
                    if(!graph.get(out).contains(in)){
                        graph.get(out).add(in);
                        indegree[in-'a']++;
                    }
                    break;
                }
            }
        }
    }
}
