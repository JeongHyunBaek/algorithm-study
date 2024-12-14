import java.util.*;

class Main {
    private static List<Integer>[] graph;
    private static int[] parent = {};

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        parent[v] = 0;

        while (!queue.isEmpty()) {
            int q = queue.poll();

            for (int x : graph[q]) {
                if (parent[x] == -1) {
                    queue.offer(x);
                    parent[x] = q;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        graph = new ArrayList[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
            parent[i] = -1;
        }

        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        bfs(1);

        for (int i = 2; i < n + 1; i++) {
            System.out.println(parent[i]);
        }
    }
}
