
public class test {
    public static void main(String[] args) {
        System.out.println(reverse(12345,10000));
    }
    static int temp;
    static int reverse(int n,int t){
        if(n==0){
            return 0;
        }
        return (n%10)*t+reverse(n/10,t/10);
    }
    static boolean palindrome(int n){
        return n==reverse(n,100);
    }
    static int countSteps(int n){
        int c=0;
        return helper(n,c);
    }
    static int helper(int n,int c){
        if(n==0) return 0;
        if((n%2)==0){
            return helper(n/2,c+1);
        }
        else{
            return helper(n-1,c+1);
        }
    }
}
