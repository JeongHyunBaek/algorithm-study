package heebp.week2.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PuyoPuyo {
    static int[] dx = new int[]{-1, 0, 0, 1};
    static int[] dy = new int[]{0, -1, 1, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int[][] map = new int[12][6];
        for (int i = 0; i < map.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;
        boolean isProgress;
        boolean[][] visited;
        List<int[]> destory = new ArrayList<>();
        while(true){
            isProgress = false;
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] == '.')
                        continue;

                    dfs(i, j, map, visited, destory);
                    if(isRemove(destory, map))
                        isProgress = true;
                    destory.clear();
                }
            }
            if(!isProgress)
                break;
            rebuild(map);
            cnt++;
        }
        System.out.println(cnt);
    }
    static void dfs(int i, int j, int[][] map, boolean[][] visited, List<int[]> destroy){
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && !visited[nx][ny]){
                if(map[i][j] != map[nx][ny])
                    continue;
                visited[nx][ny] = true;
                destroy.add(new int[]{nx, ny});
                dfs(nx, ny, map, visited, destroy);
            }
        }
    }

    static void rebuild(int[][] map) {
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (map[j][i] != '.')
                        continue;
                    if (map[k][i] != '.') {
                        map[j][i] = map[k][i];
                        map[k][i] = '.';
                        break;
                    }
                }
            }
        }
    }
    static boolean isRemove(List<int[]> destory, int[][] map){
        if(destory.size() < 4){
            return false;
        }
        for (int[] point : destory) {
            map[point[0]][point[1]] = '.';
        }
        return true;
    }
}
