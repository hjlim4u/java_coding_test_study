import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 0; t <T ; t++) {
            int N = scanner.nextInt();
            int[] parent = new int[N+1];
            HashSet<Integer> path = new HashSet<>();
            for (int n = 0; n < N-1; n++) {
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                parent[B] = A;
            }
            int cur_left = scanner.nextInt();
            int cur_right = scanner.nextInt();
            while (true) {
                if (cur_left > 0 && path.contains(cur_left)) {
                    System.out.println(cur_left);
                    break;
                } else if (cur_right > 0 && path.contains(cur_right)) {
                    System.out.println(cur_right);
                    break;
                } else if (cur_right == cur_left) {
                    System.out.println(cur_left);
                    break;
                }
                if (cur_left > 0) {
                    path.add(cur_left);
                    cur_left = parent[cur_left];
                }
                if (cur_right > 0) {
                    path.add(cur_right);
                    cur_right = parent[cur_right];
                }
            }
        }
        

    }
}
