import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String s = sc.next();

            boolean isPair = true;
            Deque<Character> stack = new ArrayDeque<>();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if ('(' == c) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        isPair = false;
                        break;
                    } else {
                        if (('(' == stack.peek() && ')' == c)) {
                            stack.pop();
                        } else {
                            isPair = false;
                            break;
                        }
                    }
                }
            }

            if (!stack.isEmpty()) {
                isPair = false;
            }

            if (isPair) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
