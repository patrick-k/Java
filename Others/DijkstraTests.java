package Others;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Patrick Kane (N01422638)
 * CEN6070 - Assignment 1 1/25/2021
 * DijkstraTests.java
 *
 * Unit tests for Dijkstra's SSSP algorithm.  Each
 * test will follow the arrange-act-assert pattern
 * and be named as follows:
 *
 * {methodUnderTest}_{InputBehaviors}_{ExpectedOutcome}
 *
 * Tests will target the two equivalence classes partitioned
 * from the input domain.
 *
 *  D1 - Path from source node s -> destination node d exists
 *  D2 - Path from s -> d does not exist
 */
@RunWith(JUnit4.class)
public class DijkstraTests {
    Graph graph;

    @Test
    public void printPath_PathExists_TakesShortestPath() {
        graph = Dijkstra.initializeGraph("a");
        String endNode = "e";

        String result = graph.printPath(endNode);
        Assert.assertEquals("a -> c(9) -> d(20) -> e(26)", result);
    }

    @Test
    public void printPath_MultiplePathsExist_TakesShortestPath() {
        graph = Dijkstra.initializeGraph("a");

        // should take shortest path a -> c -> f instead of a -> b -> c -> f etc...
        String endNode = "f";

        String resultPath = graph.printPath(endNode);
        Assert.assertEquals("a -> c(9) -> f(11)", resultPath);
    }

    @Test
    public void printPath_PathDoesNotExist_PrintsErrorMessage() {
        graph = Dijkstra.initializeGraph("a");
        String nonExistentEndNode = "g";

        String result = graph.printPath(nonExistentEndNode);
        Assert.assertNull(result);
    }

    // Added after initial coverage report - targets 100% statement coverage
    @Test
    public void initializeGraph_SourceVertexInvalid_PrintsErrorMessage() {
        graph = Dijkstra.initializeGraph("zzzz");
    }

    @Test
    public void vertexToString_VertexInValidState_PrintsNameAndCost() {
        Graph.Vertex v = new Graph.Vertex("a");
        Assert.assertEquals("(a, " + Integer.MAX_VALUE + ")", v.toString());
    }
}
