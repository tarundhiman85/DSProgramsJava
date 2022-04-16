import java.util.HashMap;
import java.util.Map;

public class DistinctPalindromicSubstring {
    public static void main(String[] args) {
      String str = "geek";
        System.out.println(solve(str.toCharArray(),str));
    }
    static int solve(char[] s, String str){
        Map<String, Boolean> m = new HashMap<>();
        int n = s.length;
        boolean[][] palindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j) palindrome[i][j]=true;
            }
        }
        for (int i = 0; i < n-1; i++) {
            if(s[i]==s[i+1]){
                palindrome[i][i+1]=true;
            }
        }
        for(int curr_len=3; curr_len<=n; curr_len++){
            for (int i = 0; i < n-curr_len+1; i++) {
                //n-curr_len+1 because we need all strings of that length
                int j=i+curr_len-1;
                //i just move forward the sliding window
                if(s[i]==s[j] && palindrome[i+1][j-1]){
                    //i+1 j-1 if we think then this is just a string in between i and j
                    palindrome[i][j]=true;
                }
            }
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(palindrome[i][j] && m.get(str.substring(i,j+1))==null){
                    //means we want that substring to be distinct
                    m.put(str.substring(i,j+1),true);
                    ans++;
                }
            }

        }
        return ans;
    }
}
