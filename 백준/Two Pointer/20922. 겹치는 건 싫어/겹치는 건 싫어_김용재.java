import java.util.HashMap;
import java.util.Scanner;

public class Maaain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        String[] arr = in.nextLine().split(" ");
        int n=Integer.parseInt(line[0]);
        int k=Integer.parseInt(line[1]);
        int l=0;
        int r=0;
        int res=0;
        HashMap<String, Integer> map = new HashMap<>();
        while(r<n) {
            String temp = arr[r];
            String front = arr[l];
            if(!map.containsKey(temp)) {
                map.put(temp,1);
                if(res<r-l+1) res = r-l + 1;
                r++;
            }
            else {
                if(map.get(temp)<k) {
                    map.put(temp, map.get(temp)+1);
                    if(res<r-l+1) res = r-l + 1;
                    r++;
                }
                else {
                    map.put(front, map.get(front)-1);
                    l++;
                }
            }
        }
        System.out.println(res);
    }
}
