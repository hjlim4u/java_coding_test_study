// baekjoon 15961
// 메모리 170872 kb	성능 544 ms
	
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] visited = new int[d + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;

        // 초기 윈도우 설정
        for (int i = 0; i < k; i++) {
            if (visited[arr[i]] == 0) cnt++;
            visited[arr[i]]++;
        }

        int answer = cnt;

        for (int i = 1; i < N; i++) {
            if (answer <= cnt) {
                if (visited[c] == 0) {
                    answer = cnt + 1;
                } else {
                    answer = cnt;
                }
            }

            // 왼쪽 포인터가 오른쪽으로 이동할 때마다 빠지는 초밥 제거 및 카운트 감소
            visited[arr[i - 1]]--;
            if (visited[arr[i - 1]] == 0) cnt--;

            int nextIndex = (i + k - 1) % N;
            if (visited[arr[nextIndex]] == 0) cnt++;
            visited[arr[nextIndex]]++;
        }

        if (answer <= cnt) {
            if (visited[c] == 0) {
                answer = cnt + 1;
            } else {
                answer = cnt;
            }
        }

        System.out.println(answer);
    }
}