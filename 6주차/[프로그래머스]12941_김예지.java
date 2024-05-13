import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[B.length - i - 1]  ;
        }

        return answer;
    }
}

//정확성  테스트
//테스트 1 〉	통과 (0.38ms, 74.8MB)
//테스트 2 〉	통과 (0.71ms, 79.6MB)
//테스트 3 〉	통과 (0.55ms, 76.5MB)
//테스트 4 〉	통과 (0.39ms, 71.5MB)
//테스트 5 〉	통과 (0.43ms, 76.6MB)
//테스트 6 〉	통과 (0.40ms, 73.8MB)
//테스트 7 〉	통과 (0.44ms, 73.1MB)
//테스트 8 〉	통과 (0.63ms, 76.1MB)
//테스트 9 〉	통과 (0.41ms, 80.8MB)
//테스트 10 〉	통과 (0.38ms, 76.4MB)
//테스트 11 〉	통과 (0.41ms, 74.7MB)
//테스트 12 〉	통과 (0.36ms, 67.7MB)
//테스트 13 〉	통과 (0.38ms, 84.4MB)
//테스트 14 〉	통과 (0.39ms, 71.9MB)
//테스트 15 〉	통과 (0.36ms, 73.1MB)
//테스트 16 〉	통과 (0.36ms, 77.3MB)

//효율성  테스트
//테스트 1 〉	통과 (1.42ms, 68.2MB)
//테스트 2 〉	통과 (1.95ms, 53.1MB)
//테스트 3 〉	통과 (1.40ms, 52.7MB)
//테스트 4 〉	통과 (1.94ms, 51.8MB)

//채점 결과
//정확성: 69.6
//효율성: 30.4
//합계: 100.0 / 100.0
