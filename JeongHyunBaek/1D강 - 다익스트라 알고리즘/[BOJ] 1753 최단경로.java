import java.util.*;

class Edge implements Comparable<Edge> {
    private int node;
    private int cost;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    public int getNode() {
        return node;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}

class Main {
    private static int INF = Integer.MAX_VALUE;
    private static int[] costs = {};
    private static Map<Integer, List<Edge>> graph;

    public static void dijkstra(int K) {
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(K, 0));
        costs[K] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (costs[cur.getNode()] < cur.getCost()) {
                continue;
            }

            for (Edge next : graph.get(cur.getNode())) {
                int nextCost = costs[cur.getNode()] + next.getCost();

                if (nextCost < costs[next.getNode()]) {
                    costs[next.getNode()] = nextCost;
                    pq.add(new Edge(next.getNode(), nextCost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        int K = sc.nextInt();
        graph = new HashMap<>();

        for (int i = 1; i <= V; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Edge(v, w));
        }

        costs = new int[V + 1];
        Arrays.fill(costs, INF);
        dijkstra(K);

        for (int i = 1; i < costs.length; i++) {
            if (costs[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(costs[i]);
            }
        }
    }
}
