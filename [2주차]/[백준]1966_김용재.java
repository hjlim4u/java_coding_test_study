import java.util.*;

public class Main {
    public static class node {
        public int id;
        public int ipt;
        public node(int id, int ipt) {
            this.id = id;
            this.ipt = ipt;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0) {
            int n = in.nextInt();
            Queue<node> q = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>();
            int id = in.nextInt();
            for(int i=0;i<n;i++) {
                int temp = in.nextInt();
                q.add(new node(i, temp));
                list.add(temp);
            }
            Collections.sort(list, Collections.reverseOrder());
            int res=0;

            while(!q.isEmpty()) {
                int i = q.peek().id;
                int ipt = q.peek().ipt;
                q.poll();
                if(ipt == list.get(res)) {
                    res++;
                    if(i == id) {
                        System.out.println(res);
                        break;
                    }
                }
                else {
                    q.add(new node(i, ipt));
                }
            }
        }
    }
}
