import java.util.*;

class Main {
    private static int INF = 987654321;
    private static int[][] city = {};
    private static int[][] next = {};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        city = new int[n + 1][n + 1];
        next = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                city[i][j] = INF;

                if (i == j) {
                    city[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            city[a][b] = Math.min(city[a][b], c);
            next[a][b] = b;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (city[i][k] + city[k][j] < city[i][j]) {
                        city[i][j] = Math.min(city[i][j], city[i][k] + city[k][j]);
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (city[i][j] == INF) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(city[i][j] + " ");
                }
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (city[i][j] == 0 || city[i][j] == INF) {
                    System.out.println(0);
                    continue;
                }

                List<Integer> path = new ArrayList<>();
                int start = i;

                while (start != j) {
                    path.add(start);
                    start = next[start][j];
                }
                path.add(j);

                System.out.print(path.size() + " ");

                for (int x : path) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
    }
}
