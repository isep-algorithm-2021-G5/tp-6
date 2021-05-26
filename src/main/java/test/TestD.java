package test;

import d.WDgraph;
import java.io.IOException;

/**
 * @author : Xuan MIAO
 * @version : 1.0.0
 * @date : 2021/5/26
 */
public class TestD
{

    private static final String FILE_PATH = "./src/graph-WDG.txt";

    public static void main(String[] args) throws IOException
    {

        WDgraph wDgraph = new WDgraph(FILE_PATH);
        wDgraph.print();


    }
}
