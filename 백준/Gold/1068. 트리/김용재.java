import java.util.ArrayList;
import java.util.Scanner;

public class Mmain {
    public static class Node {
        public int num;
        public ArrayList<Node> child;
        public Node() {
            child = new ArrayList<>();
        }
    }
    public static class NodeRepository {
        public ArrayList<Node> list;
        public int remove;
        public NodeRepository() {
            list = new ArrayList<>();
        }
        public Node root;

        public void initList() {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            for(int i = 0; i < n; i++) {
                list.add(new Node());
            }
            for(int i = 0; i < n; i++) {
                int parent = in.nextInt();
                Node temp = list.get(i);
                temp.num = i;
                list.add(temp);
                if (parent != -1) list.get(parent).child.add(temp);
                else root = temp;

            }
            remove = in.nextInt();
        }
        public int startDfs() {
            return dfs(root);
        }
        private int dfs(Node cur) {
            if (cur.num == remove) return 0;
            if (cur.child.size() == 0) return 1;
            int res = 0;
            for(int i = 0; i < cur.child.size(); i++) {
                res = res + dfs(cur.child.get(i));
            }
            if (res == 0)
                res = 1;
            return res;
        }

    }
    public static void main(String[] args) {
        NodeRepository nodeRepository = new NodeRepository();
        nodeRepository.initList();
        System.out.println(nodeRepository.startDfs());
    }
}
