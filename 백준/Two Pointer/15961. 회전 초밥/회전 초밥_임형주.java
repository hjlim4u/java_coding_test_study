import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] table = new int[n];
        for (int i = 0; i < n; i++) {
            table[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        Map<Integer, Integer> dish = new HashMap<>();
        dish.put(c, 1);
        int left = 0, right = 0;
        if (n == k) {
            System.out.println(Arrays.stream(table).distinct().count());
            return;
        }
        while (left < n) {
            dish.put(table[right], dish.getOrDefault(table[right], 0) + 1);
            if (right > left && right - left + 1 > k || left > right && n + right - left + 1 > k) {
                dish.put(table[left], dish.get(table[left]) - 1);
                if (dish.get(table[left]) == 0) {
                    dish.remove(table[left]);
                }
                left++;
            }
            answer = Math.max(answer, dish.size());
            right = (right+1) % n;
        }
        System.out.println(answer);
    }
}