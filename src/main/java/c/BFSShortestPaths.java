package c;

import graph.DiGraphAdjList;

import java.util.*;

/**
 * @author : Xianqi LIU
 * @version : 1.0.0
 * @date : 2021/5/20
 */
public class BFSShortestPaths
{
    private boolean[] marked;
    private int[] previous;
    private int[] distance;
    private int s;

    public void bfs(DiGraphAdjList graph, int s){

        this.s = s;
        marked = new boolean[graph.getTotalVertex()];
        previous = new int[graph.getTotalVertex()];
        distance = new int[graph.getTotalVertex()];

        for(int i=0; i<graph.getTotalVertex(); i++){
            distance[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        marked[s] = true;
        distance[s] = 0;

        while(queue.size()!=0){
            int v = queue.poll();
            for(int w : graph.getAdjList().get(v)){
                if(!marked[w]){
                    queue.add(w);
                    marked[w] = true;
                    previous[w] = v;
                    distance[w] = distance[v] + 1;
                }
            }

        }
    }

    // return true if there is a path from s to v
    public boolean hasPathTo(int v){
        return marked[v];
    }

    // return the length pf the shortest path from s to v
    public int distTo(int v){
        return distance[v];
    }

    // print the shortest path from s to v
    public List<Integer> printSP(int v){
        if(!hasPathTo(v)){
            System.out.println("There's no path from "+s+" to "+v);
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for(x=v; distance[x]!=0; x=previous[x]){
            path.push(x);
        }
        path.push(x);
        Collections.reverse(path);
        System.out.println(path);
        return path;
    }

}
