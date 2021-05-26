package test;

import c.BFSShortestPaths;
import c.DiGraphAdjList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Xianqi LIU
 */
public class TestC
{

    public static void main(String[] args)
    {

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
        for (int i = 0; i < n; i++)
        {
            //System.out.println("source:"+i);
            bfsPath.bfs(graph, i);
            List<Integer> ec = new ArrayList<>();
            for (int j = 0; j < n; j++)
            {
                System.out.print("Shortest path( " + i + " to " + j + " ): ");
                System.out.println(bfsPath.printSP(j));
                if (bfsPath.hasPathTo(j))
                {
                    ec.add(bfsPath.distTo(j));
                    //System.out.println("Shortest distance( "+i+" to "+j+" ): "+bfsPath.distTo(j));
                }
            }
            System.out.println("node " + i + " eccentricity: " + Collections.max(ec));
        }

        //sc.close();
    }
}
