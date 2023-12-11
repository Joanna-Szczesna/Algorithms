package szczesnaj.algorithms.graphs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Dijkstra {
    public static void main(String[] args) {
        String fileName = "musicGraph.txt";
        System.out.println(lowestCostWithPath(fileName, "book", "piano"));
    }

    private static List<EdgeWithWeights> getEdgesFromFile(String path) {
        try (Stream<String> fileStream = Files.lines(Paths.get(path))) {
            return fileStream
                    .skip(2)
                    .map(s -> Arrays.stream(s.split("\\s+", 3))
                            .toList())
                    .map(list -> new EdgeWithWeights(
                            list.get(0),
                            list.get(1),
                            Integer.parseInt(list.get(2))))
                    .collect(toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int lowestCostWithPath(String filePath, String startNode, String endNode) {
        List<EdgeWithWeights> edgesFromFile = getEdgesFromFile(filePath);
        DirectedGraph graph = createGraphStructureFromEdges(edgesFromFile);
//        System.out.println(graph);

        Map<String, NodeWithCost> tableLowestCostsFromStartNode = new HashMap<>();

        Set<NodeWithCost> startNodeNgbs= graph.getAdjacentNodes(startNode);

        for(NodeWithCost ngbCost : startNodeNgbs){
            tableLowestCostsFromStartNode.put(ngbCost.parentName(),
                    new NodeWithCost(startNode, ngbCost.cost()));
        }
        System.out.println(tableLowestCostsFromStartNode);





        return tableLowestCostsFromStartNode.get(endNode).cost();
    }

    private static DirectedGraph createGraphStructureFromEdges(List<EdgeWithWeights> edgesFromFile) {
        Map<String, Set<NodeWithCost>> adjacentMatrix = new HashMap<>();
        for (EdgeWithWeights e : edgesFromFile) {
            adjacentMatrix.putIfAbsent(e.node(), new HashSet<>());
            adjacentMatrix.get(e.node()).add(new NodeWithCost(e.ngb(), e.cost()));
        }

        return new DirectedGraph(adjacentMatrix);
    }
}

record Table(String node, String Parent, Integer cost){}



