import java.util.*;

public class Maaain {
    public static void main(String[] args) {
        int[] era = new int[100000];
        era[1] = 1;
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> res = new HashSet<>();
        HashSet<Character> s = new HashSet<>();
        for(int i = 2; i < 100000; i++) {
            if(era[i] == 0) {
                list.add(i);
                for(int j = 2; i * j < 100000; j++) {
                    era[i*j] = 1;
                }
            }
        }
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int m = in.nextInt();
        for(int i = 0; i < list.size();i++) {
            for(int j = i + 1; j < list.size(); j++) {
                int temp = list.get(i) + list.get(j);
                String strTemp = String.valueOf(temp);
                if(strTemp.length() > k) break;
                if(strTemp.length() == k) {
                    s.clear();
                    for(int p = 0; p < k; p++) {
                        s.add(strTemp.charAt(p));
                    }
                    if(s.size() == k) {
                        while(temp % m == 0)
                            temp = temp / m;
                        for(int p = 0; p < list.size(); p++) {
                            if(temp % list.get(p) == 0) {
                                if(era[temp/list.get(p)] == 0) {
                                    res.add(list.get(i) + list.get(j));
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(res.size());
    }
}
