import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] list = line.split("-");
        int res = 0;
        for(int i=0;i<list.length;i++) {
            if (i==0) {
                String[] li = list[i].split("\\+");
                for(int j=0;j<li.length;j++) {
                    res = res + Integer.parseInt(li[j]);
                }
            }
            else {
                String[] li = list[i].split("\\+");
                for(int j=0;j<li.length;j++) {
                    res = res - Integer.parseInt(li[j]);
                }
            }
        }
        System.out.println(res);
    }
}
