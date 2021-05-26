package d;

import java.util.Objects;

/**
 * @author : Xuan MIAO
 * @version : 1.0.0
 * @date : 2021/5/20
 */
public class DirectedEdge
{

    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v, int w, int weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from()
    {
        return v;
    }

    public int to()
    {
        return w;
    }

    public double weight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return v + " -> " + w + "  (" + String.format("%5.2f", weight) + ")";
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        DirectedEdge that = (DirectedEdge) o;
        return v == that.v && w == that.w && Double.compare(that.weight, weight) == 0;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(v, w, weight);
    }
}
