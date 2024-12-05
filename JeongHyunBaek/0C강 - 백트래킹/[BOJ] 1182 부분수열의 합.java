import java.util.*;

class Main {
    private static int result = 0;
    private static int[] arr = {};

    public static void backtrack(int n, int s, int depth, int total) {
        if (depth == n) {
            if (total == s) {
                result++;
            }
            return;
        }
        backtrack(n, s, depth + 1, total);
        backtrack(n, s, depth + 1, total + arr[depth]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        backtrack(n, s, 0, 0);

        if (s == 0) {
            result--;
        }
        System.out.println(result);
    }
}
