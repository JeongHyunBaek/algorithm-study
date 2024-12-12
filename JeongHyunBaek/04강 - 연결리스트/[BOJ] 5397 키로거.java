import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            List<String> list = new LinkedList<>();
            ListIterator<String> listIterator = list.listIterator();

            String l = sc.next();

            for (int j = 0; j < l.length(); j++) {
                String s = Character.toString(l.charAt(j));

                if ("<".equals(s)) {
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                } else if (">".equals(s)) {
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    }
                } else if ("-".equals(s)) {
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                } else {
                    listIterator.add(s);
                }
            }
            System.out.println(String.join("", list));
        }
    }
}
