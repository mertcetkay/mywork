package tr.com.taughtworks.hw;

import org.junit.BeforeClass;
import org.junit.Test;
import tr.com.taughtworks.hw.algorithm.DijkstraAlgorithm;
import tr.com.taughtworks.hw.model.Edge;
import tr.com.taughtworks.hw.model.Graph;
import tr.com.taughtworks.hw.model.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mert on 20.3.2015.
 */
public class TestProblems {

    /**
     * The graph that tests run.
     */
    public static Graph graph;

    /**
     * Dijkstra algorithm to traverse the graph
     */
    public static DijkstraAlgorithm dijkstra;

    /**
     * Initializes sample graph before tests to run.
     */
    @BeforeClass
    public static void initTestEnvironment(){

        List<Vertex> vertexList = new ArrayList<Vertex>();
        List<Edge> edgeList = new ArrayList<Edge>();
        /**
         * Init vertices.
         */
        Vertex A = new Vertex("A","A");
        vertexList.add(A);
        Vertex B = new Vertex("B","B");
        vertexList.add(B);
        Vertex C = new Vertex("C","C");
        vertexList.add(C);
        Vertex D = new Vertex("D","D");
        vertexList.add(D);
        Vertex E = new Vertex("E","E");
        vertexList.add(E);
        /**
         * Init edges.
         */
        // AB5
        Edge ab5 = new Edge("AB5",A,B,5);
        edgeList.add(ab5);
        // BC4
        Edge bc4 = new Edge("BC4",B,C,4);
        edgeList.add(bc4);
        // CD8
        Edge cd8 = new Edge("CD8",C,D,8);
        edgeList.add(cd8);
        // DC8
        Edge dc8 = new Edge("DC8",D,C,8);
        edgeList.add(dc8);
        // DE6
        Edge de6 = new Edge("DE6",D,E,6);
        edgeList.add(de6);
        // AD5
        Edge ad5 = new Edge("AD5",A,D,5);
        edgeList.add(ad5);
        // CE2
        Edge ce2 = new Edge("CE2",C,E,2);
        edgeList.add(ce2);
        // EB3
        Edge eb3 = new Edge("EB2",E,B,3);
        edgeList.add(eb3);
        // AE7
        Edge ae7 = new Edge("AE7",A,E,7);
        edgeList.add(ae7);
        /**
         * Init graph.
         */
        graph = new Graph(vertexList,edgeList);
        dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(vertexList.get(0));
    }

    /**
     * Tests the distance of the route A-B-C
     */
    @Test
    public void testCaseOne(){

    }

    /**
     * Tests the distance of the route A-D.
     */
    @Test
    public void testCaseTwo(){

    }

    /**
     * Tests the distance of the route A-D-C.
     */
    @Test
    public void testCaseThree(){

    }

    /**
     * Tests the distance of the route A-E-B-C-D.
     */
    @Test
    public void testCaseFour(){

    }

    /**
     * Tests the distance of the route A-E-D.
     */
    @Test
    public void testCaseFive(){

    }

    /**
     * Tests the number of trips starting at C and ending at C with a maximum of 3 stops.
     */
    @Test
    public void testCaseSix(){

    }

    /**
     * Tests the number of trips starting at A and ending at C with exactly 4 stops.
     */
    @Test
    public void testCaseSeven(){

    }

    /**
     * Tests the length of the shortest route from A to C.
     */
    @Test
    public void testCaseEight(){

    }

    /**
     * Tests the length of the shortest route from B to B.
     */
    @Test
    public void testCaseNine(){

    }

    /**
     * Tests the number of different routes from C to C with a distance of less than 30.
     */
    @Test
    public void testCaseTen(){

    }

}
