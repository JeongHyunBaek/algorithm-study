import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int s = 0;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cal = st.nextToken();

            if ("add".equals(cal)) {
                int x = Integer.parseInt(st.nextToken());

                s |= (1 << (x - 1));
            } else if ("remove".equals(cal)) {
                int x = Integer.parseInt(st.nextToken());

                s &= (~(1 << (x - 1)));
            } else if ("check".equals(cal)) {
                int x = Integer.parseInt(st.nextToken());

                sb.append(((s >> (x - 1)) & 1)).append("\n");
            } else if ("toggle".equals(cal)) {
                int x = Integer.parseInt(st.nextToken());

                s ^= (1 << (x - 1));
            } else if ("all".equals(cal)) {
                s = 0xfffff;
            } else {
                s = 0;
            }
        }
        System.out.print(sb);
    }
}
