package graph;

import a.Node;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private static List<String> graphData = new ArrayList<>();
    private static List<List<Node>> adjacent = new ArrayList<>();
    private List<Node> listOfNodes = new ArrayList<>();

    public Graph(List<String> graphData) {

        this.graphData = graphData;
    }

    public List<List<Node>> getAdj() {

        return adjacent;
    }

    public List<Node> getListOfNodes() {
        return listOfNodes;
    }

    public void initialize() {
        this.adjacent = getGraph(graphData);
        this.listOfNodes = getListOfNodes(adjacent);
        getEdge(graphData);
    }

    public static List<List<Node>> getGraph(List<String> graphData) {
        List<List<Node>> graph = new ArrayList<>();

        String[] graphStringRow;
        List<Integer> graphIntRow = new ArrayList<>();

        for (int i = 0; i<graphData.size(); i++) {
            graphStringRow = graphData.get(i).split(" ");
            for (int index = 0; index<graphStringRow.length; index++) {
                Integer node = Integer.parseInt(graphStringRow[index]);
                graphIntRow.add(node);
            }
            graph.add(lineValues(graphIntRow.get(0),graphIntRow.get(1)));

            graphIntRow.remove(1);
            graphIntRow.remove(0);
        }
        return graph;
    }

    public List<Node> getListOfNodes(List<List<Node>> graph){
        List<Node> listOfNodes = new ArrayList<>();
        List<Integer> intListOfNodes = new ArrayList<>();

        for (List<Node> line : graph) {
            for (int j = 0; j<2; j++) {
                if (intListOfNodes.size() == 0) {
                    intListOfNodes.add(line.get(j).getLabel());
                } else {
                    if ( !intListOfNodes.contains(line.get(j).getLabel()) ) {
                        intListOfNodes.add(line.get(j).getLabel());
                    }
                }
            }
        }
        for (Integer node : intListOfNodes) {
            Node newNode = new Node();
            newNode.setLabel(node);
            listOfNodes.add(newNode);
        }
        return listOfNodes;
    }

    public Node getNode(int nodeLabel) {
        Node nodeSearched = new Node();
        for (Node node : this.listOfNodes) {
            if (node.getLabel() == nodeLabel) {
                nodeSearched = node;
            }
        }
        return nodeSearched;
    }

    public void getEdge(List<String> graphData) {
        String[] strGraphRow;
        List<Integer> intGraphRow = new ArrayList<>();

        for (int i = 0; i < graphData.size(); i++) {
            strGraphRow = graphData.get(i).split(" ");

            for (int index = 0; index<strGraphRow.length; index++) {
                Integer node = Integer.parseInt(strGraphRow[index]);
                intGraphRow.add(node);
            }
            addEdge(intGraphRow.get(0),intGraphRow.get(1));

            intGraphRow.remove(1);
            intGraphRow.remove(0);
        }
    }

    public void addEdge(int u, int v) {
        for (Node node : this.listOfNodes) {
            if (u == v && node.getLabel() == u) {
                node.getNeighbors().add(u);
            } else {
                if (node.getLabel() == u && !node.getNeighbors().contains(v)) {
                    node.getNeighbors().add(v);
                }
                if (node.getLabel() == v && !node.getNeighbors().contains(u)) {
                    node.getNeighbors().add(u);
                }
            }
        }
    }

    public static List<Node> lineValues(int i, int j) {
        List<Node> tmp = new ArrayList<>();

        Node iNode = new Node();
        iNode.setLabel(i);

        Node jNode = new Node();
        jNode.setLabel(j);

        tmp.add(iNode);
        tmp.add(jNode);

        return tmp;
    }
}
