import java.util.*;

class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void hanoi(int a, int b, int n) {
        if (n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }

        hanoi(a, 6 - a - b, n - 1);
        sb.append(a).append(" ").append(b).append("\n");
        hanoi(6 - a - b, b, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println((1 << n) - 1);
        hanoi(1, 3, n);
        System.out.println(sb);
    }
}
