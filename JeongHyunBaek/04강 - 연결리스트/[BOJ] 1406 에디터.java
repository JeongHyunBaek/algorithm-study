import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        int m = sc.nextInt();

        List<String> list = new LinkedList<>();

        for (int i = 0; i < n.length(); i++) {
            list.add(Character.toString(n.charAt(i)));
        }

        ListIterator<String> listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            listIterator.next();
        }

        for (int i = 0; i < m; i++) {
            String a = sc.next();

            if ("P".equals(a)) {
                String b = sc.next();
                listIterator.add(b);
            } else if ("L".equals(a)) {
                if (listIterator.hasPrevious()) {
                    listIterator.previous();
                }
            } else if ("D".equals(a)) {
                if (listIterator.hasNext()) {
                    listIterator.next();
                }
            } else {
                if (listIterator.hasPrevious()) {
                    listIterator.previous();
                    listIterator.remove();
                }
            }
        }
        System.out.println(String.join("", list));
    }
}
