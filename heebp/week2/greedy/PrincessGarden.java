package heebp.week2.greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrincessGarden {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0])
                return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        System.out.println(solve(arr));
    }

    private static int solve(int[][] arr) {
        int idx = 0;
        int time = 301;
        int max = 0;
        int cnt = 0;
        boolean isExist;
        do{
            isExist = false;
            for (int i = idx; i < arr.length; i++) {
                if(arr[i][0] > time)
                    break;

                if (arr[i][1] > max) {
                    max = arr[i][1];
                    isExist = true;
                    idx = i + 1;
                }
            }
            if(isExist){
                cnt++;
                time = max;
            }
        }
        while(isExist && time < 1201);

        return time >= 1201 ? cnt : 0;
    }
}