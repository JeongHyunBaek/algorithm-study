package heebp.week1.linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Keylogger {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            List<Character> list = new LinkedList<>();
            String s = br.readLine();
            char[] ca = s.toCharArray();
            int pos = 0;
            for (char c : ca) {
                if(c == '>'){
                    pos = pos >= list.size() ? pos : pos + 1;
                }else if(c == '<'){
                    pos = pos == 0 ? pos : pos - 1;
                }else if(c == '-'){
                    if(pos != 0)
                        list.remove(--pos);
                }else {
                    list.add(pos++, c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(char c : list){
                sb.append(c);
            }
            System.out.println(sb);
        }
        br.close();
    }
}
