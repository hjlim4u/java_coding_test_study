import java.util.Scanner;

public class Maain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = n/5;
        int res=-1;
        for(;i>=0;i--) {
            int t = n - (i*5);
            if(t%2==0) {
                res = i+(t/2);
                break;
            }
        }
        System.out.println(res);
    }
}
