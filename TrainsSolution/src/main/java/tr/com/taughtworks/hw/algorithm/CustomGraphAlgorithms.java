package tr.com.taughtworks.hw.algorithm;

import tr.com.taughtworks.hw.model.Edge;
import tr.com.taughtworks.hw.model.Graph;
import tr.com.taughtworks.hw.model.Vertex;

import java.util.*;

/**
 * Created by Mert on 22.3.2015.
 */
public class CustomGraphAlgorithms {


    /**
     * List of list to save different paths.
     */
    private List<List> paths;

    /**
     * Constructor.
     */
    public CustomGraphAlgorithms(){
        this.paths  = new LinkedList<List>();
    }

    /**
     * Calculates the distance of given path.
     */
    public int getDistanceOfPath(LinkedList<Vertex> vertexList, Graph graph) throws Exception {
        if(vertexList.size() < 2 ){ return 0;}

        int totalDistance = 0;
        int predecessorVertex = 0;
        Vertex[] vertexArray = vertexList.toArray( new Vertex[vertexList.size()]);

        for( int i = 1; i < vertexArray.length; i++ ){
            int currentDistance = graph.getEdgeWeightBetweenTwoVertices(vertexArray[predecessorVertex],vertexArray[i]);
            if( currentDistance > 0){
                totalDistance += currentDistance;
            }else{
                throw new Exception("NO SUCH ROUTE");
            }
            predecessorVertex++;
        }
        return totalDistance;
    }

    /**
     * Problem #6
     */
    public void compute6(Graph g, Vertex startVertex,
                         Vertex currentVertex, LinkedList<Vertex> currentPath, int depth) {

        /**
         * start node reached second time => save path
         */
        if (startVertex.equals(currentVertex)) {
            List<Vertex> path = new ArrayList<Vertex>();
            path.add(startVertex);
            path.addAll(currentPath);
            System.out.println("Result " + path);
            paths.add(path);
        }
        if (currentVertex == null) {
            currentVertex = startVertex;
        }
        List<Vertex> neighbors = g.getAdjacentVertices(currentVertex);

        for (Vertex neighbor : neighbors) {
            currentPath.add(neighbor);
            depth--;
            if (depth >= 0) {
                compute6(g, startVertex, neighbor, currentPath, depth);
            }
            currentPath.removeLastOccurrence(neighbor);
            depth++;
        }
    }


    /**
     * Problem #7
     */
    public void compute7(Graph g, Vertex startVertex, Vertex endVertex,
                         Vertex currentVertex, LinkedList<Vertex> currentPath, int depth) {
        /**
         * desired condition -> take snapshot ( save path )
         */
        if (endVertex.equals(currentVertex) && depth == 0) {
            List<Vertex> path = new ArrayList<Vertex>();
            path.add(startVertex);
            path.addAll(currentPath);
            System.out.println("Result " + path);
            paths.add(path);
        }
        if (currentVertex == null) {
            currentVertex = startVertex;
        }
        List<Vertex> neighbors = g.getAdjacentVertices(currentVertex);
        for (Vertex neighbor : neighbors) {
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
     * Problem #10
     */
    public void compute10(Graph g, Vertex startVertex, Vertex endVertex,
                          Vertex currentVertex, LinkedList<Vertex> currentPath, int depth, int currentCost, int maxCost) {
        /**
         * desired condition -> take snapshot ( save path )
         */
        if (endVertex.equals(currentVertex) && currentCost < maxCost) {
            List<Vertex> path = new LinkedList<Vertex>();
            path.add(startVertex);
            path.addAll(currentPath);
            System.out.println("Result " + path);
            paths.add(path);
        }
        if (currentVertex == null) {
            currentVertex = startVertex;
        }
        List<Vertex> neighbors = g.getAdjacentVertices(currentVertex);
        for (Vertex neighbor : neighbors) {
            currentCost += g.getEdgeWeightBetweenTwoVertices(currentVertex, neighbor);
            currentPath.add(neighbor);
            depth++;
            if (depth <= maxCost) {
                compute10(g, startVertex, endVertex, neighbor, currentPath, depth, currentCost, maxCost);
            }
            depth--;
            currentCost -= g.getEdgeWeightBetweenTwoVertices(currentVertex, neighbor);
            currentPath.removeLastOccurrence(neighbor);

        }
    }

    public List<List> getPaths() {
        return paths;
    }
}
