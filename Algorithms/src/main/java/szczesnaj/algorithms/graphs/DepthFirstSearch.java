package szczesnaj.algorithms.graphs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class DepthFirstSearch {
    private Map<Integer, Set<Integer>> adjacentMatrix;

    private static List<GraphUtils.Edge> getEdgesFromFile(String fileName) {
        try (Stream<String> fileStream = Files.lines(Paths.get(fileName))) {
            return fileStream
                    .skip(1)
                    .map(s -> Arrays.stream(s.split("\\s+", 2))
                            .map(Integer::parseInt)
                            .toList())
                    .map(list -> new GraphUtils.Edge(list.get(0), list.get(1)))
                    .collect(toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String fileName = "m_3graphs.txt";

        System.out.println(countGraphs(fileName));
    }

    static int countGraphs(String path) {
        DepthFirstSearch task = new DepthFirstSearch();
        List<GraphUtils.Edge> edgeList = getEdgesFromFile(path);
        task.adjacentMatrix = createAdjMatrix(edgeList);
//        List<Graph> graphs = task.findGraphsDeclarativeWay();
        List<Graph> graphs = task.findGraphsImperativeWay();

        return (graphs.size());
    }

    private static Map<Integer, Set<Integer>> createAdjMatrix(List<GraphUtils.Edge> edgeList) {
        Map<Integer, Set<Integer>> adjMatrix = new HashMap<>();
        for (GraphUtils.Edge e : edgeList) {
            adjMatrix.putIfAbsent(e.x, new HashSet<>());
            adjMatrix.get(e.x).add(e.y);

            adjMatrix.putIfAbsent(e.y, new HashSet<>());
            adjMatrix.get(e.y).add(e.x);
        }
        return adjMatrix;
    }

    private List<Graph> findGraphsDeclarativeWay() {

        Set<Integer> visitedVertices = new HashSet<>();

        return adjacentMatrix.keySet().stream()
                .filter(k -> !visitedVertices.contains(k))
                .map(k -> {
                    Graph g = dfs(k);
                    visitedVertices.addAll(g.vertex);
                    return g;
                }).toList();
    }

    private List<Graph> findGraphsImperativeWay() {

        Set<Integer> visitedVertices = new HashSet<>();

        List<Graph> graphs = new ArrayList<>();
        for (Integer vertex : adjacentMatrix.keySet()) {
            if (visitedVertices.contains(vertex)) {
                continue;
            }
            Graph graph = dfs(vertex);
            visitedVertices.addAll(graph.vertex);
            graphs.add(graph);
        }
        return graphs;
    }

    private Graph dfs(Integer vertex) {
        ArrayDeque<Integer> stackToUse = new ArrayDeque<>();
        Set<Integer> visitedVertices = new HashSet<>();
        stackToUse.add(vertex);

        while (!stackToUse.isEmpty()) {
            Integer popVertex = stackToUse.pop();
            visitedVertices.add(popVertex);
            Predicate<Integer> shouldVisit = a -> !visitedVertices.contains(a);

            Set<Integer> elementsToCheck = getAdjacent(popVertex).stream()
                    .filter(shouldVisit)
                    .collect(toSet());
            stackToUse.addAll(elementsToCheck);
        }

        return new Graph((visitedVertices));
    }

    private Set<Integer> getAdjacent(Integer vertex) {
        return this.adjacentMatrix.get(vertex);
    }

    class Graph {
        private final Set<Integer> vertex;

        Graph(Set<Integer> vertex) {
            this.vertex = new HashSet<>();
            this.vertex.addAll(vertex);
        }

        @Override
        public String toString() {
            return "Graph{ " +
                    "edges=" + vertex +
                    '}';
        }
    }
}

