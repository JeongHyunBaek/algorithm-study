import java.util.*;

class Main {
    public static int[] failure(String s) {
        int[] f = new int[s.length()];
        int j = 0;

        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = f[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                f[i] = ++j;
            }
        }
        return f;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String p = sc.next();

        int[] f = failure(p);
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = f[j - 1];
            }

            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }

            if (j == p.length()) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}
