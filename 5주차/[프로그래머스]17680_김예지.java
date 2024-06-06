import java.util.*;
class Solution {

    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> lru = new ArrayList<>();

        int time = 0;

        if (cacheSize == 0) {
            time = cities.length * 5;
            return time;
        }

        for (String city : cities) {
            String tmp = city.toUpperCase();

            if (lru.contains(tmp)) {

                lru.remove(tmp);
                lru.add(tmp);
                time++;

            } else {
                if (lru.size() == cacheSize) lru.remove(0);

                lru.add(tmp);
                time+=5;
            }
        }
        return time;
    }
}