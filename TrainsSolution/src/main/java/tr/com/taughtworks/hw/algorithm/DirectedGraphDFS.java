package tr.com.taughtworks.hw.algorithm;

import tr.com.taughtworks.hw.model.Edge;
import tr.com.taughtworks.hw.model.Graph;
import tr.com.taughtworks.hw.model.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Mert on 22.3.2015.
 */
public class DirectedGraphDFS {

   private List<List> paths = new ArrayList<List>();

   public DirectedGraphDFS(){

   }

    public void dfs(Graph graph, Vertex start, Set<Vertex> known, Map<Vertex,Edge> forest){

        known.add(start);
        for( Edge e : graph.getOutgoingEdges(start)){
            Vertex currentAdjacentVertex = e.getDestination();
            if(!known.contains(currentAdjacentVertex)){
                forest.put(currentAdjacentVertex,e);
                dfs(graph,currentAdjacentVertex,known,forest);
            }
        }
        known.remove(start);
        System.out.println(start.getName());
    }

    /**
     *  Problem #6
     */
    public void compute6(Graph g, Vertex startVertex,
                                Vertex currentVertex, Set<Vertex> currentPath, int depth)
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
            if (!currentPath.contains(neighbor))
            {
                currentPath.add(neighbor);
                depth--;
                if(depth>=0) {
                    compute6(g, startVertex, neighbor, currentPath, depth);
                }
                currentPath.remove(neighbor);
                depth++;
            }
        }
    }


    /**
     *  Problem #7
     */
    public void compute7(Graph g, Vertex startVertex,Vertex endVertex,
                         Vertex currentVertex, Set<Vertex> currentPath, int depth)
    {

        System.out.println(depth);
        /**
         * desired condition -> take snapshot ( save path )
         */
        if (endVertex.equals(currentVertex) && depth == 0)
        {
            List<Vertex> path = new ArrayList<Vertex>();
            //path.add(startVertex);
            path.addAll(currentPath);
            //path.add(endVertex);
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
            /**
             * todo bu if ile bir vertex sadece 1 kere kullanilabilio
             * #6 da da bunu hallet.
             */
                currentPath.add(neighbor);
                depth--;
                if(depth >= -2) {
                    compute7(g, startVertex, endVertex, neighbor, currentPath, depth);
                }
                currentPath.remove(neighbor);
                depth++;

        }
    }
}
