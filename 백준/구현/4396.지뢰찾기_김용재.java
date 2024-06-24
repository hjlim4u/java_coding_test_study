import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        char[][] arr1 = new char[n+2][n+2];
        char[][] arr2 = new char[n+2][n+2];
        char[][] res = new char[n+2][n+2];
        int[] dy = {1,1,0,-1,-1,-1,0,1};
        int[] dx = {0,1,1,1,0,-1,-1,-1};
        for(int i =0 ;i<n;i++) {
            String temp = in.nextLine();
            for(int j=0;j<n;j++) {
                arr1[i+1][j+1]= temp.charAt(j);
            }
        }
        for(int i =0 ;i<n;i++) {
            String temp = in.nextLine();
            for(int j=0;j<n;j++) {
                arr2[i+1][j+1]= temp.charAt(j);
            }
        }
        boolean ch = true;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(arr2[i][j]=='.') {
                    res[i][j]='.';
                }
                else {
                    if (arr1[i][j]=='*') {
                        ch = false;
                    }
                    else {
                        int cnt = 0;
                        for(int k=0;k<8;k++) {
                            int di = i + dy[k];
                            int dj = j + dx[k];
                            if(arr1[di][dj]=='*') cnt++;
                        }
                        res[i][j]= (char)(cnt+'0');
                    }
                }
            }
        }
        if (!ch) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    if(arr1[i][j]=='*') res[i][j]='*';
                }
            }
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                System.out.print(res[i][j]);
            }
            System.out.print("\n");
        }
    }
}
