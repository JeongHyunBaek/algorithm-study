import java.util.*;

class Main {
    private static int result = 0;

    public static boolean check(int row, int[] graph) {
        for (int col = 0; col < row; col++) {
            if (graph[row] == graph[col]) {
                return false;
            }

            if (Math.abs(row - col) == Math.abs(graph[row] - graph[col])) {
                return false;
            }
        }
        return true;
    }

    public static void backtrack(int depth, int[] graph) {
        if (depth == graph.length) {
            result++;
            return;
        }

        for (int i = 0; i < graph.length; i++) {
            graph[depth] = i;

            if (check(depth, graph)) {
                backtrack(depth + 1, graph);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] graph = new int[n];

        backtrack(0, graph);

        System.out.println(result);
    }
}
