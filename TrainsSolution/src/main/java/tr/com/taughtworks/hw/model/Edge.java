package tr.com.taughtworks.hw.model;

/**
 * Created by Mert on 18.3.2015.
 */
public class Edge {
    /**
     * Unique edge identifier.
     */
    private final String id;
    /**
     * Source of the edge.
     */
    private final Vertex source;
    /**
     * Destination of the edge.
     */
    private final Vertex destination;
    /**
     * Cost of the edge.
     */
    private final int weight;

    public Edge(String id, Vertex source, Vertex destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return source + "" + destination + weight;
    }

    /**
     * Accessor methods.
     */
    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }

    public int getWeight() {
        return weight;
    }
}
