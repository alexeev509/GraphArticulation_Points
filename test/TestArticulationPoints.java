import com.company.Main;
import org.junit.Assert;
import org.junit.Test;

import java.io.StringWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class TestArticulationPoints {
    @Test
    public void testDFSMethod() throws Exception {
        StringWriter output = new StringWriter();
        String input = "5\n"       // "Wrong number, try again."
                + "7\n"
                + "0\n"
                + "1\n"
                + "1\n"
                + "2\n"
                + "2\n"
                + "0\n"
                + "3\n"
                + "2\n"
                + "4\n"
                + "3\n"
                + "4\n"
                + "2\n"
                + "5\n"
                + "4\n";
        Main.generateRandomGraph(new Scanner(input));
        Main.printGraph();
        Main.DFS(0);
        Map<Integer, Boolean> mapOfNodes = Main.getMapOfNodes();
        for (Map.Entry<Integer, Boolean> entry : mapOfNodes.entrySet()) {
            Assert.assertTrue(entry.getValue());
        }
    }
}
