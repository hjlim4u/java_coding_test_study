// 백준 1747번 : 소수&팰린드롬
// 메모리 42824 KB
// 시간 328 ms
// 코드길이 806 B

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        for(int i = n; ; i++) {
            if(isPalindrome(i) && isPrime(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean isPalindrome(int n) {
        String num = Integer.toString(n);
        for(int i = 0; i <= num.length() / 2; i++) {
            if(num.charAt(i) != num.charAt(num.length() - i - 1)) return false;
        }

        return true;
    }

    public static boolean isPrime(int n) {
        if(n <= 1) return false;
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}