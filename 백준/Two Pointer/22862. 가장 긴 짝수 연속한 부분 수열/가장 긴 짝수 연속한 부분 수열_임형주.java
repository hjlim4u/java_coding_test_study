import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int left = 0, right = 0;
        int answer = 0;
        Queue<Integer> odd = new LinkedList<>();
        while (right < n) {
            if (odd.size() > k || !odd.isEmpty() && s[left]%2 == 1) {
                left = odd.poll()+1;
                continue;
            }
            if (s[right]%2 == 1) {
                odd.offer(right++);
            } else {
                answer = Math.max(answer, right-left+1-odd.size());
                right++;
            }
        }
        System.out.println(answer);
    }
}