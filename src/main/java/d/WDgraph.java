package d;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author : Xuan MIAO
 * @version : 1.0.0
 * @date : 2021/5/26
 */
public class WDgraph
{

    private final int v;
    private final TreeMap<Integer, TreeSet<DirectedEdge>> adjList = new TreeMap<>();
    private int e = 0;

    public WDgraph(int v)
    {
        this.v = v;

    }

    public WDgraph(String filePath)
    {
        int max = 0, from, to;
        double weight;

        try (BufferedReader in = new BufferedReader(new FileReader(filePath)))
        {
            String str;
            while ((str = in.readLine()) != null)
            {
                String[] strings = str.split(" ");
                from = Integer.parseInt(strings[0]);
                to = Integer.parseInt(strings[1]);
                weight = Double.parseDouble(strings[2]);
                max = Math.max(max, Math.max(from, to));
                addEdge(from, to, weight);
            }
        } catch (IOException fileNotFoundException)
        {
            System.out.println("File not found");
        }
        this.v = max + 1;


    }

    public void addEdge(int from, int to, double weight)
    {
        TreeSet<DirectedEdge> hashSet;
        DirectedEdge directedEdge = new DirectedEdge(from, to, weight);

        if (adjList.get(from) == null)
        {
            hashSet = new TreeSet<>();
            adjList.put(from, hashSet);
        } else
        {
            hashSet = adjList.get(from);
        }
        hashSet.add(directedEdge);
        e++;
    }

    public void print()
    {
        TreeSet<DirectedEdge> hashSet;
        System.out.println("v: " + v + " e: " + e);
        for (int i = 0; i < v; i++)
        {
            System.out.print((i) + ": ");
            hashSet = adjList.get(i);
            if (hashSet != null)
            {
                for (DirectedEdge d : hashSet)
                {
                    System.out.print(d.toString() + " | ");
                }
                System.out.println();
            }

        }
    }

    public int getV()
    {return this.v;}

    public int getE()
    {return this.e;}

    public TreeSet<DirectedEdge> getAllEdges()
    {
        TreeSet<DirectedEdge> allEdges = new TreeSet<>();
        for (int i = 0; i < v; i++)
        {
            if (adjList.get(i) != null)
            {
                allEdges.addAll(adjList.get(i));
            }
        }

        return allEdges;
    }

    public TreeSet<DirectedEdge> getEdges(int v)
    {
        return adjList.get(v);
    }
}
