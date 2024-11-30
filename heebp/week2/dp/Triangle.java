package heebp.week2.dp;
import java.io.*;
import java.util.StringTokenizer;

public class Triangle {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] dp = new int[501][501];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st =new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if(j == 0){
                    dp[i][j] += dp[i-1][j];
                } else{
                    dp[i][j] += Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[n][i],max);
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}
