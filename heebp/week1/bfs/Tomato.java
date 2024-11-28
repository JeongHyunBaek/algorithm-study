package heebp.week1.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
    static int[] dr = {-1,0,0,0,0,1};
    static int[] dc = {0,-1,0,0,1,0};
    static int[] dz = {0,0,-1,1,0,0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] box = new int[N][M][H];
        int rem = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[box.length][box[0].length][box[0][0].length];
        for(int k = 0; k < H; k++) {
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 0)
                        rem++;
                    if(box[i][j][k] == 1) {
                        visited[i][j][k] = true;
                        q.add(new int[] {i, j, k});
                    }

                }
            }
        }
        System.out.println(rem == 0 ? 0 : solve(box, q, rem, visited));
    }
    public static int solve(int[][][] box, Queue<int[]> q, int rem, boolean[][][] visited) {
        int day = 1;
        Queue<int[]> nq = new LinkedList<>();
        while(true) {
            int cnt = 0;
            q.addAll(nq);
            nq.clear();
            while(!q.isEmpty()) {
                int cur[] = q.poll();
                for(int i = 0; i < 6; i++) {
                    int nr = cur[0] + dr[i];
                    int nc = cur[1] + dc[i];
                    int nz = cur[2] + dz[i];
                    if(OOD(nr, nc, nz, box))
                        continue;
                    if(visited[nr][nc][nz])
                        continue;
                    visited[nr][nc][nz] = true;
                    cnt++;
                    nq.add(new int[] {nr, nc, nz});
                }
            }
            if(cnt == 0)
                return -1;
            rem -= cnt;
            if(rem <= 0)
                return day;
            day++;
        }
    }

    public static boolean OOD(int nr, int nc, int nz, int[][][] box) {
        if(nr < 0 || nc < 0 || nz < 0 || nr >= box.length || nc >= box[0].length || nz >= box[0][0].length)
            return true;
        if(box[nr][nc][nz] == 1 || box[nr][nc][nz] == -1)
            return true;
        return false;
    }
}
