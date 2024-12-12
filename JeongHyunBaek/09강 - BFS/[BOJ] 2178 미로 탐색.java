import java.io.*;
import java.util.*;

class Main {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int N, M;
    private static int[][] graph = {};

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        graph[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int x = q[0];
            int y = q[1];
            int dis = q[2];

            if (x == N - 1 && y == M - 1) {
                return dis;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M && graph[nx][ny] == 1) {
                    graph[nx][ny] = 0;
                    queue.offer(new int[]{nx, ny, dis + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        N = n;
        M = m;
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.next();

            for (int j = 0; j < m; j++) {
                graph[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        System.out.println(bfs());
    }
}
