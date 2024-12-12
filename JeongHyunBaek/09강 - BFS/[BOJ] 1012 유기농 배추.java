import java.util.*;

class Main {
    private static int[][] graph = {};
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void bfs(int a, int b, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});

        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int x = q[0];
            int y = q[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < m && 0 <= ny && ny < n && graph[nx][ny] == 1) {
                    graph[nx][ny] = 0;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();

            graph = new int[m][n];

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                graph[x][y] = 1;
            }

            int count = 0;

            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if (graph[j][l] == 1) {
                        bfs(j, l, m, n);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
