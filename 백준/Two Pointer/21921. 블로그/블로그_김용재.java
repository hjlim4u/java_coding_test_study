import java.util.Scanner;

public class Maain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int[] arr = new int[n];
        int maxNum = 0;
        int cnt = 0;
        int sum = 0;
        for(int i =0;i<n;i++) {
            int temp = in.nextInt();
            arr[i] = temp;
            sum = sum + temp;
            if (i==x-1) {
                maxNum = sum;
                cnt++;
            }
            else if(i>x-1) {
                sum = sum - arr[i-x];
                if (sum>maxNum) {
                    maxNum = sum;
                    cnt=1;
                }
                else if (sum == maxNum) {
                    cnt++;
                }
            }
        }
        if(maxNum==0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(maxNum);
        System.out.println(cnt);
    }
}
