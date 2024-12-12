import java.util.*;

class Main {
    private static int[] dx = {-1, 1, 2};
    private static boolean[] visited = new boolean[100001];

    public static int bfs(int n, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 0});
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int x = q[0];
            int dis = q[1];

            if (x == k) {
                return dis;
            }

            for (int i = 0; i < 3; i++) {
                int nx;

                if (i == 2) {
                    nx = x * dx[i];
                } else {
                    nx = x + dx[i];
                }

                if (0 <= nx && nx <= 100000 && !visited[nx]) {
                    visited[nx] = true;
                    queue.offer(new int[]{nx, dis + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int distance = bfs(n, k);

        System.out.println(distance);
    }
}
