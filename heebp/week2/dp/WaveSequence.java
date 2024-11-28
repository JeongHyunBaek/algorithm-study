package heebp.week2.dp;
import java.io.*;

public class WaveSequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for (int i = 5; i < 101; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }
        int Tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < Tc; i++) {
            bw.write(dp[Integer.parseInt(br.readLine())]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
