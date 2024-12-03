import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] r = new int[n + 1];
        int[] g = new int[n + 1];
        int[] b = new int[n + 1];
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            r[i] = sc.nextInt();
            g[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        dp[1][0] = r[1];
        dp[1][1] = g[1];
        dp[1][2] = b[1];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r[i];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g[i];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b[i];
        }
        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}
