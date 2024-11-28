package heebp.week2.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Coin {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M + 1];
            dp[0] = 1;
            for(int coin : arr){
                for (int j = 0; j < dp.length; j++) {
                    if(coin > j)
                        continue;
                    dp[j] += dp[j - coin];
                }
            }
            bw.write(dp[M]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
