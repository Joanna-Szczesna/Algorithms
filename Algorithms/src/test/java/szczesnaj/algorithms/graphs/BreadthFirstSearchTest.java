package szczesnaj.algorithms.graphs;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BreadthFirstSearchTest {

    @Test
    void forUndirectedGraphTestFileShortestWay_StartFromOneDestinationIsThirteen_returnFourSteps() throws URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("undirectedGraphTest.txt");
        String path = Paths.get(resource.toURI()).toString();

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        List<Integer> bfsPath = breadthFirstSearch.findShortestWay(path, 1, 13);
        int numberSteps = bfsPath.size();

        assertEquals(4, numberSteps);
        assertEquals(List.of(1, 4, 8, 13), bfsPath);
    }

}