import java.util.*;

class Main {
    public static int z(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = 1 << n - 1;

        if (r < half && c < half) {
            return z(n - 1, r, c);
        }

        if (r < half) {
            return half * half + z(n - 1, r, c - half);
        }

        if (c < half) {
            return 2 * half * half + z(n - 1, r - half, c);
        }
        return 3 * half * half + z(n - 1, r - half, c - half);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(z(n, r, c));
    }
}
