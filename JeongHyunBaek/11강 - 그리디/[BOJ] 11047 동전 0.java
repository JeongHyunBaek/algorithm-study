import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;

        for (int i = n - 1; i >= 0; i--) {
            while (arr[i] <= k) {
                k -= arr[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
