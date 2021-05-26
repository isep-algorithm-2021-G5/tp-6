package d;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * @author : Xuan MIAO
 * @version : 1.0.0
 * @date : 2021/5/26
 */
public class WDgraph
{

    private final int v;
    private final TreeMap<Integer, HashSet<DirectedEdge>> adjList = new TreeMap<>();
    private int e = 0;

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
        HashSet<DirectedEdge> hashSet;
        DirectedEdge directedEdge = new DirectedEdge(from, to, weight);

        if (adjList.get(from) == null)
        {
            hashSet = new HashSet<>();
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
        HashSet<DirectedEdge> hashSet;
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

    public int getE()
    {return this.e;}

    public int getV()
    {return this.v;}
}
