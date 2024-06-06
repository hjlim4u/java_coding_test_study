// baekjoon 14916
// 메모리 14228kb	성능 128ms

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = -1;

        for (int i = n / 5; i >= 0; i--) {
            int remaining = n - (i * 5);
            if (remaining % 2 == 0) {
                count = i + (remaining / 2);
                break;
            }
        }

        System.out.println(count);
        br.close();
    }
}

