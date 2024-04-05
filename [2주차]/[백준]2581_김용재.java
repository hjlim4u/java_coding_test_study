import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] era = new int[n+1];
        era[0]=1;
        era[1]=1;
        for(int i=2;i<=n;i++) {
            if(era[i] == 0) {
                for(int j=2;j*i<=n;j++) {
                    era[i*j] = 1;
                }
            }
        }
        int min = 0;
        int s = 0;
        for(int i = m;i<=n;i++) {
            if(era[i]==0) {
                s = s + i;
                if(min == 0)
                    min = i;
            }
        }
        if(min == 0)
            System.out.println(-1);
        else {
            System.out.println(s);
            System.out.println(min);
        }
    }
}
