
import java.util.*;

public class NetworkRouting {
    static Map<String, List<String>> graph = new HashMap<>();

    public static void addEdge(String u, String v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static boolean isConnected(String start) {
        Set<String> visited = new HashSet<>();
        dfs(start, visited);
        return visited.size() == graph.size();
    }

    static void dfs(String node, Set<String> visited) {
        visited.add(node);
        for (String nei : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(nei)) dfs(nei, visited);
        }
    }

    public static int minHops(String start, String end) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, Integer> dist = new HashMap<>();

        q.add(start);
        visited.add(start);
        dist.put(start, 0);

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.equals(end)) return dist.get(curr);

            for (String nei : graph.get(curr)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    dist.put(nei, dist.get(curr) + 1);
                    q.add(nei);
                }
            }
        }
        return -1;
    }
}
