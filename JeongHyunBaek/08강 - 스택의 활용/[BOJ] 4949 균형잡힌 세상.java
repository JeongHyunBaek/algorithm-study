import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String line;

        while (!(line = sc.nextLine()).equals(".")) {
            boolean isPair = true;
            Deque<Character> stack = new ArrayDeque<>();

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if ('(' == c || '[' == c) {
                    stack.push(c);
                } else if (')' == c) {
                    if (stack.isEmpty()) {
                        isPair = false;
                        break;
                    } else if ('(' == stack.peek()) {
                        stack.pop();
                    } else {
                        isPair = false;
                        break;
                    }
                } else if (']' == c) {
                    if (stack.isEmpty()) {
                        isPair = false;
                        break;
                    } else if ('[' == stack.peek()) {
                        stack.pop();
                    } else {
                        isPair = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isPair = false;
            }

            if (isPair) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
