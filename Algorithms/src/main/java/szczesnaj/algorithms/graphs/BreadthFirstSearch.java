package szczesnaj.algorithms.graphs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

class BreadthFirstSearch {
    private Map<Integer, Set<Integer>> adjacentMatrix;

    public static void main(String[] args) {
        String fileName = "undirectedGraph.txt";
        System.out.println(findShortestWay(fileName, 1, 12));
    }

    static List<Integer> findShortestWay(String fileName, int startNode, int destinationNode) {
        List<GraphUtils.Edge> edgesFromFile = getEdgesFromFile(fileName);
        BreadthFirstSearch task = new BreadthFirstSearch();
        task.adjacentMatrix = createAdjacentMatrix(edgesFromFile);
        return task.bfs(startNode, destinationNode);
    }

    private static List<GraphUtils.Edge> getEdgesFromFile(String fileName) {
        try (Stream<String> fileStream = Files.lines(Paths.get(fileName))) {
            return fileStream.map(l -> Arrays.stream(l.split(" "))
                            .map(Integer::parseInt)
                            .toList()
                    ).map(list -> new GraphUtils.Edge(list.get(0), list.get(1)))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<Integer, Set<Integer>> createAdjacentMatrix(List<GraphUtils.Edge> edges) {
        Map<Integer, Set<Integer>> adjacentMatrix = new HashMap<>();

        for (GraphUtils.Edge edge : edges) {
            adjacentMatrix.putIfAbsent(edge.x, new HashSet<>());
            adjacentMatrix.get(edge.x).add(edge.y);

            adjacentMatrix.putIfAbsent(edge.y, new HashSet<>());
            adjacentMatrix.get(edge.y).add(edge.x);
        }

        return adjacentMatrix;
    }

    private List<Integer> bfs(int startNode, int destinationNode) {

        Queue<Integer> q = new ArrayDeque<>();
        q.add(startNode);
        Set<Integer> checked = new HashSet<>();
        Map<Integer, InfoShortcut> shortcutsTable = new HashMap<>();
        shortcutsTable.put(startNode, new InfoShortcut(null, 0));

        int counter = 1;
        while (!q.isEmpty()) {
            Integer step = q.poll();
            checked.add(step);
            if (!step.equals(destinationNode)) {
                Set<Integer> ngbs = this.adjacentMatrix.get(step);
                Set<Integer> toExam = ngbs.stream()
                        .filter(v -> !checked.contains(v) & !q.contains(v))
                        .collect(Collectors.toUnmodifiableSet());
                q.addAll(toExam);
                int finalCounter = counter;
                Map<Integer, InfoShortcut> data = toExam.stream().collect(toMap(
                        node -> node,
                        node -> new InfoShortcut(step, finalCounter)
                ));
                shortcutsTable.putAll(data);
            } else {
                break;
            }
            counter += 1;
        }
        return getShortestPath(shortcutsTable, destinationNode);
    }

    List<Integer> getShortestPath(Map<Integer, InfoShortcut> data, Integer destinationNode) {
        Integer ancestor = data.get(destinationNode).ancestor();
        List<Integer> shortestPath = new ArrayList<>();
        shortestPath.add(destinationNode);
        while (ancestor != null) {
            shortestPath.add(ancestor);
            ancestor = data.get(ancestor).ancestor();
        }
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}

record InfoShortcut(Integer ancestor, Integer distance) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InfoShortcut that)) return false;
        return Objects.equals(ancestor, that.ancestor) && Objects.equals(distance, that.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ancestor, distance);
    }
}