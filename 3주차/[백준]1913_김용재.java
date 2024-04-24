import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num = in.nextInt();
        int[][] arr = new int[n][n];
        int i = n/2;
        int j = n/2;
        int cnt = 1;
        int r = 0;
        int ry = 0;
        int rx = 0;
        int d = 0;
        arr[i][j]=cnt;
        if(cnt==num) {
            ry=i+1;
            rx=j+1;
        }
        cnt++;
        int flag=0;
        while(i!=0 || j!=0) {
            for(int p=0;p<2;p++) {
                for(int q=0;q<=r;q++) {
                    i=i+dy[d];
                    j=j+dx[d];
                    arr[i][j]=cnt;
                    if(cnt==num) {
                        ry=i+1;
                        rx=j+1;
                    }
                    cnt++;
                    if(i==0 && j==0) {
                        flag=1;
                        break;
                    }
                }
                if(flag==1)
                    break;
                d=(d+1)%4;
            }
            r++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int p=0;p<n;p++) {
            for(int q=0;q<n;q++) {
                bw.write(arr[p][q]+" ");
            }
            bw.write("\n");
        }
        bw.write(ry+" "+rx);
        bw.flush();
        bw.close();
    }
}
