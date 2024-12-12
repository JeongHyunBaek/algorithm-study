import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long key = Long.parseLong(br.readLine());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int maxValue = Integer.MIN_VALUE;
        long maxKey = Long.MIN_VALUE;

        for (Long key : map.keySet()) {
            if (maxValue < map.get(key)) {
                maxValue = map.get(key);
                maxKey = key;
            }

            if (maxValue == map.get(key)) {
                maxKey = Math.min(maxKey, key);
            }
        }
        System.out.println(maxKey);
    }
}
