import java.util.*;

class Main {
    private static int ROOT = 1;
    private static int unused = 2;
    private static int MX = 10000 * 500 + 5;
    private static boolean[] chk = new boolean[MX];
    private static int[][] nxt = new int[MX][26];

    public static int c2i(char c) {
        return c - 'a';
    }

    public static void insert(String s) {
        int cur = ROOT;

        for (char c : s.toCharArray()) {
            if (nxt[cur][c2i(c)] == -1) {
                nxt[cur][c2i(c)] = unused++;
            }
            cur = nxt[cur][c2i(c)];
        }
        chk[cur] = true;
    }

    public static boolean find(String s) {
        int cur = ROOT;

        for (char c : s.toCharArray()) {
            if (nxt[cur][c2i(c)] == -1) {
                return false;
            }
            cur = nxt[cur][c2i(c)];
        }
        return chk[cur];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < MX; i++) {
            Arrays.fill(nxt[i], -1);
        }

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            insert(s);
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            String s = sc.next();

            if (find(s)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
