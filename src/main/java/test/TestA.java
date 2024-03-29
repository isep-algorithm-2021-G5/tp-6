package test;

import a.DepthFirstSearch;
import a.Graph;
import a.Node;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Caroline YAN
 */
public class TestA
{

    public static void main(String[] args) throws FileNotFoundException
    {

        DepthFirstSearch depthSearchFirst = new DepthFirstSearch();

        System.out.println("Read graph from <graph-BFS-SP.txt>\n");

        Scanner sc = new Scanner(System.in);
        File file = new File("./src/graph-BFS-SP.txt");
        List<String> graphData = depthSearchFirst.getStrData(file);

        Graph graph = new Graph(graphData);

        graph.initialize();
        graph.getGraph(graphData);
        graph.getListOfNodes();

        System.out.print("Node starting from: ");
        int startingNode = sc.nextInt();
        //System.out.println("Consider starting from node 5");
        //int startingNode = 5;

        System.out.print("DFS route: ");
        List<Node> dfsResult = depthSearchFirst.dfs(graph, startingNode);
        for (Node node : dfsResult)
        {
            System.out.print(node.getLabel() + " ");
        }

        System.out.println(
                "\n\nThe graph has: " + depthSearchFirst.cc(graph, startingNode) + " components");
        System.out.println(
                "The graph is connected: " + depthSearchFirst.isConnected(graph, dfsResult));

        //System.out.println(graph.getV());
    }

}
