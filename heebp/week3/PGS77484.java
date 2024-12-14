package heebp.week3;

import java.util.Arrays;

public class PGS77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        answer = new int[2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int non_zero_index = 0;
        for (int num : lottos) {
            if  (num == 0)
                non_zero_index++;
            else
                break;
        }
        int cnt = 0;
        int i = non_zero_index;
        int j = 0;
        while (i != 6 && j != 6) {
            if (lottos[i] > win_nums[j])
                j++;
            else if( lottos[i] < win_nums[j])
                i++;
            else{
                cnt++;
                i++;
                j++;
            }
        }
        answer[0] = 7 - (cnt + non_zero_index) >= 7 ? 6 : 7 - (cnt + non_zero_index);
        answer[1] = 7 - cnt >= 7 ? 6 : 7 - cnt;
        return answer;
    }
}
