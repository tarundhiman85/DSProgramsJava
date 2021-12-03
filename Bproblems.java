import java.awt.*;
import java.io.*;
import java.util.*;

public class Bproblems implements codeforces{

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
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

        public long nextLong() throws IOException
        {
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

        public double nextDouble() throws IOException
        {
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

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
    @Override
    public void AandBCompilationErrors(){
        Scanner sc  = new Scanner(System.in);
        int n =sc.nextInt();
        int a=0,b=0,c=0;
        for(int i=0; i<n; i++){
            a+=sc.nextInt();
        }
        for(int i=0; i<n-1; i++){
            b+=sc.nextInt();
        }
        for(int i=0; i<n-2; i++){
            c+=sc.nextInt();
        }
        System.out.println(a-b);
        System.out.println(b-c);
    }
    @Override
    public void llyaAndQueries() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        char[] c = s.toCharArray();
        int m = Integer.parseInt(br.readLine());

        int prefixSum[] = new int[c.length];
        int sum=0;
        for(int i=1; i<c.length; i++){
            if(c[i]==c[i-1]){
                prefixSum[i]=++sum;
            }
        }
        int l,r;
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            l=Integer.parseInt(st.nextToken());
            r=Integer.parseInt(st.nextToken());
            if(l!=1){
                System.out.println(prefixSum[r-1]-prefixSum[l-1]);
            }
          else{
                System.out.println(prefixSum[r-1]);
            }
        }
    }
    @Override
    public void fence(){
        Scanner sc  = new Scanner(System.in);
        int n =sc.nextInt();
        int k =sc.nextInt();

        int[] h = new int[n];

        for(int i=0; i<n; i++) {
            h[i] = sc.nextInt();
        }
        int sum = 0;
        for(int i=0; i<k; i++){
            sum+=h[i];
        }
        int min=sum;
        int idx=1;
        //for every segment we just calculate the sum
        //learning (n-k)
        for(int i=1; i<=(n-k); i++){
            //we will reduce the previous
            sum-=h[i-1];
            //we will introduce the new sum
            sum+=h[i+k-1];
            if(min>sum){
                min=sum;
                //we will update that index
                idx=i+1;
            }

        }
        System.out.println(idx);
    }

    @Override
    public int BersuBall(int arr[], int n){
        Set<Point> s = new HashSet<>();
        // Make all possible pairs
        int cnt=0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                s.add(new Point(arr[i], arr[j]));

            for(Point p : s){
                if(Math.abs(p.x-p.y)==0){
                    cnt++;
                }
            }
        // Return the size of the set
        return s.size()-cnt;
    }

    static void createTestCases(){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a = new int[n];
            for(int i=0; i<n; i++){
                a[i]=sc.nextInt();
            }
            Arrays.sort(a);
            for (Integer i: a){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean sortArray(){
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i]=scanner.nextInt();
        }
        int plusC=0;
        int minC=0;
        for(int i=1; i<n; i++){
            if(a[i]>=a[i-1]){
                plusC++;
            }
            else {
                minC++;
            }
        }
        if(Math.abs(plusC-minC)>0){
            return true;
        }
        return false;
    }

    @Override
    public int worms(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Point> p = new ArrayList<>();
        int n= scanner.nextInt();
        int[] a = new int[n];
        int prevX=0;
        int number=0;
        for(int i=0; i<n; i++){
            a[i]=scanner.nextInt();
            if(i==0){
                p.add(new Point(1,a[i]));
            }
            else{
                p.add(new Point(prevX, (prevX-1)+a[i]));
            }
            prevX=a[i]+1;
        }
        int m= scanner.nextInt();
        int[] b = new int[m];
        for(int i=0; i<m; i++){
            b[i]=scanner.nextInt();
        }
        int pileN=1;
        for(Integer i: b){
            for(Point j: p){
                if(i>=j.x && i<=j.y){
                    System.out.println(pileN);
                    break;
                }
            }
            pileN++;
        }
        return 1;
    }
    public static void main(String[] args) throws IOException {
//        codeforces cf = new Bproblems();
//       Reader r = new Reader();
//       int n =r.nextInt();
//       int[] a = new int[n];
//
//       for(int i=0; i<n; i++){
//           a[i]=r.nextInt();
//       }
//       int[] b = new int[n];
//       for(int i=0; i<n; i++){
//           b[i] = r.nextInt();
//       }
//       int[] arr = new int[a.length+b.length];
//       for(int i=0; i<a.length; i++){
//           arr[i] = a[i];
//       }
//       for(int i=0; i<b.length; i++){
//           arr[i] = b[i];
//       }
//
//        System.out.println(cf.BersuBall(arr,arr.length));
//        createTestCases();
        System.out.println(new Bproblems().worms());
    }
}
