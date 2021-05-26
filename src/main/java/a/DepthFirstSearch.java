package a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author : Caroline YAN
 * @version : 1.0.0
 * @date : 2021/5/26
 */

public class DepthFirstSearch
{

    public List<Node> dfs(Graph graph, int startingNode)
    {

        List<Node> output = new ArrayList<>();
        List<Node> tmpStack = new ArrayList<>();

        output.add(graph.getNode(startingNode));
        tmpStack.add(graph.getNode(startingNode));
        graph.getNode(startingNode).setIsVisited(true);

        while (tmpStack.size() != 0)
        {
            int stackSize = tmpStack.size();
            Node lastStackNode = tmpStack.get(stackSize - 1);
            List<Integer> unvisitedNeighbors = new ArrayList<>();
            for (int neighbors : lastStackNode.getNeighbors())
            {
                for (Node node : graph.getListOfNodes())
                {
                    if (node.getLabel() == neighbors && !node.getIsVisited())
                    {
                        unvisitedNeighbors.add(node.getLabel());
                    }
                }
            }
            if (unvisitedNeighbors.size() == 0)
            {
                tmpStack.remove(lastStackNode);
            } else
            {
                int minNode = Collections.min(unvisitedNeighbors);
                output.add(graph.getNode(minNode));
                tmpStack.add(graph.getNode(minNode));
                graph.getNode(minNode).setIsVisited(true);
            }
        }
        return output;
    }


    //TODO: need rewrite
    //first rewrite
    public int cc(Graph graph, int s) {
        int count = 0;
        for (int i = 0; i < graph.getV(); i++) {
            graph.getNode(i).setIsVisited(false);
        }
        for (int i = 0; i < graph.getV(); i++) {
            if (!graph.getNode(i).getIsVisited()) {
                dfs(graph,s);
                count++;
            }
        }
        return count;
    }

    /*
    public static int cc(Graph graph, int startingNode) {

        List<Node> dfsResult = dfs(graph, startingNode);
        List<Integer> dfsResultLabel = new ArrayList<>();

        int numberOfComponents = 0;

        if (dfsResult.size() == graph.getSizeListOfNodes()) {
            numberOfComponents = 1;
        }
        else {
            for (Node node : dfsResult) {
                if (!dfsResultLabel.contains(node.getLabel())) {
                    dfsResultLabel.add(node.getLabel());
                }
            }

            startingNode = dfsResultLabel.get(0);
            cc(graph, startingNode);

            numberOfComponents++;
        }
        return numberOfComponents;

    }

     */


    public List<String> getStrData(File file) throws FileNotFoundException
    {
        List<String> graphData = new ArrayList<>();
        Scanner myReader = new Scanner(file);

        while (myReader.hasNextLine())
        {
            String data = myReader.nextLine();
            graphData.add(data);
        }

        return graphData;
    }

    public boolean isConnected(Graph graph, List<Node> output)
    {
        List<Integer> outputLabel = new ArrayList<>();
        for (Node node : output)
        {
            outputLabel.add(node.getLabel());
        }
        for (Node node : graph.getListOfNodes())
        {
            if (!outputLabel.contains(node.getLabel()))
            {
                return false;
            }
        }
        return true;
    }
}



