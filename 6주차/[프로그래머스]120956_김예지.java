class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for (String str : babbling) {
            boolean isValid = true;
            for (String word : words) {
                str = str.replace(word, "1");
            }
            str = str.replace("1", "");

            if (str.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}

//정확성  테스트
//테스트 1 〉	통과 (0.30ms, 72.9MB)
//테스트 2 〉	통과 (2.65ms, 82.4MB)
//테스트 3 〉	통과 (0.65ms, 74.1MB)
//테스트 4 〉	통과 (0.67ms, 72.7MB)
//테스트 5 〉	통과 (0.68ms, 73.7MB)
//테스트 6 〉	통과 (0.39ms, 80.5MB)
//테스트 7 〉	통과 (0.39ms, 76.3MB)
//테스트 8 〉	통과 (0.71ms, 83.5MB)
//테스트 9 〉	통과 (0.28ms, 76.2MB)
//테스트 10 〉	통과 (0.39ms, 76.6MB)
//테스트 11 〉	통과 (0.12ms, 75.5MB)
//테스트 12 〉	통과 (0.07ms, 74.5MB)
//테스트 13 〉	통과 (0.13ms, 72MB)
//테스트 14 〉	통과 (0.17ms, 76MB)
//테스트 15 〉	통과 (0.19ms, 72.4MB)
//테스트 16 〉	통과 (0.17ms, 72.1MB)
//테스트 17 〉	통과 (0.13ms, 72.7MB)

//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0