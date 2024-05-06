import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        HashMap<String, Integer> lastIndex = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int start = 0;
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (lastIndex.containsKey(city) && lastIndex.get(city) >= start) {
                answer += 1;
            } else {
                answer += 5;
                if (lastIndex.size() >= cacheSize) {
                    while (!pq.isEmpty() && pq.peek() < lastIndex.get(cities[pq.peek()].toLowerCase())) {
                        pq.poll();
                    }
                    if (!pq.isEmpty() && cacheSize > 0) {
                        start = pq.poll()+1;
                    } else {
                        start = i+1;
                    }

                }
            }
            pq.add(i);
            lastIndex.put(city, i);
        }
        return answer;
    }
}