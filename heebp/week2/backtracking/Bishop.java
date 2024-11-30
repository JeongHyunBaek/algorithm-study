package heebp.week2.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Bishop {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] chess;
    static int max;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        chess = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0, 0, 0, true);
        int sum = max;
        max = 0;
        backtracking(0, 1, 0, false);
        sum += max;
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }

    private static void backtracking(int a, int b, int depth, boolean color)  {
        max = Math.max(depth, max);

        for (int i = a; i < chess.length; i++) {
            for (int j = b; j < chess.length; j += 2) {
                if (chess[i][j] != 1) {
                    continue;
                }
                if (chess[i][j] == 1) {
                    blockingRoute(i, j, 1);
                    backtracking(i, j + 2, depth + 1, color);
                    blockingRoute(i, j, -1);
                }
            }
            if (color) {
                if(i% 2 == 0)
                    b = 1;
                else{
                    b = 0;
                }
            }else{
                if(i% 2 == 0)
                    b = 0;
                else{
                    b = 1;
                }
            }
        }
    }

    private static void blockingRoute( int i, int j, int check) {
        chess[i][j] = chess[i][j] + check;
        for (int k = 1; k < chess.length; k++) {
            if (i + k < chess.length && j + k <chess.length) {
                if(chess[i+k][j+k] != 0)
                    chess[i + k][j + k] = chess[i + k][j + k] + check;
            }
            if (i + k < chess.length && j - k >=0) {
                if(chess[i+k][j-k] != 0)
                    chess[i + k][j - k] = chess[i + k][j - k] + check;
            }
        }
    }
}
