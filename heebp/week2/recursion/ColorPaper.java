package heebp.week2.recursion;
import java.io.*;
import java.util.StringTokenizer;

public class ColorPaper {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int array[][];
    static int n;
    static int cntZero, cntOne;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        array = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0, n , 0, n);
        bw.write(cntZero + "\n");
        bw.write(cntOne + "\n");
        bw.flush();
        bw.close();
    }

    private static void recur(int x_start, int x_end, int y_start, int y_end) {
        int zero = 0;
        int one = 0;
        int elementCnt = (x_end - x_start) * (y_end - y_start);
        for (int i = x_start; i < x_end; i++) {
            for (int j = y_start; j < y_end; j++) {
                if (array[i][j] == 0) {
                    zero++;
                }else{
                    one++;
                }
            }
            if (zero == elementCnt ) {
                cntZero++;
                return;
            }
            if (one == elementCnt ) {
                cntOne++;
                return;
            }
        }

        int x_mid = x_start + (x_end - x_start) / 2;
        int y_mid = y_start + (y_end - y_start) / 2;
        recur(x_start, x_mid, y_start, y_mid);
        recur(x_start, x_mid , y_mid , y_end);
        recur(x_mid , x_end, y_start, y_mid);
        recur(x_mid, x_end, y_mid , y_end);

    }
}

