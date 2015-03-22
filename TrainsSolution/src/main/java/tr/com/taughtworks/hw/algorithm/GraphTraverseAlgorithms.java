package tr.com.taughtworks.hw.algorithm;

import tr.com.taughtworks.hw.model.Edge;
import tr.com.taughtworks.hw.model.Graph;
import tr.com.taughtworks.hw.model.Vertex;

import java.util.List;

/**
 * Created by Mert on 21.3.2015.
 */
public class GraphTraverseAlgorithms {

    private final Graph graph;
    /**
     * Constructor
     */
    public GraphTraverseAlgorithms(Graph graph){

        this.graph = graph;
    }

    /**
     * Calculates the distance of given route.
     */
    public int getTotalDistanceOfRoute(List<Vertex> route){
        //Defensive programming
        if( route.size() < 2){ return 0; }

        int distance = 0;

        return 0;
    }

    /**
     * Calculates number of routes from start to end
     * including maxStops number of depth at most.
     * #6 #7
     */
    public int getNunberOfTrips(Vertex start, Vertex end, int maxStops){

        return 0;
    }

    /**
     * Calculates number of different routes from start to end
     * with a given distance at most.
     * #10
     */
    public int getNumberOfDifferentRoutes(Vertex start, Vertex end, int maxDistance){

        return 0;
    }


}
