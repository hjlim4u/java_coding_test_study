import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        String[] subtract = sc.nextLine().split("-");
        for (int i = 0; i < subtract.length; i++) {
            int total = Arrays.stream(subtract[i].split("\\+")).mapToInt(num -> Integer.parseInt(num)).sum();
            if (i == 0) {
                answer = total;
            } else {
                answer -= total;
            }
        }
        System.out.println(answer);
    }
}