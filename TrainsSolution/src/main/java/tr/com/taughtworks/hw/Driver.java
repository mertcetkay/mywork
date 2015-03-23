package tr.com.taughtworks.hw;

import tr.com.taughtworks.hw.util.GraphLoaderFromFile;

/**
 * This class includes main method.
 *
 * Created by Mert on 20.3.2015.
 */
public class Driver {

    public static void main(String[] args) {
        GraphLoaderFromFile loader = new GraphLoaderFromFile("input.txt");
        loader.getGraph();
    }


}


