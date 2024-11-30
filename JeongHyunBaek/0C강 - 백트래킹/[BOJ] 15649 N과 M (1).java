import java.util.*;

class Main {
    private static boolean visited[];

    public static void backtrack(int n, int m, int depth, StringBuilder sb) {
        if (depth == m) {
            System.out.println(sb);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(i).append(" ");
                backtrack(n, m, depth + 1, sb);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n + 1];

        backtrack(n, m, 0, new StringBuilder());
    }
}
