import java.util.ArrayList;
import java.util.Scanner;

public class Mmmain {
    public static class Tree {
        public int num;
        public ArrayList<Tree> nb;
        public ArrayList<Integer> dist;
        public Tree(int num) {
            this.num = num;
            nb = new ArrayList<>();
            dist = new ArrayList<>();
        }
    }
    public static class TreeRepository {
        public ArrayList<Tree> list;
        public int[] vist;
        public int n;

        public int farDist;
        public Tree far;

        public TreeRepository() {
            list = new ArrayList<>();
        }
        public void initList() {
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
            vist = new int[n + 1];
            for(int i = 0; i <= n; i++) {
                list.add(new Tree(i));
            }
            for(int i = 1; i < n; i++) {
                int parent = in.nextInt();
                int child = in.nextInt();
                int dist = in.nextInt();
                Tree p = list.get(parent);
                Tree c = list.get(child);
                p.nb.add(c);
                p.dist.add(dist);
                c.nb.add(p);
                c.dist.add(dist);
            }
            far = list.get(1);
            farDist = 0;
        }
        public void dfs(Tree cur, int res) {
            if (vist[cur.num] == 1) return;
            vist[cur.num] = 1;
            if (res > farDist) {
                farDist = res;
                far = cur;
            }
            for (int i = 0; i < cur.nb.size(); i++) {
                Tree temp = cur.nb.get(i);
                int d = cur.dist.get(i);
                if(vist[temp.num] == 1) continue;
                dfs(temp, res + d);
            }
        }
        public void startDfs() {
            for(int i = 1; i <= n; i++) {
                vist[i] = 0;
            }
            dfs(far, 0);
        }
    }
    public static void main(String[] args) {
        TreeRepository treeRepository = new TreeRepository();
        treeRepository.initList();
        treeRepository.startDfs();
        treeRepository.startDfs();
        System.out.println(treeRepository.farDist);
    }
}
