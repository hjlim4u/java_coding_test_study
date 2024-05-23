import java.util.*;

public class Main{
    static int gcdBySteinsAlgorithm(int n1, int n2) {
    if (n1 == 0) {
        return n2;
    }

    if (n2 == 0) {
        return n1;
    }

    int n;
    for (n = 0; ((n1 | n2) & 1) == 0; n++) {
        n1 >>= 1;
        n2 >>= 1;
    }

    while ((n1 & 1) == 0) {
        n1 >>= 1;
    }

    do {
        while ((n2 & 1) == 0) {
            n2 >>= 1;
        }

        if (n1 > n2) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        n2 = (n2 - n1);
    } while (n2 != 0);
    return n1 << n;
}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n;
        int answer = 0;
		n = sc.nextInt();
        Deque<Integer> stack = new ArrayDeque<>();
		int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        answer = nums[0];
        for (int j = 1; j<nums.length; j++) {
            answer = gcdBySteinsAlgorithm(answer, nums[j]);
        }
        for(int d = 1; d <= (int)Math.sqrt(answer); d++) {
            if (answer % d == 0) {
                System.out.println(d);
                int divisor = answer/d;
                if (d != divisor) {
                    stack.addFirst(divisor);    
                }
                
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.removeFirst());    
        }
        
	}
}