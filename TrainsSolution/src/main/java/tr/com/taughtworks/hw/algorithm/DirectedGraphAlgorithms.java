package tr.com.taughtworks.hw.algorithm;

import tr.com.taughtworks.hw.model.Edge;
import tr.com.taughtworks.hw.model.Graph;
import tr.com.taughtworks.hw.model.Vertex;

import java.util.*;

/**
 * Created by Mert on 22.3.2015.
 */
public class DirectedGraphAlgorithms {

   private List<List> paths = new LinkedList<List>();

   public DirectedGraphAlgorithms(){

   }


    /**
     *  Problem #6
     */
    public void compute6(Graph g, Vertex startVertex,
                                Vertex currentVertex, LinkedList<Vertex> currentPath, int depth)
    {

        /**
         * start node reached second time => save path
         */
        if (startVertex.equals(currentVertex))
        {
            List<Vertex> path = new ArrayList<Vertex>();
            path.add(startVertex);
            path.addAll(currentPath);
            System.out.println("Result " + path);
            paths.add(path);
        }
        if (currentVertex == null)
        {
            currentVertex = startVertex;
        }
        List<Vertex> neighbors = g.getOutNeighbors(currentVertex);

        for (Vertex neighbor : neighbors)
        {
                currentPath.add(neighbor);
                depth--;
                if(depth>=0) {
                    compute6(g, startVertex, neighbor, currentPath, depth);
                }
                currentPath.removeLastOccurrence(neighbor);
                depth++;
        }
    }


    /**
     *  Problem #7
     */
    public void compute7(Graph g, Vertex startVertex,Vertex endVertex,
                         Vertex currentVertex, LinkedList<Vertex> currentPath, int depth)
    {
        /**
         * desired condition -> take snapshot ( save path )
         */
        if (endVertex.equals(currentVertex) && depth == 0)
        {
            List<Vertex> path = new ArrayList<Vertex>();
            path.add(startVertex);
            path.addAll(currentPath);
            System.out.println("Result " + path);
            paths.add(path);
        }
        if (currentVertex == null)
        {
            currentVertex = startVertex;
        }
        List<Vertex> neighbors = g.getOutNeighbors(currentVertex);
        for (Vertex neighbor : neighbors)
        {
            currentPath.add(neighbor);
            depth--;
            if (depth >= -1) {
                compute7(g, startVertex, endVertex, neighbor, currentPath, depth);
            }
            currentPath.removeLastOccurrence(neighbor);
            depth++;
        }
    }

    /**
     *  Problem #10
     */
    public void compute10(Graph g, Vertex startVertex,Vertex endVertex,
                         Vertex currentVertex, LinkedList<Vertex> currentPath, int depth, int currentCost, int maxCost)
    {
        /**
         * desired condition -> take snapshot ( save path )
         */
        if (endVertex.equals(currentVertex) && currentCost < maxCost)
        {
            List<Vertex> path = new LinkedList<Vertex>();
            path.add(startVertex);
            path.addAll(currentPath);
            System.out.println("Result " + path);
            paths.add(path);
        }
        if (currentVertex == null)
        {
            currentVertex = startVertex;
        }
        List<Vertex> neighbors = g.getOutNeighbors(currentVertex);
        for (Vertex neighbor : neighbors)
        {
            currentCost += g.getEdgeWeightBetweenTwoVertices(currentVertex,neighbor);
            currentPath.add(neighbor);
            depth++;
            if (depth <= maxCost) {
                compute10(g, startVertex, endVertex, neighbor, currentPath, depth, currentCost, maxCost);
            }
            depth--;
            currentCost -= g.getEdgeWeightBetweenTwoVertices(currentVertex,neighbor);
            currentPath.removeLastOccurrence(neighbor);

        }
    }

    public List<List> getPaths() {
        return paths;
    }
}
