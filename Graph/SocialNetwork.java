
import java.util.*;

public class SocialNetwork {
    static Map<String, List<String>> graph = new HashMap<>();

    public static void addEdge(String u, String v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.putIfAbsent(v, new ArrayList<>());
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static List<String> getFriends(String user) {
        return graph.getOrDefault(user, new ArrayList<>());
    }

    public static boolean areConnected(String u, String v) {
        return graph.getOrDefault(u, new ArrayList<>()).contains(v);
    }

    public static List<String> shortestPath(String start, String end) {
        Queue<String> q = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();

        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.equals(end)) break;

            for (String nei : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    parent.put(nei, curr);
                    q.add(nei);
                }
            }
        }

        List<String> path = new ArrayList<>();
        for (String at = end; at != null; at = parent.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}
