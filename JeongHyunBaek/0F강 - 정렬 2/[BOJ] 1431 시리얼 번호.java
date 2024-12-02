import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    int sum1 = 0;
                    int sum2 = 0;

                    for (int i = 0; i < o1.length(); i++) {
                        if ('0' <= o1.charAt(i) && o1.charAt(i) <= '9') {
                            sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
                        }
                    }

                    for (int i = 0; i < o2.length(); i++) {
                        if ('0' <= o2.charAt(i) && o2.charAt(i) <= '9') {
                            sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                        }
                    }

                    if (sum1 == sum2) {
                        return o1.compareTo(o2);
                    } else {
                        return sum1 - sum2;
                    }
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
