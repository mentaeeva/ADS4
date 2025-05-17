import java.util.*;

public class WeightedGraph<T> {
    private Set<Vertex<T>> nodes = new HashSet<>();

    // adds vertex
    public void addVertex(Vertex<T> v) {
        nodes.add(v);
    }

    // adds weighted edge
    public void addEdge(Vertex<T> from, Vertex<T> to, double weight) {
        from.addAdjacentVertex(to, weight);
    }

    // get all vertices
    public Set<Vertex<T>> getVertices() {
        return nodes;
    }
}
