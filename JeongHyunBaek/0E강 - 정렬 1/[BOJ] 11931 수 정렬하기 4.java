import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        list.sort(Collections.reverseOrder());

        for (int num : list) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}
