import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] count = new int[id_list.length]; // 신고당한 횟수
        boolean[][] target_id = new boolean[id_list.length][id_list.length]; // 신고한 id
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            hashMap.put(id_list[i], i); // id list
        }

        for (int i = 0; i < report.length; i++) {
            String[] reportInfo = report[i].split(" ");
            String from = reportInfo[0];
            String to = reportInfo[1];
            int fromIdx = hashMap.get(from);
            int toIdx = hashMap.get(to);

            if (!target_id[fromIdx][toIdx]) {
                target_id[fromIdx][toIdx] = true;
                count[toIdx]++;
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            for (int j = 0; j < id_list.length; j++) {
                if (target_id[i][j] && count[j] >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}

//정확성  테스트
//테스트 1 〉	통과 (0.19ms, 78.2MB)
//테스트 2 〉	통과 (0.18ms, 79.5MB)
//테스트 3 〉	통과 (97.55ms, 145MB)
//테스트 4 〉	통과 (0.34ms, 73.2MB)
//테스트 5 〉	통과 (0.28ms, 67.8MB)
//테스트 6 〉	통과 (4.95ms, 79.1MB)
//테스트 7 〉	통과 (5.44ms, 82.4MB)
//테스트 8 〉	통과 (9.19ms, 93.7MB)
//테스트 9 〉	통과 (52.17ms, 127MB)
//테스트 10 〉	통과 (67.52ms, 134MB)
//테스트 11 〉	통과 (141.02ms, 144MB)
//테스트 12 〉	통과 (3.46ms, 83.7MB)
//테스트 13 〉	통과 (2.44ms, 75.1MB)
//테스트 14 〉	통과 (68.40ms, 138MB)
//테스트 15 〉	통과 (83.39ms, 146MB)
//테스트 16 〉	통과 (1.22ms, 76.6MB)
//테스트 17 〉	통과 (1.93ms, 87.2MB)
//테스트 18 〉	통과 (3.12ms, 79.9MB)
//테스트 19 〉	통과 (4.06ms, 81.5MB)
//테스트 20 〉	통과 (61.62ms, 131MB)
//테스트 21 〉	통과 (89.52ms, 167MB)
//테스트 22 〉	통과 (0.11ms, 75.5MB)
//테스트 23 〉	통과 (0.10ms, 74.8MB)
//테스트 24 〉	통과 (0.20ms, 81.3MB)

//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0