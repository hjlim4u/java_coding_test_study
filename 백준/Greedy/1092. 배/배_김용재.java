import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Maaain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] crane = new Integer[n];
        for(int i=0;i<n;i++) {
            crane[i] = in.nextInt();
        }
        int m = in.nextInt();
        Integer[] box = new Integer[m];
        for(int i=0;i<m;i++) {
            box[i]=in.nextInt();
        }
        Arrays.sort(crane, Collections.reverseOrder());
        Arrays.sort(box, Collections.reverseOrder());
        int res = 0;
        if(crane[0]<box[0]) {
            res=-1;
        }
        else {
            int rest = m % n;
            int temp;
            if (rest == 0)
                temp = m / n;
            else
                temp = m / n + 1;
            int j = 0;
            for (int i = 0; i < n; i++)
            {
                if (j >= m)
                    break;
                if (crane[i] < box[j])
                {
                    temp++;
                    i = -1;
                    j = 0;
                    continue;
                }
                j += temp;
            }
            res=temp;
        }
        System.out.println(res);
    }
}
