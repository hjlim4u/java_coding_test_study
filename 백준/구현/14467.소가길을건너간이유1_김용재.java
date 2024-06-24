import java.util.Scanner;

public class Maaaain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] cow = new int[11];
        int res=0;
        for(int i=1;i<11;i++) {
            cow[i]=-1;
        }
        for(int i=0;i<n;i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if(cow[a]==-1)
                cow[a]=b;
            else if (cow[a] != b) {
                res++;
                cow[a]=b;
            }
        }
        System.out.print(res);
    }
}
