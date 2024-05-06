import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n, m;
        int answer = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        int cur_length = n;
        Queue<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dq.offer(i);
        }
        for (int j = 0; j < m; j++) {
            int k = sc.nextInt();
            int min_rotate = 0;
            while(!dq.isEmpty() && dq.peek()!=k) {
                min_rotate+=1;
                dq.offer(dq.poll());
            }
            dq.poll();
            min_rotate = Math.min(min_rotate, cur_length - min_rotate);
            answer += min_rotate;
            cur_length -= 1;
        }
        System.out.println(answer);
    }
}