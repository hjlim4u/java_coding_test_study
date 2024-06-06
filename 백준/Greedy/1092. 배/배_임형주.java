import java.io.IOException;
import java.util.*;

public class Main {
    public static int[] cranes;
    public static int[] boxes;
    public static boolean load(int interval) {
        int c = cranes.length-1;
        for (int i = boxes.length-1;c>=0&&i>=0; i-=interval) {
            if (cranes[c] < boxes[i]) return false;
            c -= 1;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        cranes = new int[n];
        for (int i = 0; i < n; i++) {
            cranes[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        boxes = new int[m];
        for (int i = 0; i < m; i++) {
            boxes[i] = scanner.nextInt();
        }
        Arrays.sort(cranes);
        Arrays.sort(boxes);
        if (boxes[boxes.length-1] > cranes[cranes.length-1]) {
            System.out.println(-1);
            return;
        }
        //logic
        int low = (int)Math.ceil((double)m/n);
        int high = m;
        int mid;
        while (low < high) {
            mid = (low+high)/2;
            if (load(mid)) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        //output
        System.out.println((low+high)/2);
    }
}