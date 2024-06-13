import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int temp = in.nextInt();
            list.add(temp);
        }
        for(int i=0;i<m;i++) {
            int temp = in.nextInt();
            list.add(temp);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder("");
        for(int i =0;i<n+m;i++) {
            sb.append(list.get(i));
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
