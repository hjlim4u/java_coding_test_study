import java.util.Scanner;

public class Maaain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int aNum = n;
        int aCnt = 0;
        int bNum = n;
        int bCnt = 0;
        int up=0;
        int down=0;
        int[] m = new int[14];
        for(int i = 0; i < 14; i++) {
            int temp = in.nextInt();
            m[i]=temp;
            aCnt = aCnt+ aNum/temp;
            aNum = aNum % temp;
            if(i>0) {
                if(m[i-1]<m[i]) {
                    up++;
                    down=0;
                }
                else if (m[i-1]==m[i]) {
                    up=0;
                    down=0;
                }
                else {
                    down++;
                    up=0;
                }
            }
            if(up>=3) {
                bNum = bNum + (bCnt * m[i]);
            }
            if(down>=3) {
                bCnt = bCnt + bNum/m[i];
                bNum = bNum%m[i];
            }
        }
        int a = aNum+ aCnt*m[13];
        int b = bNum+ bCnt*m[13];
        if(a==b)
            System.out.println("SAMESAME");
        else if (a>b)
            System.out.println("BNP");
        else if (a<b)
            System.out.println("TIMING");
    }
}
