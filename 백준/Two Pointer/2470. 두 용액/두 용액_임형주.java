import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] answer = new int[2];
        int n = Integer.parseInt(st.nextToken());
        int cur = Integer.MAX_VALUE;
        int[] liquids = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquids);
        int idx = -1*Arrays.binarySearch(liquids, 0) -1;
        int left = idx - 1;
        int right = idx;
        // idx = idx < 0 ? -idx-1 : idx;
        if (idx < n-1 && liquids[idx] + liquids[idx+1] < cur) {
            cur = liquids[idx] + liquids[idx+1];
            answer[0] = liquids[idx];
            answer[1] = liquids[idx+1];
        }
        if (idx > 1 && Math.abs(liquids[idx-1] + liquids[idx-2]) < cur) {
            cur = Math.abs(liquids[idx-1] + liquids[idx-2]);
            answer[0] = liquids[idx-2];
            answer[1] = liquids[idx-1];
        }

        while (left >= 0 && right < n) {
            int sum = liquids[left] + liquids[right];
            if (Math.abs(sum) < cur) {
                cur = Math.abs(sum);
                answer[0] = liquids[left];
                answer[1] = liquids[right];
            }
            if (sum < 0) {
                right++;
            } else if (sum > 0) {
                left--;
            } else {
                break;
            }
        }
        Arrays.stream(answer).mapToObj(String::valueOf).forEach(s -> System.out.print(s+" "));
    }
}