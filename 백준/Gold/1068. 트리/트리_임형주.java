import java.util.*;

public class Main {
    public static void main(String[] args) {
        //input
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        HashMap<Integer, List<Integer>> children = new HashMap<>();
        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            int p =scanner.nextInt();
            children.putIfAbsent(p, new ArrayList<>());
            children.get(p).add(i);
            parent[i] = p;
        }
        int leaf = N - children.size() + 1;
        
        int removeNode = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(removeNode);
        
        while (!queue.isEmpty()) {
            int p = queue.poll();
            if (children.containsKey(p)) {
                for (int c : children.get(p)) {
                    queue.offer(c);
                }
            } else {
                leaf -= 1;
            }
        }
        if (children.get(parent[removeNode]).size() == 1 && parent[removeNode] != -1) {
            leaf += 1;
        }
        System.out.println(leaf);

        
    }
}
