import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n, x;
        int answer = 0;

        n = sc.nextInt();
        x = sc.nextInt();
        int left = 0;
        int cur = 0;
        int cnt = 0;
        int[] visitor = new int[n];
        for (int i = 0; i < n; i++) {
            visitor[i] = sc.nextInt();
        }
        for (int right = 0; right < n; right++) {
            cur += right >= x? visitor[right] - visitor[left++]:  visitor[right];
            if (cur == answer) {
                cnt += 1;
            } else if (cur > answer) {
                answer = cur;
                cnt = 1;
            }
        }
        if (answer == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(answer);
            System.out.println(cnt);
        }
    }
}