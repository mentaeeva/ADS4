import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        graph.addEdge(v1, v2, 1.0);
        graph.addEdge(v1, v3, 4.0);
        graph.addEdge(v2, v3, 2.0);
        graph.addEdge(v2, v4, 5.0);
        graph.addEdge(v3, v4, 1.0);

        System.out.println("BFS starting from A:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        bfs.search(v1);

        System.out.println("\nDijkstra distances from A:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        Map<Vertex<String>, Double> distances = dijkstra.dijkstra(v1);
        for (Map.Entry<Vertex<String>, Double> e : distances.entrySet()) {
            System.out.println("Distance A->" + e.getKey().getData() + " = " + e.getValue());
        }
    }
}
