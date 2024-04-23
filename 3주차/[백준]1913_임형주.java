import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[][] matrix = new String[n][n];
        int x = -1;
        int y = 0;
        int num = n*n;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int dir = 0;
        int m_x = 0;
        int m_y = 0;

        while (num > 0) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (0<=nx && nx<n && 0<=ny && ny<n && matrix[nx][ny] == null) {
                matrix[nx][ny] = String.valueOf(num);
                if (num == m) {
                    m_x = nx+1;
                    m_y = ny+1;
                }
                num--;
                x = nx;
                y = ny;
            } else {
                dir = (dir+1)%4;
            }
        }
        for(int j = 0; j < matrix.length; j++) {
            System.out.println(String.join(" ", matrix[j]));
        }
        System.out.print(m_x);
        System.out.print(" ");
        System.out.print(m_y);
    }
}
