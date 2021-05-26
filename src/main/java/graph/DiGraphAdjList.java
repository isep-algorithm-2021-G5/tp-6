package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DiGraphAdjList {

    /**
     * N vertex
     */
    private int N;
    /**
     * M edge
     */
    private int M;
    private List<List<Integer>> adj;

    public DiGraphAdjList(int N) {
        this.N = N;
        this.M = 0;
        adj = new ArrayList<List<Integer>>();
        for(int i = 0; i < N; i ++) {
            adj.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int u, int v){
        adj.get(u).add(v);
        M++;
    }

    public int getTotalVertex() {return this.N;}
    public int getTotalSize() {return this.M;}

    public DiGraphAdjList readGraphFromText(DiGraphAdjList graph, String file) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = br.readLine()) != null) {
                String[] neighbor = line.split(" ");
                int src = Integer.parseInt(neighbor[0]);
                int dest = Integer.parseInt(neighbor[1]);
                graph.addEdge(src, dest);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close BufferedReader
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return graph;
    }

    public List<List<Integer>> getAdjList() {
        return adj;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(N+" vertices, "+M+" edges."+"\n");
        for (int i = 0; i < N; i++) {
            s.append(String.format("%d: ", i));
            for (int j : adj.get(i)) {
                s.append(String.format("%d ", j));
            }
            s.append("\n");
        }
        return s.toString();
    }

}
