package Main;

import a.DepthSearchFirst;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import a.Node;
import graph.Graph;

import static a.DepthSearchFirst.*;

public class TestA
{

    public static void main(String[] args) throws FileNotFoundException {

        DepthSearchFirst depthSearchFirst = new DepthSearchFirst();

        System.out.println("Read graph from <graph-BFS-SP.txt>\n");

        Scanner sc = new Scanner(System.in);
        File file = new File("./src/graph-BFS-SP.txt");
        List<String> graphData = depthSearchFirst.getStrData(file);

        Graph graph = new Graph(graphData);

        graph.initialize();
        graph.getGraph(graphData);
        graph.getListOfNodes();

        //System.out.print("Node starting from: ");
        //int startingNode = sc.nextInt();
        System.out.println("Consider starting from node 5");

        System.out.print("DFS route: ");
        List<Node> dfsResult = depthSearchFirst.dfs(graph, 5);
        for (Node node : dfsResult) {
            System.out.print(node.getLabel() + " ");
        }

        System.out.println("\n\nThe graph has: " + depthSearchFirst.cc(dfsResult) + " components");
        System.out.println("The graph is connected: " + depthSearchFirst.isConnected(graph, dfsResult));
    }

}
