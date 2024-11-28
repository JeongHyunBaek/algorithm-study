package heebp.week2.recursion;
import java.io.*;
import java.util.StringTokenizer;
public class QuadTree {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder result;
    static int depth_index;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        depth_index = n;
        StringTokenizer st;
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        result = new StringBuilder("");
        recur(0, n,0, n, arr, n);
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static void recur(int x_s, int x_e, int y_s, int y_e, int[][] arr, int depth) throws IOException {
        if(depth_index > depth){
            result.append("(");
            depth_index--;
        }
        int zero = 0;
        int one = 0;
        for(int i = x_s; i < x_e; i++){
            for(int j = y_s; j < y_e; j++){
                if(arr[i][j] == 0) {
                    zero++;
                }
                else {
                    one++;
                }
            }
        }
        int size = (int) Math.pow(x_e - x_s, 2);

        if(zero == size){
            result.append("0");
            return;
        }
        if(one == size){
            result.append("1");
            return;
        }
        int x_m = (x_e + x_s) / 2;
        int y_m = (y_e + y_s) / 2;
        recur(x_s, x_m, y_s, y_m, arr,depth - 1);
        recur(x_s, x_m, y_m, y_e, arr, depth - 1);
        recur(x_m, x_e, y_s, y_m, arr, depth - 1);
        recur(x_m, x_e, y_m, y_e, arr, depth - 1);
        if(depth_index++ < depth)
            result.append(")");
    }
}
