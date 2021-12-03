import java.math.BigInteger;

public interface DP {

    int minOperation(int n);

    int lcs(char[] a, char[] b, int m, int n);

    int lCommSs(char[] a, char[] b, int m, int n);

    int minStepToDeleteString(String a);

    int rodCutting(int[] prices);
}
