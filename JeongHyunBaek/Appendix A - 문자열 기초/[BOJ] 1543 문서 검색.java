import java.util.*;

class Main {
    public static String find(int start, String doc, String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = start; i < start + word.length(); i++) {
            sb.append(doc.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String doc = sc.nextLine();
        String word = sc.nextLine();
        int start = 0;
        int cnt = 0;

        while (doc.length() - start >= word.length()) {
            if (find(start, doc, word).equals(word)) {
                start += word.length();
                cnt++;
            } else {
                start += 1;
            }
        }
        System.out.println(cnt);
    }
}
