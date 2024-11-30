package heebp.week2.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NM3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> list = new ArrayList();
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" "));
        int m = Integer.parseInt(st.nextToken());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i +  1;
        }
        backtracking(0,n, m, array);
        bw.flush();
        bw.close();
    }

    private static void backtracking(int depth, int n, int m, int[] array) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(list.get(i) + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            list.add(array[i]);
            backtracking( depth+1, n, m, array );
            list.remove(list.size() - 1);
        }
    }
}
