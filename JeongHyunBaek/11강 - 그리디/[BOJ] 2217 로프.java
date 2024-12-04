import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int maxValue = 0;

        for (int i = 1; i <= n; i++) {
            maxValue = Math.max(maxValue, arr[n - i] * i);
        }
        System.out.println(maxValue);
    }
}
