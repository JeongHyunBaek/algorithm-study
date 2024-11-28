package heebp.week2.dp;
import java.io.*;
import java.util.*;

public class SequenceSum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + arr[i];
        }
        int answer = dp[1];
        for (int i = 2; i <= n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}

