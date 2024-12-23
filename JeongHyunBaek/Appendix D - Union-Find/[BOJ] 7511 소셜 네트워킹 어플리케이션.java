import java.io.*;
import java.util.*;

class Main {
    private static int[] parent = {};

    public static int find(int x) {
        if (parent[x] < 0) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int u, int v) {
        u = find(u);
        v = find(v);

        if (u == v) {
            return false;
        }

        if (parent[v] < parent[u]) {
            int tmp = v;
            v = u;
            u = tmp;
        }

        if (parent[u] == parent[v]) {
            parent[u]--;
        }
        parent[v] = u;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= t; i++) {
            sb.append("Scenario ").append(i).append(":").append("\n");

            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());
            parent = new int[n + 1];
            Arrays.fill(parent, -1);

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            int m = Integer.parseInt(br.readLine());

            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                sb.append((find(u) == find(v)) ? 1 : 0).append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
