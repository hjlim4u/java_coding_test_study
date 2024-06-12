import java.util.*;
import java.util.stream.*;
import java.io.*;
public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] answer = new int[n+m];
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a_pos = 0, b_pos = 0;
        int i_pos = 0;
        while (a_pos < n && b_pos < m) {
            if (a[a_pos]<b[b_pos]) {
                answer[i_pos++]=a[a_pos++];
            } else {
                answer[i_pos++] = b[b_pos++];
            }
        }
        if (a_pos<n) {
            System.arraycopy(a, a_pos, answer, i_pos, n-a_pos);
        }
        if (b_pos<m) {
            System.arraycopy(b, b_pos, answer, i_pos, m - b_pos);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.print(sb);
    }
}