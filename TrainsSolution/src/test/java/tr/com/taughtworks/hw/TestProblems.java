package tr.com.taughtworks.hw;

import org.junit.BeforeClass;
import org.junit.Test;
import tr.com.taughtworks.hw.algorithm.DijkstraAlgorithm;
import tr.com.taughtworks.hw.algorithm.DirectedGraphDFS;
import tr.com.taughtworks.hw.model.Edge;
import tr.com.taughtworks.hw.model.Graph;
import tr.com.taughtworks.hw.model.Vertex;

import java.util.*;

import static org.junit.Assert.assertEquals;

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
     * todo
     */
    public static DirectedGraphDFS directedGraphDFS;

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
        directedGraphDFS = new DirectedGraphDFS();
        dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(vertexList.get(0));
    }

    /**
     * Tests the distance of the route A-B-C
     */
    @Test
    public void testCaseOne(){
        Vertex A = new Vertex("A","A");
        Vertex B = new Vertex("B","B");
        Vertex C = new Vertex("C","C");
        assertEquals(9,dijkstra.getDistance(A,B) + dijkstra.getDistance(B,C));
    }

    /**
     * Tests the distance of the route A-D.
     */
    @Test
    public void testCaseTwo(){
        Vertex A = new Vertex("A","A");
        Vertex D = new Vertex("D","D");
        assertEquals(5,dijkstra.getDistance(A,D));
    }

    /**
     * Tests the distance of the route A-D-C.
     */
    @Test
    public void testCaseThree(){
        Vertex A = new Vertex("A","A");
        Vertex D = new Vertex("D","D");
        Vertex C = new Vertex("C","C");
        assertEquals(13,dijkstra.getDistance(A,D) + dijkstra.getDistance(D,C));
    }

    /**
     * Tests the distance of the route A-E-B-C-D.
     */
    @Test
    public void testCaseFour(){
        Vertex A = new Vertex("A","A");
        Vertex B = new Vertex("B","B");
        Vertex C = new Vertex("C","C");
        Vertex D = new Vertex("D","D");
        Vertex E = new Vertex("E","E");

        int totalCost = 0;
        totalCost += dijkstra.getDistance(A,E);
        totalCost += dijkstra.getDistance(E,B);
        totalCost += dijkstra.getDistance(B,C);
        totalCost += dijkstra.getDistance(C,D);

        assertEquals(22,totalCost);

    }

    /**
     * Tests the distance of the route A-E-D.
     */
    @Test
    public void testCaseFive(){
        Vertex A = new Vertex("A","A");
        Vertex E = new Vertex("E","E");
        Vertex D = new Vertex("D","D");
        assertEquals(7,dijkstra.getDistance(A,E));
        assertEquals(-1,dijkstra.getDistance(E,D));
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
        Vertex C = new Vertex("C","C");
        LinkedList<Vertex> path = dijkstra.getPath(C);
        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
    }

    /**
     * Tests the length of the shortest route from B to B.
     */
    @Test
    public void testCaseNine(){

        Vertex A = new Vertex("A","A");
        Vertex B = new Vertex("B","B");
        dijkstra.execute(B);
        LinkedList<Vertex> path = dijkstra.getPath(B);
        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
        dijkstra.execute(A);
    }

    /**
     * Tests the number of different routes from C to C with a distance of less than 30.
     */
    @Test
    public void testCaseTen(){

    }

    @Test
    public void testDepthFirstSearch(){
        Vertex a = new Vertex("A","A");
        Set<Vertex> known = new HashSet<Vertex>();
        Map<Vertex,Edge> forest = new HashMap<Vertex, Edge>();
        directedGraphDFS.dfs(graph, a, known,forest);
    }

    @Test
    public void testDepthFirstSearch2(){
        Vertex c = new Vertex("C","C");
        directedGraphDFS.compute6(graph, c, null, new LinkedHashSet<Vertex>(), 3);
    }

    @Test
    public void testDepthFirstSearch3(){
        Vertex a = new Vertex("A","A");
        Vertex c = new Vertex("C","C");
        directedGraphDFS.compute7(graph, a, c, null, new LinkedHashSet<Vertex>(),4);
    }

}
