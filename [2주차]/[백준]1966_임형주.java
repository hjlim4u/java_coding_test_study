import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcase = Integer.parseInt(scanner.nextLine());
        int[] answers = new int[testcase];
        for (int t = 0; t < testcase; t++) {
            TreeMap<Integer, ArrayList<Integer>> printer = new TreeMap<>((o1, o2) -> o2-o1);
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int pivot = -1;
            int cursor = 0;
            int answer = 0;
            for (int i = 0; i < n; i++) {
                int priority = scanner.nextInt();
                if (i==m) {pivot = priority; }
                if (!printer.containsKey(priority)) {
                    printer.put(priority, new ArrayList<Integer>());
                }
                printer.get(priority).add(i);
            }
            for (Map.Entry<Integer, ArrayList<Integer>> entry: printer.entrySet()) {
                int tempidx = Collections.binarySearch(entry.getValue(), cursor);
                int idx = tempidx < 0? -(tempidx+1): tempidx;
                if (entry.getKey() > pivot) {
                    cursor = entry.getValue().get((entry.getValue().size()+idx-1)%entry.getValue().size());
                    answer = answer + entry.getValue().size();
                } else if (entry.getKey()==pivot) {
                    int pivotidx = Collections.binarySearch(entry.getValue(), m);
                    answer = answer + (pivotidx < idx ? entry.getValue().size() + 1 - (idx - pivotidx) : pivotidx-idx+1);
                    break;
                }

            }
            answers[t] = answer;

        }
        for (int a : answers) {
            System.out.println(a);
        }

    }
}