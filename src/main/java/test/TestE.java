package test;

import d.WDgraph;
import e.DijkstraSP;
import java.io.IOException;

/**
 * @author : Xuan MIAO
 * @version : 1.0.0
 * @date : 2021/5/27
 */
public class TestE
{

    private static final String FILE_PATH = "./src/graph-WDG.txt";

    public static void main(String[] args)
    {

        WDgraph wDgraph = new WDgraph(FILE_PATH);
        DijkstraSP dijkstraSP = new DijkstraSP(wDgraph, 0);
        System.out.println("Has path to node 5? " + dijkstraSP.hasPathTo(5));
        System.out.println("Has path to node 8? " + dijkstraSP.hasPathTo(8));
        System.out.printf("Distance to 6 is: %5.2f%n", dijkstraSP.distTo(6));
        dijkstraSP.printSP(6);

    }
}
