package tr.com.taughtworks.hw;

import tr.com.taughtworks.hw.algorithm.CustomGraphAlgorithms;
import tr.com.taughtworks.hw.algorithm.DijkstraAlgorithm;
import tr.com.taughtworks.hw.model.Graph;
import tr.com.taughtworks.hw.model.Vertex;
import tr.com.taughtworks.hw.util.GraphLoaderFromFile;

import java.util.LinkedList;

/**
 * This class includes main method.
 *
 * Created by Mert on 20.3.2015.
 */
public class Driver {

    public static void main(String[] args) {
        GraphLoaderFromFile loader = new GraphLoaderFromFile("input.txt");
        Graph graph = loader.getGraph();
        CustomGraphAlgorithms customGraphAlgorithms = new CustomGraphAlgorithms();
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);

        /**
         * Output #1
         */
        LinkedList<Vertex> route_ABC = new LinkedList();
        route_ABC.add(new Vertex("A","A"));
        route_ABC.add(new Vertex("B","B"));
        route_ABC.add(new Vertex("C","C"));
        try {
            System.out.println("Output #1: " + customGraphAlgorithms.getDistanceOfPath(route_ABC, graph));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * Output #2
         */
        LinkedList<Vertex> route_AD = new LinkedList();
        route_AD.add(new Vertex("A","A"));
        route_AD.add(new Vertex("D","D"));
        try {
            System.out.println("Output #2: " + customGraphAlgorithms.getDistanceOfPath(route_AD, graph));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * Output #3
         */
        LinkedList<Vertex> route_ADC = new LinkedList();
        route_ADC.add(new Vertex("A","A"));
        route_ADC.add(new Vertex("D","D"));
        route_ADC.add(new Vertex("C","C"));
        try {
            System.out.println("Output #3: " + customGraphAlgorithms.getDistanceOfPath(route_ADC,graph));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * Output #4
         */
        LinkedList<Vertex> route_AEBCD = new LinkedList();
        route_AEBCD.add(new Vertex("A","A"));
        route_AEBCD.add(new Vertex("E","E"));
        route_AEBCD.add(new Vertex("B","B"));
        route_AEBCD.add(new Vertex("C","C"));
        route_AEBCD.add(new Vertex("D","D"));
        try {
            System.out.println("Output #4: " + customGraphAlgorithms.getDistanceOfPath(route_AEBCD,graph));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * Output #5
         */
        LinkedList<Vertex> route_AED = new LinkedList();
        route_AED.add(new Vertex("A","A"));
        route_AED.add(new Vertex("E","E"));
        route_AED.add(new Vertex("D","D"));
        try {
            System.out.println("Output #5: " + customGraphAlgorithms.getDistanceOfPath(route_AED,graph));
        } catch (Exception e) {
            System.out.println("Output #5: " + e.getMessage());
        }

        /**
         * Output #6
         */
        Vertex c = new Vertex("C","C");
        System.out.println("Output #6: " + customGraphAlgorithms.getNumberOfTripsWithMaxStop(graph, c, 3));

        /**
         * Output #7
         */
        Vertex a = new Vertex("A","A");
        System.out.println("Output #7: " + customGraphAlgorithms.getNumberOfTripsWithExactStop(graph, a, c, 4));

        /**
         * Output #8
         */
        dijkstra.execute(a);
        System.out.println("Output #8: " + dijkstra.getShortestDistance(c));

        /**
         * Output #9
         */
        Vertex b = new Vertex("B","B");
        System.out.println("Output #9: " + dijkstra.getShortestPathDistanceSameVertexExtension(b));

        /**
         * Output #10
         */
        System.out.println("Output #9: " + customGraphAlgorithms.getNumberOfRoutesWithMaxCost(graph, c, c, 30));
    }

}


