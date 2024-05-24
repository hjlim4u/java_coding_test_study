import java.util.Scanner;

public class Main {
    public static int gcd(int num1, int num2) {
        if(num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        while(num2 != 0) {
            int r = num1 % num2;
            num1 = num2;
            num2 = r;
        }
        return num1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        for(int i = 0; i < n; i++) {
            int temp = in.nextInt();
            if(res == 0)
                res = temp;
            else res = gcd(res, temp);
        }
        for(int i = 1; i <= res; i++) {
            if(res % i == 0)
                System.out.println(i);
        }
    }
}