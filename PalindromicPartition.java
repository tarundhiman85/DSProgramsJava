public class PalindromicPartition {
    static int solve(String s){
        boolean[][] palindrome = new boolean[s.length()+1][s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if(i==j) palindrome[i][j]=true;
            }
        }
        for (int i = 0; i < s.length()-1; i++) {
                if(s.charAt(i)==s.charAt(i+1)){
                    palindrome[i][i+1]=true;
            }
        }
        for(int curr_len=3; curr_len<=s.length(); curr_len++){
            for (int i = 0; i < s.length()-curr_len+1; i++) {
                //s.length()-curr_len+1 because we need all strings of that length
                int j=i+curr_len-1;
                //i just move forward the sliding window
                if(s.charAt(i)==s.charAt(j) && palindrome[i+1][j-1]){
                    //i+1 j-1 if we think then this is just a string in between i and j
                    palindrome[i][j]=true;
                }
            }
        }
        int n=s.length();
        int[] cuts = new int[n];
        //each index of the cuts array store the minimum number of cuts
        //for that length of substring
        for (int i = 0; i < n; i++) {
            //for temp we are going to track minimum number of cut for that length
            int temp = Integer.MAX_VALUE;
            if(palindrome[0][i]){
                //first check if the substring of length i is a palindrome before splitting
                cuts[i]=0;
            }
            else{
                //start splitting the substring at each character
                for(int cut=0; cut<i; cut++){
                    //figure out minimum number of cuts for that substring
                    //from forward we are checking after cut index if a palindrome
                    if ((palindrome[cut+1][i])&& temp>cuts[cut]+1){
                        //like BA|N since N is a palindrome so we don't require cuts for it
                        //but we need to add 1 to the cut required to get n
                        //where we add one we add one to the just previous cut that is at B|A cut=1+1
                        temp = cuts[cut]+1;
                    }
                }
                cuts[i] = temp;
            }
        }
        return cuts[n-1];
    }
    public static void main(String[] args) {
        String s = "BANANA";
        System.out.println(solve(s));
    }
}
