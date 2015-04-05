package tr.com.taughtworks.hw.util;

import tr.com.taughtworks.hw.model.Edge;
import tr.com.taughtworks.hw.model.Graph;
import tr.com.taughtworks.hw.model.Vertex;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Mert on 23.3.2015.
 */
public class GraphLoaderFromFile {

    /**
     * Name of the file to be loaded.
     */
    private String fileName;

    public GraphLoaderFromFile(String fileName){
        this.fileName = fileName;
    }

    /**
     * Reads text input and returns Graph object
     */
    public Graph getGraph(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/"+fileName).getFile());
        try {
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            return( formGraph(line));
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Forms graph from text representation.
     */
    private Graph formGraph(String graphString){

        Set<Vertex> vertexSet = new HashSet<Vertex>();
        List<Edge> edgeList = new ArrayList<Edge>();

        String delimeter = ",";
        StringTokenizer st1 = new StringTokenizer(graphString,delimeter);
        StringTokenizer st2 = new StringTokenizer(graphString,delimeter);

        // init vertices
        while( st1.hasMoreElements()){
            String currentString = (String) st1.nextElement();
            String firstVertexName = currentString.substring(0,1);
            String secondVertexName = currentString.substring(1,2);
            vertexSet.add(new Vertex(firstVertexName, firstVertexName));
            vertexSet.add(new Vertex(secondVertexName, secondVertexName));
        }
        List<Vertex> vertexList = new ArrayList<Vertex>(vertexSet);

        //init edges
        while( st2.hasMoreElements()){
            String currentString = (String) st2.nextElement();
            String firstVertexName = currentString.substring(0,1);
            String secondVertexName = currentString.substring(1,2);
            String edgeWeight = currentString.substring(2);
            Vertex source = new Vertex(firstVertexName,firstVertexName);
            Vertex destination = new Vertex(secondVertexName,secondVertexName);
            Edge edge = new Edge(currentString, source, destination ,Integer.parseInt(edgeWeight));
            edgeList.add(edge);
        }

        return (new Graph(vertexList,edgeList));
    }
}
