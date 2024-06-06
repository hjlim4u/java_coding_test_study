import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> deque = new LinkedList<Integer>();

        int cnt = 0;
        int N = scan.nextInt();
        int M = scan.nextInt();

        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] arr = new int[M];

        for(int i = 0; i < M; i++) {
            arr[i] = scan.nextInt();
        }

        for(int i = 0; i < M; i++) {
            int target = deque.indexOf(arr[i]);
            int middle;

            if(deque.size() % 2 == 0) {
                middle = deque.size() / 2 - 1;
            }
            else {
                middle = deque.size() / 2;
            }

            if(target <= middle) {
                for(int j = 0; j < target; j++) {
                    deque.offerLast(deque.pollFirst());
                    cnt++;
                }
            } else {
                for(int j = 0; j < deque.size() - target; j++) {
                    deque.offerFirst(deque.pollLast());
                    cnt++;
                }

            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}