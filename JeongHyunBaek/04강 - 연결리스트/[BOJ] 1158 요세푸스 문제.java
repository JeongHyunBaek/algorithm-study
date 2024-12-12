import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        sb.append("<");
        while (!list.isEmpty()) {
            for (int j = 0; j < k; j++) {
                if (j == k - 1) {
                    if (list.size() == 1) {
                        sb.append(list.remove(0));
                    } else {
                        sb.append(list.remove(0) + ", ");
                    }
                } else {
                    list.add(list.remove(0));
                }
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}
