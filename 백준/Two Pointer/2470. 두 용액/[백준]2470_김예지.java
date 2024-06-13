// baekjoon 2470 두 용액
// 메모리 28748 kb	성능 396 ms

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int L = 0, R = N - 1;
        int min = Integer.MAX_VALUE;
        int answerS = 0, answerE = 0;
        while (L < R) {
            int sum = Math.abs(arr[R] + arr[L]);
            if (sum < min) {
                min = sum;
                answerS = L;
                answerE = R;
            }

            if (sum == 0)
                break;

            if (arr[R] + arr[L] > 0) R--;
            else L++;
        }

        System.out.println(arr[answerS] + " " + arr[answerE]);
    }
}