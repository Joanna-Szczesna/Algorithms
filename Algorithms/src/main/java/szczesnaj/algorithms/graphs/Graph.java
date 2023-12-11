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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EdgeWithWeights that)) return false;
        return Objects.equals(node, that.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "node='" + node + '\'' +
                ", ngb='" + ngb + '\'' +
                ", cost=" + cost +
                '}';
    }
}

record NodeWithCost(String parentName, Integer cost) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NodeWithCost that)) return false;
        return Objects.equals(parentName, that.parentName) && Objects.equals(cost, that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentName, cost);
    }
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
                .filter(e -> e.parentName().equals(searchingNode))
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