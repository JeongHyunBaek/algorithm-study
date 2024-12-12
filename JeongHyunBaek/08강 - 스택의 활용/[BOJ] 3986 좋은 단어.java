import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean isPair = true;
            Deque<Character> stack = new ArrayDeque<>();

            String ab = sc.next();

            for (int j = 0; j < ab.length(); j++) {
                char c = ab.charAt(j);

                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (('A' == stack.peek() && 'A' == c) || ('B' == stack.peek() && 'B' == c)) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }

            if (!stack.isEmpty()) {
                isPair = false;
            }

            if (isPair) {
                count++;
            }
        }
        System.out.println(count);
    }
}
