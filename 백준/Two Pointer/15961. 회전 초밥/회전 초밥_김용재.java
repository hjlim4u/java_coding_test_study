import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Maaaaaain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int d = Integer.parseInt(str[1]);
        int k = Integer.parseInt(str[2]);
        int c = Integer.parseInt(str[3]);
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
        }
        int res =0;
        int cnt=0;
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i=0;i<k;i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i],1);
                cnt++;
            }
            else {
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        for(int i=0;i<n;i++) {
            int l=i;
            int r=(i + k) % n;
            if(map.containsKey(c) && map.get(c)>0) {
                if(res<cnt)
                    res=cnt;
            }
            else {
                if(res<cnt+1)
                    res=cnt+1;
            }
            if(map.containsKey(arr[r])) {
                if(map.get(arr[r])==0) cnt++;
                map.put(arr[r],map.get(arr[r])+1);

            }
            else {
                map.put(arr[r],1);
                cnt++;
            }
            map.put(arr[l],map.get(arr[l])-1);
            if(map.get(arr[l])==0) cnt--;
        }
        System.out.println(res);
    }
}
