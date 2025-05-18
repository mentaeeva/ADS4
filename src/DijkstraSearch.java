import java.util.*;

public class DijkstraSearch<T> {

    // ищем кратчайшие пути от source
    public Map<Vertex<T>, Double> dijkstra(Vertex<T> source) {
        Map<Vertex<T>, Double> dist = new HashMap<>();
        PriorityQueue<Vertex<T>> pq = new PriorityQueue<>(Comparator.comparing(dist::get));
        Set<Vertex<T>> visited = new HashSet<>();

        dist.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<T> current = pq.poll();

            if (visited.contains(current)) continue;
            visited.add(current);

            for (Map.Entry<Vertex<T>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<T> neighbor = entry.getKey();
                double weight = entry.getValue();

                if (visited.contains(neighbor)) continue;

                double newDist = dist.get(current) + weight;
                if (newDist < dist.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    dist.put(neighbor, newDist);
                    pq.add(neighbor);
                }
            }
        }

        return dist;
    }
}
