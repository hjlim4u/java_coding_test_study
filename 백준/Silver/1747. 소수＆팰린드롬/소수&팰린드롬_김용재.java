import java.util.Scanner;

public class Maain {
    public static void main(String[] args) {
        int[] era = new int[10000001];
        era[1] = 1;
        for(int i = 2; i <= Math.sqrt(10000000); i++) {
            if(era[i] == 0) {
                for(int j = 2; i * j <= 10000000; j++) {
                    era[i*j] = 1;
                }
            }
        }
        Scanner in = new Scanner(System.in);
        boolean check = false;
        int n = in.nextInt();
        for(int i=n;;i++) {
            if(era[i]==0) {
                String temp = String.valueOf(i);
                for(int j = 0; j < temp.length(); j++) {
                    if(temp.charAt(j) != temp.charAt(temp.length() - 1 - j)) {
                        break;
                    }
                    if(j == temp.length() - 1) {
                        check = true;
                    }
                }
                if(check == true) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
