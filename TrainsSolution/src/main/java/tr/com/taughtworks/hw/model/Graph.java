package tr.com.taughtworks.hw.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents graph data structure.
 *
 * Created by Mert on 18.3.2015.
 */
public class Graph {
    /**
     * Vertex list of the graph.
     */
    private final List<Vertex> vertexes;
    /**
     * Edge list of the graph.
     */
    private final List<Edge> edges;

    /**
     * Constructor.
     */
    public Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    /**
     * Returns adjacent vertices of a given vertex.
     */
    public List<Vertex> getAdjacentVertices(Vertex vertex){
        List<Vertex> result = new ArrayList<Vertex>();
        for(Edge edge : edges){
            if( edge.getSource().equals(vertex)){
                result.add(edge.getDestination());
            }
        }
        return result;
    }

    /**
     * Returns outgoing edge list of a given vertex.
     */
    public List<Edge> getOutgoingEdges( Vertex vertex){
        List<Edge> outgoingEdgeList = new ArrayList<Edge>();
        for( Edge edge : edges){
            if( edge.getSource().equals(vertex)){
                outgoingEdgeList.add(edge);
            }
        }
        return outgoingEdgeList;
    }

    /**
     * Returns cost of travelling from source to destination.
     */
    public int getEdgeWeightBetweenTwoVertices(Vertex source, Vertex destination){
        for(Edge e : edges){
            if(e.getSource().equals(source) && e.getDestination().equals(destination)){
                return e.getWeight();
            }
        }
        return -1;
    }

    /**
     * Accessor methods.
     */
    public List<Vertex> getVertexes() {
        return vertexes;
    }
    public List<Edge> getEdges() {
        return edges;
    }

}
