package Main;

import b.BreadthFirstSearch;
import graph.GraphAdjList;
import java.util.ArrayList;

/**
 * @author Xianqi LIU
 */
public class TestB
{

    public static void main(String[] args)
    {

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Input the number of vertices:");
//        int n = sc.nextInt();

        //read data from txt
        System.out.println("Read graph from <graph-BFS-SP.txt>");
        int n = 8;
        GraphAdjList graph = new GraphAdjList(n);
        graph.readGraphFromText(graph, "./src/graph-BFS-SP.txt");

        /*print */
//        graph.prints();

        /*test BFS*/
        System.out.println("Consider starting from node 5");
        BreadthFirstSearch bfsTest = new BreadthFirstSearch();
        ArrayList<Integer> bfsRoute = bfsTest.bfs(graph, 5);
        System.out.println("BFS route: " + bfsRoute);
        System.out.println(bfsTest.isConnected(graph, 5));

        //sc.close();
    }

}
