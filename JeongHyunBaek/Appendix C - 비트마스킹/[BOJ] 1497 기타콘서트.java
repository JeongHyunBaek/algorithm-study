import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] s = new long[n];

        for (int i = 0; i < n; i++) {
            sc.next();
            String pos = sc.next();
            for (int j = 0; j < m; j++) {
                if (pos.charAt(j) == 'Y') {
                    s[i] |= (1L << j);
                }
            }
        }

        int[] ans = new int[2];
        ans[0] = 0;
        ans[1] = Integer.MAX_VALUE;

        for (int i = 1; i < (1 << n); i++) {
            long comb = 0;
            int guitarCount = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    comb |= s[j];
                    guitarCount++;
                }
            }

            int songCount = Long.bitCount(comb);

            if (songCount > ans[0]) {
                ans[0] = songCount;
                ans[1] = guitarCount;
            } else if (songCount == ans[0] && guitarCount < ans[1]) {
                ans[1] = guitarCount;
            }
        }

        if (ans[0] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans[1]);
        }
    }
}
