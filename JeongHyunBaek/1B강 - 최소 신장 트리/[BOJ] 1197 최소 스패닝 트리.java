import java.util.*;

class Node implements Comparable<Node> {
    private int b;
    private int c;

    Node(int b, int c) {
        this.b = b;
        this.c = c;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    public int compareTo(Node o) {
        return this.c - o.c;
    }
}

class Main {
    private static List<Node>[] graph;
    private static boolean[] visited;
    private static int total;

    public static void prim() {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int b = node.getB();
            int c = node.getC();

            if (!visited[b]) {
                visited[b] = true;
                total += c;

                for (Node next : graph[b]) {
                    if (!visited[next.getB()]) {
                        pq.add(next);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        graph = new ArrayList[v + 1];
        visited = new boolean[v + 1];

        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        prim();

        System.out.println(total);
    }
}
