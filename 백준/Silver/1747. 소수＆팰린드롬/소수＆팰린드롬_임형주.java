import java.util.*;

public class Main{
    public static boolean isPalindrome(int val) {
        String strNum = String.valueOf(val);
        int left = 0;
        int right = strNum.length()-1;
        while (left < right) {
            if(strNum.charAt(left) != strNum.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
    
    public static boolean isPrime(int val) {
        if (val == 1) {return false;}
        for (int d = 2; d <=(int)Math.sqrt(val); d++) {
            if (val % d == 0) {
                return false;
            }
        }
        return true;
    }
    
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n;
        n = sc.nextInt();
        int answer = n;
		

        while (!isPalindrome(answer) || !isPrime(answer)) {
            answer += 1;
        }
        System.out.println(answer);
	}
}
