// 백준 22943번 : 수
// 메모리 301500 KB
// 시간 948 ms
// 코드길이 2937 B

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static final int LIMIT = 98765;
    public static final ArrayList<Integer> primes = new ArrayList<>();
    public static final HashSet<Integer> primeSums = new HashSet<>();
    public static final HashSet<Integer> primeMults = new HashSet<>();
    public static boolean[] visited = new boolean[10];
    public static int k, m, answer = 0;

    public static void main(String[] args) throws Exception {
        initPrimes();
        initPrimeSumsAndMults();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        backtrack(0, 0);
        System.out.println(answer);
    }

    // 에라토스테네스의 체로 소수를 초기화
    public static void initPrimes() {
        boolean[] isNotPrime = new boolean[LIMIT + 1];
        int sqrtLimit = (int) Math.sqrt(LIMIT);

        for (int i = 3; i <= sqrtLimit; i += 2) {
            if (isNotPrime[i]) continue;
            for (int j = i * i; j <= LIMIT; j += i) {
                isNotPrime[j] = true;
            }
        }

        primes.add(2);
        for (int i = 3; i <= LIMIT; i += 2) {
            if (!isNotPrime[i]) primes.add(i);
        }
    }

    // 소수들의 합과 곱을 초기화
    public static void initPrimeSumsAndMults() {
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i; j < primes.size(); j++) {
                int prime1 = primes.get(i);
                int prime2 = primes.get(j);
                long product = 1L * prime1 * prime2;
                if (product <= LIMIT) {
                    primeMults.add((int) product);
                }
                if (prime1 != prime2) {
                    int sum = prime1 + prime2;
                    if (sum <= LIMIT) {
                        primeSums.add(sum);
                    }
                }
            }
        }
    }

    // 주어진 조건에 맞는 수인지 확인
    public static boolean isValid(int number) {
        if (!primeSums.contains(number)) return false;
        while (number % m == 0) {
            number /= m;
        }
        return primeMults.contains(number);
    }

    // 백트래킹을 이용한 브루트포스 탐색
    public static void backtrack(int idx, int current) {
        if (idx == k) {
            if (isValid(current)) {
                answer++;
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (i == 0 && idx == 0 || visited[i]) continue;
            visited[i] = true;
            backtrack(idx + 1, current * 10 + i);
            visited[i] = false;
        }
    }
}