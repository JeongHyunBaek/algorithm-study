package heebp.week3;

public class PGS81301 {
    public int solution(String s) {
        int answer = 0;
        String[] temp = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i =0;i<10;i++){
            s = s.replace(temp[i],Integer.toString(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}
