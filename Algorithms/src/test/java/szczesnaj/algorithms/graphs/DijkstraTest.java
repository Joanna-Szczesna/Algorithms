package szczesnaj.algorithms.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {
    @Nested
    class MusicGraph {
        private String filePath;

        @BeforeEach
        void setUp() throws URISyntaxException {
            URL resource = getClass().getClassLoader().getResource("musicGraphTest.txt");
            filePath = Paths.get(resource.toURI()).toString();
        }
        //start book
//        meta piano
//        book cd 5
//        book poster 0
//        cd guitar 15
//        cd drum 20
//        poster guitar 30
//        poster drum 35
//        guitar piano 20
//        drum piano 10

        @Test
        void inMusicGraphBetweenBookAndCD_lowerCost_ReturnFive() {
            int lowestCost = Dijkstra.lowestCostWithPath(filePath, "book", "cd");
            assertEquals(5, lowestCost);
        }

        @Test
        void inMusicGraphBetweenBookAndPoster_lowerCost_ReturnZero() {
            int lowestCost = Dijkstra.lowestCostWithPath(filePath, "book", "poster");
            assertEquals(0, lowestCost);
        }

        @Test
        void inMusicGraphBetweenBookAndDrum_lowerCost_ReturnTwentyFive() {
            int lowestCost = Dijkstra.lowestCostWithPath(filePath, "book", "drum");
            assertEquals(25, lowestCost);
        }

//    @Test
//    void inMusicGraphBetweenBookAndPiano_shortestPath_ReturnBookCdDrumPiano() throws URISyntaxException {
//        URL resource = getClass().getClassLoader().getResource("musicGraphTest.txt");
//        String filePath = Paths.get(resource.toURI()).toString();
//        Map<Integer, List<String>> costWithPath = Dijkstra
//                .shortestPathWithValues(filePath, "book", "piano");
//
//        Map<Integer, List<String>> expectedCostWithPath =
//                Map.of(35, List.of("book", "cd", "drum", "piano"));
//
//        assertEquals(expectedCostWithPath, costWithPath);
//    }

    }
}