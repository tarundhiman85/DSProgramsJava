import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class cses {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static void countDivisor() throws IOException {
//        Scanner sc =new Scanner(System.in);
        Reader sc = new Reader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 2; i * i <= n; i++) {
                //we will reduce it until we pop all factors of it
                if (n % i == 0) {
                    int power = 0;
                    while (n % i == 0) {
                        power++;
                        n /= i;
                    }
                    arr.add(power);
                }
            }
            if (n != 1) {
                //lets say its a prime number then we only add its power
                arr.add(1);
            }
            //now just compute the answers
            int numberOfDivisors = 1;
            for (Integer i : arr) {
                numberOfDivisors *= (i + 1);
            }
            System.out.println(numberOfDivisors);
        }
    }

    public void wordCombinations() throws IOException {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        long n = sc.nextLong();
        ArrayList<String> stringList = new ArrayList<>();
        long i = 0;
        while (i++ < n) {
            String patt = sc.next();
            stringList.add(patt);
        }
        long[] dp = new long[text.length() + 1];
        for(int j=0 ; j<=text.length(); j++){
            dp[j]=-1;
        }
        long ans = countWordCombi(stringList.get(stringList.size() - 1).length() - 1, text.length() - 1, text, stringList, dp);
        System.out.println(ans);
    }

    private long countWordCombi(int pattPtr, int textptr, String text, ArrayList<String> stringList, long[] dp) {
        if (textptr == 0) return 1;
        if (pattPtr < 0) return 0;
        if(dp[textptr]!=-1){
            return dp[textptr];
        }
        String word = stringList.get(pattPtr);  //get the last word
        for (int j = word.length() - 1; j >= 0; j--) {
            if (text.charAt(textptr) != word.charAt(j)) {
                if(dp[textptr]==-1) dp[textptr]=0;
                //we look for another pattern keeping the textptr same
                dp[textptr] += countWordCombi(pattPtr - 1, textptr, text, stringList, dp)%1000000007;
            } else {
                if(dp[textptr]==-1) dp[textptr]=0;
                //we decrement text ptr also because we are matched it
                dp[textptr] += countWordCombi(pattPtr, textptr - 1, text, stringList, dp)%1000000007;
            }
        }
        //if we came here this means whole word is matched
        dp[textptr] += countWordCombi(pattPtr - 1, textptr - 1, text, stringList, dp)%1000000007;
        return dp[textptr];
    }

    public static void main(String[] args) throws IOException {

        new cses().wordCombinations();
    }

}
