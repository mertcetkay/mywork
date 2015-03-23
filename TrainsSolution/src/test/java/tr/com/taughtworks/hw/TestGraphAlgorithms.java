package tr.com.taughtworks.hw;

import org.junit.BeforeClass;
import org.junit.Test;
import tr.com.taughtworks.hw.algorithm.DijkstraAlgorithm;
import tr.com.taughtworks.hw.algorithm.CustomGraphAlgorithms;
import tr.com.taughtworks.hw.model.Edge;
import tr.com.taughtworks.hw.model.Graph;
import tr.com.taughtworks.hw.model.Vertex;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mert on 20.3.2015.
 */
public class TestGraphAlgorithms {

    /**
     * The graph that tests run.
     */
    public static Graph graph;

    /**
     * Dijkstra algorithm to traverse the graph.
     */
    public static DijkstraAlgorithm dijkstra;

    /**
     * Custom graph algorithms specific to home assignment.
     */
    public static CustomGraphAlgorithms customGraphAlgorithms;

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
        Vertex a = new Vertex("A","A");
        vertexList.add(a);
        Vertex b = new Vertex("B","B");
        vertexList.add(b);
        Vertex c = new Vertex("C","C");
        vertexList.add(c);
        Vertex d = new Vertex("D","D");
        vertexList.add(d);
        Vertex e = new Vertex("E","E");
        vertexList.add(e);
        /**
         * Init edges.
         */
        // AB5
        Edge ab5 = new Edge("AB5",a,b,5);
        edgeList.add(ab5);
        // BC4
        Edge bc4 = new Edge("BC4",b,c,4);
        edgeList.add(bc4);
        // CD8
        Edge cd8 = new Edge("CD8",c,d,8);
        edgeList.add(cd8);
        // DC8
        Edge dc8 = new Edge("DC8",d,c,8);
        edgeList.add(dc8);
        // DE6
        Edge de6 = new Edge("DE6",d,e,6);
        edgeList.add(de6);
        // AD5
        Edge ad5 = new Edge("AD5",a,d,5);
        edgeList.add(ad5);
        // CE2
        Edge ce2 = new Edge("CE2",c,e,2);
        edgeList.add(ce2);
        // EB3
        Edge eb3 = new Edge("EB2",e,b,3);
        edgeList.add(eb3);
        // AE7
        Edge ae7 = new Edge("AE7",a,e,7);
        edgeList.add(ae7);
        /**
         * Init graph.
         */
        graph = new Graph(vertexList,edgeList);
        customGraphAlgorithms = new CustomGraphAlgorithms();
        dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(vertexList.get(0));
    }

    /**
     * Tests the distance of the route A-B-C
     */
    @Test
    public void testDistance_ABC() throws Exception {
        LinkedList<Vertex> route = new LinkedList();
        route.add(new Vertex("A","A"));
        route.add(new Vertex("B","B"));
        route.add(new Vertex("C","C"));
        assertEquals(9,customGraphAlgorithms.getDistanceOfPath(route,graph));
    }

    /**
     * Tests the distance of the route A-D.
     */
    @Test
    public void testDistance_AD() throws Exception {
        LinkedList<Vertex> route = new LinkedList();
        route.add(new Vertex("A","A"));
        route.add(new Vertex("D","D"));
        assertEquals(5,customGraphAlgorithms.getDistanceOfPath(route,graph));
    }

    /**
     * Tests the distance of the route A-D-C.
     */
    @Test
    public void testCaseThree() throws Exception {
        LinkedList<Vertex> route = new LinkedList();
        route.add(new Vertex("A","A"));
        route.add(new Vertex("D","D"));
        route.add(new Vertex("C","C"));
        assertEquals(13,customGraphAlgorithms.getDistanceOfPath(route,graph));
    }

    /**
     * Tests the distance of the route A-E-B-C-D.
     */
    @Test
    public void testCaseFour() throws Exception {
        LinkedList<Vertex> route = new LinkedList();
        route.add(new Vertex("A","A"));
        route.add(new Vertex("E","E"));
        route.add(new Vertex("B","B"));
        route.add(new Vertex("C","C"));
        route.add(new Vertex("D","D"));
        assertEquals(22,customGraphAlgorithms.getDistanceOfPath(route,graph));
    }

    /**
     * Tests the distance of the route A-E-D.
     */
    @Test(expected = Exception.class)
    public void testCaseFive(){
        LinkedList<Vertex> route = new LinkedList();
        route.add(new Vertex("A","A"));
        route.add(new Vertex("E","E"));
        route.add(new Vertex("D","D"));
        try {
            assertEquals(11,customGraphAlgorithms.getDistanceOfPath(route,graph));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
        Vertex C = new Vertex("C","C");
        //dijkstra.execute(A);
        LinkedList<Vertex> path = dijkstra.getPath(B);
        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
        dijkstra.execute(A);
        System.out.println(dijkstra.getShortestDistance(C));
    }

    /**
     * Tests the number of different routes from C to C with a distance of less than 30.
     */
    @Test
    public void testCaseTen(){

    }

    /**
     * #6
     */
    @Test
    public void testDepthFirstSearch2(){
        Vertex c = new Vertex("C","C");
        customGraphAlgorithms.compute6(graph, c, null, new LinkedList<Vertex>(), 3);
    }

    /**
     * #7
     * B,C,D
     * D,C,D
     * D,E,B
     */
    @Test
    public void testDepthFirstSearch3(){
        Vertex a = new Vertex("A","A");
        Vertex c = new Vertex("C","C");
        customGraphAlgorithms.compute7(graph, a, c, null, new LinkedList<Vertex>(),4);
    }

    /**
     * #10
     * B,C,D
     * D,C,D
     * D,E,B
     */
    @Test
    public void testDepthFirstSearch10(){
        Vertex c = new Vertex("C","C");
        customGraphAlgorithms.compute10(graph, c, c, null, new LinkedList<Vertex>(),0,0,30);
    }

}
