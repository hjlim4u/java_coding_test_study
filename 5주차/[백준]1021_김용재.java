import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int n;
    public static int  m;
    public static int []arr;
    public static int []brr;
    public static int r(int k, int q)
    {
        if (k > q)
        {
            int a = k;
            k = q;
            q = a;
        }
        int temp = 0;
        int rtemp = 0;
        for (int i = k + 1; i <= q; i++)
        {
            if (arr[i] == 1)
                temp++;
        }
        for (int i = 1; i <= k; i++)
        {
            if (arr[i] == 1)
                rtemp++;
        }
        for (int i = q + 1; i <= n; i++)
        {
            if (arr[i] == 1)
                rtemp++;
        }
        return Math.min(temp, rtemp);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n+1];
        for(int i=1; i<=n;i++) {
            arr[i]=1;
        }
        brr = new int[m];
        for(int i=0; i<m;i++) {
            int temp = in.nextInt();
            brr[i]=temp;
        }
        int answer = 0;
        int k = 1;
        int cnt = n;
        for (int i = 0; i < m; i++)
        {
            answer = answer + r(k, brr[i]);
            arr[brr[i]] = 0;
            cnt--;
            if (cnt == 0)
                break;
            for (int j = brr[i] + 1;; j++)
            {
                if (j == n + 1)
                    j = 0;
                if (arr[j] == 1)
                {
                    k = j;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
