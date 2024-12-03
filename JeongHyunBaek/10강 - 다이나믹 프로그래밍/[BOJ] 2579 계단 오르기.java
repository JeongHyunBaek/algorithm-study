import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stairs = new int[n + 1];
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(stairs[1]);
        } else {
            dp[1][1] = stairs[1];
            dp[1][2] = 0;
            dp[2][1] = stairs[2];
            dp[2][2] = stairs[1] + stairs[2];

            for (int i = 3; i <= n; i++) {
                dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + stairs[i];
                dp[i][2] = dp[i - 1][1] + stairs[i];
            }
            System.out.println(Math.max(dp[n][1], dp[n][2]));
        }
    }
}
