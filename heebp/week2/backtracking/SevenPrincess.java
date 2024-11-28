package heebp.week2.backtracking;

import java.io.*;

public class SevenPrincess {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = new int[]{-1,0,0,1};
    static int[] dy = new int[]{0,-1,1,0};
    public static void main(String[] args) throws IOException {
        char[][] map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++)
                map[i][j] = s.charAt(j);
        }
        int answer;

        answer = comb(0, 0, 0, new int[7], map);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int comb(int depth, int index, int YCnt, int[] pos, char[][] map) {
        if(YCnt > 3)
            return 0;
        if (depth == 7) {
            if (dfs(0, pos, new boolean[7], 1) == 7)
                return 1;
            return 0;
        }

        int cnt = 0;
        for (int i = index; i < 25; i++) {
            pos[depth] = i;
            if (map[i / 5][i % 5] == 'Y')
                cnt += comb(depth + 1, i + 1, YCnt + 1, pos, map);
            else
                cnt += comb(depth + 1, i + 1, YCnt, pos, map);
        }
        return cnt;
    }

    static int dfs(int cur, int[] pos, boolean[] visited, int depth){
        int x = pos[cur] / 5;
        int y = pos[cur] % 5;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int move = nx * 5 + ny;
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                for (int j = 1; j < 7; j++) {
                    if (visited[j] || move != pos[j])
                        continue;
                    visited[j] = true;
                    depth = dfs(j, pos, visited, depth + 1);
                }
            }
        }
        return depth;
    }
}
