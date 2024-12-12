import java.io.*;
import java.util.*;

class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int N, M;
    private static int maxDay = Integer.MIN_VALUE;
    private static int[][] graph = {};
    private static Queue<int[]> queue = new LinkedList<>();

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int x = q[0];
            int y = q[1];
            int day = q[2];

            maxDay = Math.max(maxDay, day);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && graph[nx][ny] == 0) {
                    graph[nx][ny] = 1;
                    queue.offer(new int[]{nx, ny, day + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        N = n;
        M = m;
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();

                if (graph[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        bfs();

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    count++;
                }
            }
        }

        if (count > 0) {
            System.out.println(-1);
        } else {
            System.out.println(maxDay);
        }
    }
}
