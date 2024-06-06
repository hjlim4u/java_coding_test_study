import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0 ;i<cities.length;i++) {
            String city=cities[i].toUpperCase();
            if(list.contains(city)) {
                answer++;
                list.remove(city);
                list.add(city);
            }
            else {
                answer=answer+5;
                list.add(city);
                if(list.size()>cacheSize) {
                    list.remove(0);
                }
            }
        }
        return answer;
    }
}