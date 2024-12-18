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
    private static int[] path = {};
    private static Map<Integer, List<Edge>> graph;

    public static void dijkstra(int start) {
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        costs[start] = 0;
        path[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (costs[cur.getNode()] < cur.getCost()) {
                continue;
            }

            for (Edge next : graph.get(cur.getNode())) {
                int nextCost = costs[cur.getNode()] + next.getCost();

                if (nextCost < costs[next.getNode()]) {
                    costs[next.getNode()] = nextCost;
                    path[next.getNode()] = cur.getNode();
                    pq.offer(new Edge(next.getNode(), nextCost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Edge(v, w));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        costs = new int[n + 1];
        path = new int[n + 1];
        Arrays.fill(costs, INF);
        dijkstra(start);

        System.out.println(costs[end]);

        List<Integer> list = new ArrayList<>();
        int current = end;

        while (current != 0) {
            list.add(current);
            current = path[current];
        }
        System.out.println(list.size());

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
