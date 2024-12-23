import java.util.*;

class Main {
    public static String find(int start, int end, String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = start; i < end; i++) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }

    public static String strMulti(String str, int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();

        String[] alph = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int i = 0;
        int cnt = 0;

        while (i < 8) {
            if (word.contains(alph[i])) {
                if (word.indexOf(alph[i]) == 0) {
                    word = find(word.indexOf(alph[i]) + alph[i].length(), word.length(), word);
                } else {
                    word = find(0, word.indexOf(alph[i]), word) + strMulti(" ", alph[i].length()) + find(word.indexOf(alph[i]) + alph[i].length(), word.length(), word);
                }
                cnt++;
                i--;
            }
            i++;
        }
        word = word.replace(" ", "");
        System.out.println(cnt + word.length());
    }
}
