package e;

import d.DirectedEdge;
import d.WDgraph;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author : Xuan MIAO
 * @version : 2.0.0
 * @date : 2021/5/26
 */
public class DijkstraSP
{

    private final boolean[] marked;
    private final int[] previous;
    private final double[] distance;
    private final int s;

    public DijkstraSP(WDgraph G, int s) throws IllegalArgumentException
    {
        this.s = s;
        if (!verifyNonNegative(G))
        {
            throw new IllegalArgumentException("Have negative weight");
        }
        int v = G.getV();
        marked = new boolean[v];
        previous = new int[v];
        distance = new double[v];
        int now;

        for (int i = 0; i < v; i++)
        {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[s] = 0;
        while (!isAllTrue(marked))
        {
            now = getIndexOfMin(distance, marked);
            TreeSet<DirectedEdge> edges;
            if (G.getEdges(now) != null)
            {
                edges = new TreeSet<>(G.getEdges(now));
            } else
            {
                edges = new TreeSet<>();
            }

            for (DirectedEdge d : edges)
            {
                if (distance[now] + d.weight() < distance[d.to()])
                {
                    distance[d.to()] = distance[now] + d.weight();
                    previous[d.to()] = now;
                }
            }
            marked[now] = true;

        }
    }

    public boolean hasPathTo(int v)
    {
        return distance[v] != Integer.MAX_VALUE;
    }

    public double distTo(int v)
    {
        return distance[v];
    }

    public void printSP(int v)
    {
        int pre = previous[v];
        Stack<Integer> stack = new Stack<>();
        while (pre != s)
        {
            stack.push(pre);
            pre = previous[pre];
        }
        StringBuilder str = new StringBuilder(s + " -> ");
        int size = stack.size();
        for (int i = 0; i < size; i++)
        {
            str.append(stack.pop()).append(" -> ");
        }
        str.append(v);

        System.out.println(str);

    }


    public boolean verifyNonNegative(WDgraph G)
    {

        for (DirectedEdge d : G.getAllEdges())
        {
            if (d.weight() < 0)
            {
                return false;
            }
        }
        return true;
    }

    private boolean isAllTrue(boolean[] m)
    {
        for (boolean b : m)
        {
            if (!b)
            {
                return false;
            }
        }
        return true;
    }

    private int getIndexOfMin(double[] d, boolean[] b)
    {
        double min = Double.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < d.length; i++)
        {
            if (d[i] < min && !b[i])
            {
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    public double[] getDistance()
    {return this.distance;}
}
