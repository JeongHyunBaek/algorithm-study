package heebp.week2.simulation;
import java.io.*;
import java.util.*;

public class Dice {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] diceK = {{0, 2, 0}, {4, 1, 3}, {0, 5, 0}};
    static int opposite = 6;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> diceV = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            diceV.put(i,0);
        }
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int operation;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            operation = Integer.parseInt(st.nextToken());
            if (x + dx[operation - 1] < N && y + dy[operation - 1] < M && x + dx[operation - 1] >= 0 && y + dy[operation - 1] >= 0) {
                x += dx[operation - 1];
                y += dy[operation - 1];
                diceMove(operation);
                if (map[x][y] == 0) {
                    map[x][y] = diceV.get(opposite);
                } else {
                    diceV.put(opposite, map[x][y]);
                    map[x][y] = 0;
                }
                bw.write(diceV.get(diceK[1][1])+"\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static void diceMove(int move) {
        int temp;
        temp = opposite;
        if (move == 1) {
            opposite = diceK[1][2];
            diceK[1][2] = diceK[1][1];
            diceK[1][1] = diceK[1][0];
            diceK[1][0] = temp;
        } else if (move == 2) {
            opposite = diceK[1][0];
            diceK[1][0] = diceK[1][1];
            diceK[1][1] = diceK[1][2];
            diceK[1][2] = temp;
        } else if (move == 3) {
            opposite = diceK[0][1];
            diceK[0][1] = diceK[1][1];
            diceK[1][1] = diceK[2][1];
            diceK[2][1] = temp;
        } else {
            opposite = diceK[2][1];
            diceK[2][1] = diceK[1][1];
            diceK[1][1] = diceK[0][1];
            diceK[0][1] = temp;
        }
    }
}