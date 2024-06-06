import java.util.*;
import java.util.stream.*;

public class Main{
    static int answer;
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        answer = 0;
		int k, m;
        Set<Integer> set;
        Set<String> visited = new HashSet<>();
        int answer = 0;
		k = sc.nextInt();
		m = sc.nextInt();
        int[] prime = new int[(int)Math.pow(10,k)+1];
        List<Integer> primes = new ArrayList<>();
        prime[0] = 1;
        prime[1] = 1;
        for(int i = 2; i < prime.length; i++) {
            if (prime[i] == 1) continue;
            primes.add(i);
            for (int j = 2; i*j < prime.length; j++) {
                prime[i*j] = 1;
            }
        }
        for(int i = 0; i < primes.size() - 1; i++) {
            // if (prime[i] == 1) continue;
            for (int j = i+1; j < primes.size(); j++) {
                // if (prime[j] == 1) continue;
                int total = primes.get(i) + primes.get(j);
                String s = String.valueOf(total);
                if (s.length() > k) break;
                if (s.length() < k) continue;
                set = s.chars().boxed().collect(Collectors.toSet());
                if (set.size() != k) continue;
                while (total % m == 0) {
                    total /= m;
                }
                for (int d = 0; primes.get(d) <= Math.sqrt(total); d++) {
                    if (total % primes.get(d) == 0){
                        if (prime[total/primes.get(d)] == 0) visited.add(s);
                        break;
                    }
                }
            }
        }
        System.out.println(visited.size());
	}
}
