// baekjoon 22862 가장 긴 짝수 연속한 부분 수열 (large)
// 메모리 91176 kb	성능 504 ms

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        int R = 0, max = 0, cnt = 0;

        for (int L = 1; L <= N; L++) {
            // 왼쪽 포인터가 오른쪽으로 이동할 때마다 빠지는 홀수의 카운트 감소
            if (cnt >= 1 && arr[L - 1] % 2 != 0) cnt--;

            while (R + 1 <= N && cnt <= K) {
                if (arr[++R] % 2 != 0) cnt++;
            }

            max = Math.max(max, R - L + 1 - cnt);
        }

        System.out.println(max);
    }
}