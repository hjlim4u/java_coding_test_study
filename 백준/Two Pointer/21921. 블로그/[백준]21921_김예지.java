// baekjoon 21921 블로그
// 메모리 35160 kb	성능 376 ms

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }

        int max = sum;
        int maxCnt = 1;
        for (int i = X; i < N; i++) {
            sum += arr[i] - arr[i - X];
            if (max == sum) maxCnt++;
            else if (max < sum) {
                max = sum;
                maxCnt = 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(maxCnt);
    }
}