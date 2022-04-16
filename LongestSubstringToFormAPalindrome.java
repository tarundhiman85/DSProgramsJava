import java.util.HashMap;
import java.util.Map;

public class LongestSubstringToFormAPalindrome {
    public static void main(String[] args) {
        System.out.println(solve("aabe"));
    }

    private static int solve(String s) {
        HashMap<Integer, Integer> index = new HashMap<>();

        int answer = 0;

        int mask = 0;
        index.put(mask, -1);
        //for every character index i
        for (int i = 0; i < s.length(); i++) {
            //we will find the index of bitmap
            int temp = (int) s.charAt(i) - 'a';
            //we will toggle the index of bitmap
            mask ^= (1 << temp);

            if (index.containsKey(mask)) {
                answer = Math.max(answer, i - index.get(mask));
            } else {
                index.put(mask, i);
            }

            for (int j = 0; j < 26; j++) {
                int mask2 = mask ^ (1 << j);
                if (index.containsKey(mask2)) {
                    answer = Math.max(answer, i - index.get(mask2));
                }
            }
        }
        return answer;
    }

}
