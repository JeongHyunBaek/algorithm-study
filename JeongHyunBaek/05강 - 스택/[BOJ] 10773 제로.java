import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();

            if (x == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(x);
            }
        }

        int sum = 0;

        for (int s : stack) {
            sum += s;
        }
        System.out.println(sum);
    }
}
