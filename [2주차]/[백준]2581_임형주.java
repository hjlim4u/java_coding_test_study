import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int sum = 0;
        int min = -1;
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!prime[i]) continue;
            for (int j = 2; i*j <= n; j++) {
                prime[i*j] = false;
            }
        }

        for (int idx = m; idx <= n; idx++) {
            if (!prime[idx]) continue;
            if (min == -1) {
                min = idx;
            }
            sum = sum + idx;

        }
        if (sum==0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}