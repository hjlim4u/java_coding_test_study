import java.util.Arrays;
import java.util.Scanner;

public class Maaaaain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        String[] arr = in.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        Integer[] intArray = Arrays.stream(arr)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        int l = 0;
        int r = 0;
        int odd = 0;
        int res = 0;
        int cnt = 0;
        while(r<n && l<=r) {
            if(intArray[r]%2==0) {
                cnt++;
                if(res<cnt)
                    res=cnt;
                r++;
            }
            else {
                if(odd<k) {
                    odd++;
                    r++;
                }
                else {
                    if(intArray[l]%2==0) {
                        l++;
                        cnt--;
                    }
                    else {
                        odd--;
                        l++;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
