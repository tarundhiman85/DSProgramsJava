import java.util.*;
import java.lang.*;
import java.io.*;
class shortquestions {
    private static void swap(int[] ai, int[] bi, int i, int i1) {
        int temp = ai[i];
        ai[i] = bi[i1];
        bi[i] = temp;
    }

    //    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int l=sc.nextInt();
//        int b=sc.nextInt();
//        int n=sc.nextInt();
//        int ans=0;
//        while(n-->0){
//            int Li=sc.nextInt();
//            int Bi=sc.nextInt();
//            ans+=Math.max((Li/l)*(Bi/b),(Li/b)*(Bi/l));
//        }
//        System.out.println(ans);
//    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            String s = sc.next();
            int n=s.length();
            int cnt = 0;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == 'x' && s.charAt(i - 1) == 'y' || s.charAt(i) == 'y' && s.charAt(i - 1) == 'x') {
                    cnt++;
                    i++;
                }
            }
            System.out.println(cnt);
        }

    }
}
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int t=sc.nextInt();
//        while(t-->0){
//            int n=sc.nextInt();
//            int m=sc.nextInt();
//            int[] Ai= new int[n];
//            int[] Bi= new int[m];
//            int sum1=0;
//            int sum2=0;
//            int swaps=0;
//            for(int i=0; i<n; i++) {
//                Ai[i] = sc.nextInt();
//                sum1+=Ai[i];
//            }
//            for(int i=0; i<m; i++){
//                Bi[i] = sc.nextInt();
//                sum2+=Bi[i];
//            }
//
//            Arrays.sort(Ai);
//            Arrays.sort(Bi);
//
//            if(sum1>sum2){
//                System.out.println(0);
//                continue;
//            }
//            else{
//                int j=m-1;
//                for(int i=0;i<n;i++){
//                    sum1=sum1-Ai[i];
//                    sum2=sum2-Bi[j];
//                    sum1=sum1+Bi[j];
//                    sum2=sum2+Ai[i];
//                    swaps++;
//                    j--;
//                    if(sum1>sum2 || j<0){
//                        break;
//                    }
//                }
//
//                if(sum1>sum2){
//                    System.out.println(swaps);
//                }
//                else{
//                    System.out.println(-1);
//                }
//            }
//
//        }
//    }}

