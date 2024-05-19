import java.util.*;

public class Main {
    public static HashMap<Integer, List<int[]>> graph;
    public static int answer = 0;

    public static int dfs(int node) {
        if (!graph.containsKey(node)) {
            return 0;
        }
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] path: graph.get(node)) {
            pq.add(dfs(path[0]) + path[1]);
        }
        int first = pq.isEmpty() ? 0 : pq.poll();
        int second = pq.isEmpty() ? 0 : pq.poll();
        answer = Math.max(answer, first + second);
        return first;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        if(scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        graph = new HashMap<>();
        int p, s, d;
        for (int i = 0; i < n; i++) {
            if(scanner.hasNextInt()) {
                p = scanner.nextInt();
            } else {
                break;
            }
            if(scanner.hasNextInt()) {
                s = scanner.nextInt();
            } else {
                break;
            }
            if(scanner.hasNextInt()) {
                d = scanner.nextInt();
            } else {
                break;
            }
            graph.putIfAbsent(p, new ArrayList<>());
            graph.get(p).add(new int[]{s, d});
        }
        scanner.close();
        
        if (graph.containsKey(1)) {
            dfs(1);
        }
        System.out.println(answer);
    }
}
