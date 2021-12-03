import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class CFcontests {
    static int sumArray(long arr[], int n){
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=arr[i];
        }
        return sum;
    }
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
    static int maxIdxEven(int arr[], int n, boolean flag, int mx) {
        if (flag) {
            //we need 1st max
            int mxIdx = 0;
            int maxElement = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] != 1) {
                    if (arr[i] % 2 == 0) {
                        if (maxElement < arr[i]) {
                            maxElement = arr[i];
                            mxIdx = i;
                        }
                    }
                }
            }

            return mxIdx;
        } else {
            int mxIdx = -1;
            int maxElement = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] != 1) {
                    if (i != mx) {
                        if (arr[i] % 2 == 0) {
                            if (maxElement < arr[i] || maxElement % 2 == 1) {
                                maxElement = arr[i];
                                mxIdx = i;
                            }
                        } else {
//                            if (mxIdx == -1) {
                                //we have not seen previous even
                                if (maxElement < arr[i]) {
                                    maxElement = arr[i];
                                    mxIdx = i;
                                }
//                            }
                        }
                    }
                }
            }
                return mxIdx;

        }
    }
    static void divideAndMultiply() throws IOException {
        Reader sc =new Reader();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            for(int i=0; i<n; i++){
                arr[i]= sc.nextLong();
            }
            int twoCount=0;
            //take out 2's from it
            for(int i=0; i<n; i++){
                while(arr[i]%2==0) {
                    arr[i]/=2;
                    twoCount++;
                }
            }
            Arrays.sort(arr);
            //now put all two in last
            for(int i=0; i<twoCount; i++){
                arr[n-1]*=2;
            }
            System.out.println(sumArray(arr,arr.length));
        }
    }
    public static void main(String[] args) throws IOException {
        divideAndMultiply();
    }
}
