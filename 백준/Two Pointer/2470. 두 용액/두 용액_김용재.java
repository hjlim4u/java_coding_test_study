import java.util.Arrays;
import java.util.Scanner;

public class Maaaain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        String[] arr = in.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        Integer[] intArray = Arrays.stream(arr)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        Arrays.sort(intArray);
        int l=0;
        int r=n-1;
        int minNum = 2000000000;
        int minl =0;
        int minr =0;
        while(l<r) {
            int sum = intArray[l]+intArray[r];
            if (Math.abs(sum) < minNum) {
                minNum = Math.abs(sum);
                minl = intArray[l];
                minr = intArray[r];
            }
            if(sum>0) {
                r--;
            }
            else if (sum<0) {
                l++;
            }
            else break;
        }
        System.out.println(minl+" "+minr);
    }
}
