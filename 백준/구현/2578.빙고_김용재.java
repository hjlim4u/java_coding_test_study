import java.util.HashSet;
import java.util.Scanner;

public class Maain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = new int[5][5];
        HashSet<Integer>[] s = new HashSet[12];
        int[] cnt = new int[12];
        for(int i=0;i<12;i++) {
            s[i]=new HashSet<>();
        }
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                arr[i][j]= in.nextInt();
                s[i].add(arr[i][j]);
            }
        }
        for(int j=0;j<5;j++) {
            for(int i=0;i<5;i++) {
                s[j+5].add(arr[i][j]);
            }
        }
        for(int i=0;i<5;i++) {
            s[10].add(arr[i][i]);
        }
        for(int i=0;i<5;i++) {
            s[11].add(arr[4-i][i]);
        }
        int res=0;
        for(int i=0;i<25;i++) {
            int temp = in.nextInt();
            for(int j=0;j<12;j++) {
                if (s[j].contains(temp)) {
                    cnt[j]++;
                    if(cnt[j]==5)
                        res++;
                    if(res==3) {
                        System.out.println(i+1);
                        return;
                    }
                }
            }
        }
    }
}
