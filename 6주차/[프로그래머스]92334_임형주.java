import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Set<String>> complaints = new HashMap<>();
        HashMap<String, Integer> counter = new HashMap<>();
        
        for (String r : report) {
            String[] arr = r.split(" ");
            complaints.putIfAbsent(arr[1], new HashSet<String>());
            complaints.get(arr[1]).add(arr[0]);
        }
        
        complaints.entrySet().stream().filter(e -> e.getValue().size() >= k).forEach(e -> {
            for (String mail : e.getValue()) {
                counter.put(mail, counter.getOrDefault(mail, 0)+1);
            }
            
        });
        
        for (int i = 0; i < id_list.length; i++) {
            if (counter.containsKey(id_list[i])) {
                answer[i] = counter.get(id_list[i]);
            }
        }
        return answer;
    }
}