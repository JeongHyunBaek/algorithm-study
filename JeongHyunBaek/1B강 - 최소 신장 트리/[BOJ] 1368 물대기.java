import java.util.*;

class Edge implements Comparable<Edge> {
    private int x;
    private int y;
    private int cost;

    Edge(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

class Main {
    private static int[] parent;

    public static void union(int x, int y) {
        int v1 = find(x);
        int v2 = find(y);

        if (v1 > v2) {
            parent[v1] = v2;
        } else {
            parent[v2] = v1;
        }
    }

    public static int find(int v) {
        if (parent[v] == v) {
            return v;
        } else {
            return find(parent[v]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] w = new int[n + 1];
        parent = new int[n + 1];
        Queue<Edge> pq = new PriorityQueue<>();
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int p = sc.nextInt();

                if (i == j) {
                    pq.add(new Edge(0, i, w[i]));
                }

                if (i < j) {
                    pq.add(new Edge(i, j, p));
                }
            }
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (find(edge.getX()) == find(edge.getY())) {
                continue;
            }

            union(edge.getX(), edge.getY());
            answer += edge.getCost();
        }
        System.out.println(answer);
    }
}
