
import java.util.*;

class Edge {
    String node;
    int weight;

    Edge(String n, int w) {
        node = n;
        weight = w;
    }
}

public class CityNetwork {
    static Map<String, List<Edge>> graph = new HashMap<>();

    public static void addEdge(String u, String v, int w, boolean bidirectional) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(new Edge(v, w));

        if (bidirectional) {
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(new Edge(u, w));
        }
    }

    public static void bfs(String start) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            String curr = q.poll();
            System.out.print(curr + " ");

            for (Edge e : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(e.node)) {
                    visited.add(e.node);
                    q.add(e.node);
                }
            }
        }
    }
}
