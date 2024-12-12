import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int x = -1;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();

            if ("push".equals(s)) {
                x = sc.nextInt();

                queue.offer(x);
            } else if ("pop".equals(s)) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                } else {
                    System.out.println(-1);
                }
            } else if ("size".equals(s)) {
                System.out.println(queue.size());
            } else if ("empty".equals(s)) {
                if (queue.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if ("front".equals(s)) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.peek());
                } else {
                    System.out.println(-1);
                }
            } else {
                if (!queue.isEmpty()) {
                    System.out.println(x);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
