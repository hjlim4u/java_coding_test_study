import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int LCA(int node1, int node2, int[] depth, int[][] parent) {
        if(depth[node1] > depth[node2]) {
            int temp = node1;
            node1 = node2;
            node2 = temp;
        }
        for(int i=19;i>=0;i--) {
            if(depth[node2] - depth[node1] >= (1 << i)) {
                node2 = parent[node2][i];
            }
        }
        if(node1 == node2) {
            return node1;
        }
        for(int i=19;i>=0;i--) {
            if(parent[node1][i] != parent[node2][i]) {
                node1 = parent[node1][i];
                node2 = parent[node2][i];
            }
        }
        return parent[node1][0];
    }
    public static void setDepth(int d, int cur, int[] depth, ArrayList<Integer>[] child) {
        depth[cur] = d;
        for(int i=0;i<child[cur].size(); i++) {
            setDepth(d+1, child[cur].get(i), depth, child);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcase = in.nextInt();
        while(testcase-->0) {
            int n = in.nextInt();
            int[][] parent = new int[n+1][20];
            int[] depth = new int[n+1];
            ArrayList<Integer>[] child = new ArrayList[n+1];
            for(int i=1;i<=n;i++) {
                parent[i][0] = i;
                child[i] = new ArrayList<>();
            }
            for(int i=1;i<n;i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                parent[b][0] = a;
                child[a].add(b);
            }
            int root = 0;
            for(int i=1;i<=n;i++) {
                if(parent[i][0] == i) {
                    root = i;
                    break;
                }
            }
            setDepth(0, root, depth, child);
            for(int j = 1; j < 20; j++) {
                for(int i = 1; i <= n; i++) {
                    parent[i][j] = parent[parent[i][j-1]][j-1];
                }
            }
            int node1 = in.nextInt();
            int node2 = in.nextInt();
            System.out.println(LCA(node1, node2, depth, parent));
        }
    }
}
