package d;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author : Xuan MIAO
 * @version : 1.0.0
 * @date : 2021/5/26
 */
public class WDgraph
{

    private static final String FILE_PATH = "./src/graph-WDG.txt";
    //private final int v;
    private int e;

    public WDgraph(Stream<String> stream)
    {

        stream.forEach(System.out::println);



    }

    public static void main(String[] args) throws IOException
    {



    }
}
