package tr.com.taughtworks.hw.model;

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
     * Accessor methods.
     */

    public List<Vertex> getVertexes() {
        return vertexes;
    }
    public List<Edge> getEdges() {
        return edges;
    }

}
