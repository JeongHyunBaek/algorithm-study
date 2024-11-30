package heebp.week1.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            q.add(i);
        }
        int res = 0;
        while(!q.isEmpty()){
            res = q.poll();
            if(!q.isEmpty())
                q.add(q.poll());
        }
        System.out.println(res);
    }
}
