import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int up=-1000000;
        int down=1000000;
        for(int i=0;i<n;i++) {
            int num = in.nextInt();
            if(num>up)
                up=num;
            if(num<down)
                down=num;
        }
        System.out.println(down+" "+up);
    }
}
