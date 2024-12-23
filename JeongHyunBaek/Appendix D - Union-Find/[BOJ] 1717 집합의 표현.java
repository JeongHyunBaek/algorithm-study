import java.util.*;

class Main {
    private static int[] parent;

    public static int find(int x) {
        if (parent[x] < 0) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return false;
        }

        if (parent[b] < parent[a]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if (parent[a] == parent[b]) {
            parent[a]--;
        }
        parent[b] = a;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (x == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
