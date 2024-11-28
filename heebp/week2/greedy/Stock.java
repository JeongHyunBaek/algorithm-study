package heebp.week2.greedy;
import java.io.*;
import java.util.StringTokenizer;

public class Stock {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            long profit = 0;
            int max;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            max = -1;
            for (int j = N - 1; j >= 0; j--) {
                max = Math.max(arr[j], max);
                profit += max - arr[j];
            }
            bw.write(profit + "\n");
        }
        bw.flush();
        bw.close();
    }
}
