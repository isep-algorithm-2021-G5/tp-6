package b;

import graph.GraphAdjList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Xianqi LIU
 * @version : 1.0.0
 * @date : 2021/5/20
 */
public class BreadthSearchFirst
{
    // Mark all the nodes as not visited(by default set as false)
    private boolean[] visited;
    public ArrayList<Integer> bfs(GraphAdjList graph, int start){
        visited = new boolean[graph.getTotalVertex()];

        // a list to store the route
        ArrayList<Integer> route = new ArrayList<>();
        // a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[start] = true;
        queue.add(start);

        while(queue.size()!=0){
            // Dequeue a node from queue
            start = queue.poll();
            // and store into the route list
            route.add(start);

            // Get all neighbors of the dequeued node s
            // If a neighbor has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = graph.Neighbor(start).listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return route;
    }

    // return 1 means it is connected
    public int isConnected(GraphAdjList graph, int s) {
        int count = 0;
        visited = new boolean[graph.getTotalVertex()];
        for (int i=0; i<graph.getTotalVertex(); i++){
            if(!visited[i]){
                bfs(graph,s);
                count++;
            }
        }
        return count;
    }
}
