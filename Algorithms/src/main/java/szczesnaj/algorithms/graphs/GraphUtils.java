package szczesnaj.algorithms.graphs;

class GraphUtils {
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
