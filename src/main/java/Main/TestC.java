package Main;

import c.BFSShortestPaths;
import graph.DiGraphAdjList;
import java.util.Scanner;

public class TestC
{
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Input the number of vertices: 8");
//        int n = sc.nextInt();

        //read data from txt
        System.out.println("Read graph from <graph-BFS-SP.txt>");
        int n = 8;
        DiGraphAdjList graph = new DiGraphAdjList(n);
        graph.readGraphFromText(graph, "./src/graph-BFS-SP.txt");

        /*print */
//        System.out.println(graph);

        /*test BFS for shortest paths in unweighted (di)graph*/
        System.out.println("Test: BFS for shortest paths in unweighted (di)graph");
        BFSShortestPaths bfsPath = new BFSShortestPaths();
        for(int i=0; i<n; i++){
            System.out.println("source:"+i);
            bfsPath.bfs(graph,i);
            for(int j=0;j<8;j++){
                System.out.print("path to "+j+": ");
                bfsPath.printSP(j);
            }
        }

        //sc.close();
    }
}
