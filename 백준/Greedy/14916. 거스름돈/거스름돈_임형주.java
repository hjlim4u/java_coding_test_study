import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        int answer = 0;
        n = sc.nextInt();
        int rest = n % 5;
        if (rest % 2 == 0) {
            answer = n / 5 + rest / 2;
        } else if (n > 5 && (rest+5) % 2 == 0) {
            answer = n / 5 - 1 + (rest + 5) / 2;
        } else {
            answer = -1;
        }
        System.out.println(answer);
    }
}