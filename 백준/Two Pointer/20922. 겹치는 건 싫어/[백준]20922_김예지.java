// baekjoon 20922 겹치는 건 싫어
// 메모리 32748 kb	성능 364 ms

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int[] nums = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        int R = 0, cnt = 0;

        for(int L = 1; L <= N; L++) {
            // 왼쪽 포인터가 오른쪽으로 이동할 때마다 빠지는 수의 카운트 감소
            nums[arr[L - 1]]--;

            while(R + 1 <= N && nums[arr[R + 1]] < K) {
                nums[arr[++R]]++;
            }

            if (cnt < R - L + 1) {
                cnt = R - L + 1;
            }
        }

        System.out.println(cnt);
    }
}