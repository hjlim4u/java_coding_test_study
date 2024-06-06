// baekjoon 1541
// 메모리 17624kb	성능 200ms

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();

        int answer = 0;
        String[] minus = exp.split("-");

        for(int i = 0; i < minus.length; i++){
            int sum = 0;
            String[] plus = minus[i].split("\\+");

            for(String pls : plus){
                sum += Integer.parseInt(pls);
            }

            if(i == 0)  answer += sum;
            else    answer -= sum;
        }

        System.out.println(answer);
    }
}