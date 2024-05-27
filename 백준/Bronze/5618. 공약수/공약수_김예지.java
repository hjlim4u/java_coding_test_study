// 백준 5618번 : 공약수
// 메모리 17688 KB
// 시간 212 ms
// 코드길이 1303 B

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int gcd = gcd(numbers[0], numbers[1]);
        if (n == 3) {
            gcd = gcd(gcd, numbers[2]);
        }

        ArrayList<Integer> commonDivisors = new ArrayList<>();
        for (int i = 1; i * i <= gcd; i++) {
            if (gcd % i == 0) {
                commonDivisors.add(i);
                if (i != gcd / i) {
                    commonDivisors.add(gcd / i);
                }
            }
        }
        Collections.sort(commonDivisors);

        for (int divisor : commonDivisors) {
            System.out.println(divisor);
        }

        scanner.close();
    }

    // 두 숫자의 최대공약수 구하기 (유클리드 호제법)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
