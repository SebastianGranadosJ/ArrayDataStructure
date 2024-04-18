package graph;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.edu.upb.nolineal.graph.weightedGraph.Graph;

public class GraphTest {

    @Test
    void testAddNode(){
        Graph<Station> graph = new Graph<>(5);

        assertTrue(graph.addNode(new Station("A", "001")));
        assertFalse(graph.addNode(new Station("A", "001")));
        System.out.println(graph.toString());


    }
    @Test
    void testAddEdge(){
        Graph<Station> graph = new Graph<>(5);
        Station a = new Station("A", "0");
        Station b = new Station("B", "1");
        Station c = new Station("C", "2");
        Station d = new Station("D", "3");
        Station e = new Station("E", "4");

        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);

        graph.addEdge(a, b, 10);
        graph.addEdge(a, e, 5);
        graph.addEdge(d, c, 14);
        graph.addEdge(c, b, 7);

        System.out.println(graph.toString());
        
    }

    @Test
    void testShortestPath(){
        Graph<Station> graph = new Graph<>(6);

        Station a = new Station("A", "0");
        Station b = new Station("B", "1");
        Station c = new Station("C", "2");
        Station d = new Station("D", "3");
        Station e = new Station("E", "4");
        Station f = new Station("F", "5");
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);



        graph.addEdge(a, b, 7);
        graph.addEdge(a, d, 14);
        graph.addEdge(a, c, 9);

        graph.addEdge(b, c, 10);
        graph.addEdge(b, e, 15);

        graph.addEdge(c, d, 2);
        graph.addEdge(c, e, 11);

        graph.addEdge(d, f, 9);

        graph.addEdge(e, f, 6);

        System.out.println(graph.ShortestPath(a, e).toString());

        System.out.println(graph.pathDistance(graph.ShortestPath( new Station("A", "0"),  new Station("E", "4"))));


    }
    
}
