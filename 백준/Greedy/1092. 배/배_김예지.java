// baekjoon 1092
// 메모리 16148 kb	성능 224 ms

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] crane = new int[n];
        int[] cIndex = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        for (int i = 0; i < n; ++i) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] box = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; ++i) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(crane);
        Arrays.sort(box);

        if (crane[n - 1] < box[m - 1]) {
            result = -1;
        } else {
            for (int i = 0; i < n; ++i) {
                cIndex[n - i - 1] = m - i - 1;
            }

            while (true) {
                for (int i = n - 1; i >= 0; --i) {
                    while (cIndex[i] >= 0 && (box[cIndex[i]] <= 0 || crane[i] < box[cIndex[i]])) {
                        --cIndex[i]; // 크레인 무게 제한을 초과하거나 이미 처리된 박스는 건너뜀
                    }

                    // 더 이상 처리할 박스가 없는 경우
                    if (cIndex[i] < 0) {
                        if (i == n - 1) {
                            break;
                        }
                        continue;
                    }

                    // 크레인이 박스를 처리할 수 있는 경우
                    if (crane[i] >= box[cIndex[i]]) {
                        box[cIndex[i]] = 0; // 박스 처리 완료
                    }
                }

                if (cIndex[n - 1] < 0) {
                    break;
                }
                ++result;
            }
        }

        System.out.println(result);

        br.close();
    }
}
