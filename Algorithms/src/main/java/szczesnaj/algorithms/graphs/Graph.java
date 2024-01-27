package szczesnaj.algorithms.graphs;

import java.util.*;

class Graph {
    private final Set<Integer> vertex;

    Graph(Set<Integer> vertex) {
        this.vertex = new HashSet<>();
        this.vertex.addAll(vertex);
    }

    Set<Integer> getVertices() {
        return new HashSet<>(vertex);
    }

    @Override
    public String toString() {
        return "Graph{ " +
                "edges=" + vertex +
                '}';
    }

    static class Edge {
        Integer x;
        Integer y;

        Edge(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" +
                    "x=" + x +
                    ", y=" + y +
                    ']';
        }
    }
}

record EdgeWithWeights(String node, String ngb, Integer cost) {
}

record NodeWithCost(String nextNode, Integer cost) {
}

class DirectedGraph {
    private Map<String, Set<NodeWithCost>> adjacentMatrices;

    DirectedGraph(Map<String, Set<NodeWithCost>> adjacentMatrices) {
        this.adjacentMatrices = adjacentMatrices;
    }

    Set<NodeWithCost> getAdjacentNodes(String ancestorNode) {
        return adjacentMatrices.get(ancestorNode);
    }

    Integer getEdgeCost(String searchingNode, String ancestorNode) {
        Set<NodeWithCost> nodesWithCosts = adjacentMatrices.get(ancestorNode);
        Optional<Integer> cost = nodesWithCosts.stream()
                .filter(e -> e.nextNode().equals(searchingNode))
                .map(NodeWithCost::cost)
                .findFirst();
        return cost.orElse(null);
    }
    Map<String, Set<NodeWithCost>> getAdjacentMatrices(){
        return Map.copyOf(adjacentMatrices);
    }
    @Override
    public String toString() {
        return "DirectedGraph{" +
                "adjacentMatrices=" + adjacentMatrices +
                '}';
    }
}

record LowestCostPath(Integer cost, List<String> path){
}
record InfoShortcut(Integer ancestor, Integer distance) {
}