/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static ArrayList<Long> recurr(ArrayList<Long> arr, long end){
        int an=0;
        if(end==1) return arr;
        int i;
        for( i=1; i<end; ){
            if(arr.get(i)-arr.get(i-1)==1){
                if(an!=0){
                    arr.set(an, arr.get(i)+arr.get(i-1));
                    arr.set((i),0L);
                    arr.set((i-1),0L);
                    an=i;
                }else {
                    arr.set(i - 1, arr.get(i) + arr.get(i - 1));
                    arr.set((i), 0L);
                    an = i;
                    //arr.remove(i);
                }
            }
            else if(arr.get(i-1)-arr.get(i)==1){
                if(an!=0){
                    arr.set(an, arr.get(i)+arr.get(i-1));
                    arr.set((i), 0L);
                    arr.set((i-1), 0L);
                    an=i;
                }
                else {
                    arr.set(i - 1, arr.get(i) + arr.get(i - 1));
                    arr.set((i), 0L);
                    an = i;
                }
            }
            else if(arr.get(i-1).equals(arr.get(i))){
                if(an!=0){
                    arr.set(an, arr.get(i)+arr.get(i-1));
                    arr.set((i), 0L);
                    arr.set((i-1), 0L);
                    an=i;
                }
                else {
                    arr.set(i - 1, arr.get(i) + arr.get(i - 1));
//                arr.remove(i);
                    arr.set((i), 0L);
                    an = i;
                }
            }
            else{
                return new ArrayList<>();
            }
            ++i;
            ++i;
        }

        return recurr(arr,i-2);
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        long t=sc.nextLong();
        while(t-->0){
            long n=sc.nextLong();
            ArrayList<Long> arr = new ArrayList<Long>();
            long k = (long) Math.pow(2, (double) n);
            for(long i=0; i<k; i++){
                arr.add(sc.nextLong());
            }
            Collections.sort(arr);
            if((recurr(arr,arr.size())).size()==0){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }
    }
}
class CodeChefNov{

        static void CHEAPFU() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        while (t-- > 0) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            int K = sc.nextInt();
            if(X + (A*K) < Y + (B*K)){
                System.out.println("PETROL");
            }
            else if (X + (A*K) > Y + (B*K)){
                System.out.println("DIESEL");
            }
            else{
                System.out.println("SAME PRICE");
            }
        }
    }
        static void EQUALCOIN(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
            while (t-- > 0) {
                int X = sc.nextInt();
                int Y = sc.nextInt();
                if((X%2==0 && Y%2==0)||(X==0 && Y%2==0)||(Y==0 && X%2==0))
                {
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
        static void MAKEPAL(){

            //explanation  pending after 5 pm 7
         //            3rd question
//
//            Ai is the number of occurnce of the ith character with naveej
//            A=[a1,a2,...,An]
//
//            make palindromic string
//                    n=3
//            let take a, b ,c
//            a-4
//            b-3
//            c-1
//
//            approach most occuring first
//            then next occuring
//            then next occuring
//            which is not initially not possible
//
//            then a_c _a_cc_a_ c_a
//
//            n=3
//            a,b,c,d
//            a-3
//            b-2
//            c-1
//
//            b a a c a b
//            not possible c destroys symmetry
//
//
//            a-4
//            b-3
//            c [1,3,5,7...]
//
//            a a c c c  bbb c c c a a
//
//                    n=4[even]
//            a=2
//            b=3
//            c=3
//            d=3
//
//                    [not posible if all are odd occurence]
//
//            a c ca c  a   ...
//
//[if any one is even and rest are odd then also not posible]  [similary we can say that for the symmetry n-2 elements has to be even in even case]   proof 1.1
//
//            if a-2
//
//            a  bbcccb  a
//
//            if n=2  [by proof 1.1 it is possible to creat a palindrome]
//
//            a-3
//            b-2
//
//            b aaa b
//
//            then check the proof on other elements
//
//                    n=5[odd]
//
//
//            a=2
//            b-3
//            c-5
//            d-4
//            e-2
//                    [ a dd e c b c b c b c [c]  e dd  a ]   [by proof it is proved because of extra c]
//
//
//            n=6
//            a-3
//            b-3
//            c-2
//            d-2
//            e-1
//            f-2            c  d f [a b a b b a] f d c   [by proof 1.1]
//
//            changing according to the proof
//
//            a-2
//            b-3
//            c-2 d-2 e-2 f-2
//            a c d e f bbb f e d c a   [by proof 1.1] we can make palindrome
//
//
//            lets check edge cases
//
//            n=1  always yes
//
//
//
//            n = 3
//            a-4
//            b-3
//            c-1
//            aa bcbb aa    [proof 1.1 not working here]
//            so has to do some tasks here
//
//            we need to somehow convert/combine the odd number to even number  the number of operations is the minimum number of operations needed
//                    convert
//            then check how many odd are there
//            here we have 2 odd and 1 even
//            how many evens we have 1 even as we know ODD+ODD == even so we can combine odd numbers then anser would be floor(2/2)
//            lets say we have 3 odd and 1 even so we have to find the operations so
//            we need to only consider upto 3/2 that is 1 pair that is minimum number of operation
//            lets say we have 4 odd and 2 even then 4/2 2 pairs are to be combined which is number of operations
//            if we have 1 odd then we not need to consider that case
//
//
//                    n=4
//            a b  c a
//            2/2=1
//
//
//            psuedo code
//            scan the array  also side by side odd numbers
//            get the len(array)
//            check if all the elments are even[oddcount==0] or[oddcount==1] n-1 then print 0
//  else print floor of [oddcount/2]

            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            int oddC=0;
            while (t-- > 0) {
                int N = sc.nextInt();
                if(N==1){
                    System.out.println(0);
                    continue;
                }
                int arr[]=new int[N];
                for (int i = 0; i < N; i++) {
                    arr[i]=sc.nextInt();
                    if(arr[i]%2==1) oddC++;
                    if(oddC%2==1) oddC-=1;
                }
                    System.out.println(oddC/2);
                }
            }

            //use buffered reader
//         first check if sorted while scanning also the same flag
//    create two counts ascending and descending
//        if at the last decending==n then return array
//        else if ascending==n then sort reverse then return
//            else
//    then sort it
//    find the [#mid]-1 th element place in middle
//                if n==odd
//    find mid elem
//    starting from left place in right side by decreasing
//    starting form right place in left side by increasing
//                if n==even
//    find ceil(mid) element
//    starting from left place in right side by decresing -1
//    starting from right place
//
//
//    then check for sort
//    5 7 2 1 2
//            1 2 2 5 7
//    find the n-1 largest 5 in case off odd length
//
//if even length  1 2 2 5 7 8 then find n-1
//
//
//    the exception of duplicate elements find test cases to handle them
//
//    think test cases
//   3 3 1 2

//    now find the [# mid]-1 largest elem that is 2
//    1 2 3 3
//    j   i
//    3 2 3 1
//    2 3 3 1
//    then 2 3 3 1 will be the answer
//             i
//    n=1 return that
//            n=2
//            [1,2]  this will alsways be strictly larger or strictly smaller
//
//    n=3
//            [3,1,2]  then [# mid] = 2 the find 1st largest that is 3
//    then 2 3 1
//
//            47 80 40 43 75 93 30
//    then [# mid] = 4 then 3rd largest 43
//            47 75 80 93 43 40 30  this is the correct
//
//    or 47 75 93 30 40 43 80  dont statisfy condition
//
//
//    now implement  it
//
//1 2 3 3
//
//    mid ele
//
//2 3 3 1
//
            static void reverse(int a[], int n)
            {
                int i, k, t;
                for (i = 0; i < n / 2; i++) {
                    t = a[i];
                    a[i] = a[n - i - 1];
                    a[n - i - 1] = t;
                }
            }

            static boolean checkForSame(int arr[], int n){
              for(int i=1; i<n; i++){
                 if(arr[i]==arr[i-1]) return true;
              }
              return false;
            }

    static void hillseq() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            2
//            7
//            30 40 43 47 75 80 93
//            4
//            1 2 3 4
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            if (n == 1) {
                System.out.println(Integer.parseInt( br.readLine()));
                continue;
            }

            int descending = 0, ascending = 0;
            String line = br.readLine();
            String[] str = line.trim().split("\\s+");
            int i;

            //scanning array part
            for (i = 1; i < n; i++) {
                if (i - 1 == 0) {
                    arr[i - 1] = Integer.parseInt(str[i - 1]);
                }
                arr[i] = Integer.parseInt(str[i]);
                if (arr[i] - arr[i - 1] > 0) {
                    //decreasing order
                    ascending++;
                }
                else if (arr[i - 1] - arr[i] > 0) {
                    //increasing order
                    descending++;
                }
            }

            //preconditions
            if (descending == n - 1) {
                //we know then it is descending return arr
                for (Integer k : arr) {
                    System.out.print(k + " ");
                }
                System.out.println();
                continue;

            } else if (ascending == n - 1) {
                //we know then it is ascending return arr
                reverse(arr, n);
                for (Integer k : arr) {
                    System.out.print(k + " ");
                }
                System.out.println();
            }
            else if(ascending==0 && descending==0){
                System.out.println(-1);
                continue;
            }

            //algo part
            else {
                int mid = n / 2;
                Arrays.sort(arr);
                if (n % 2 == 1) {
                    //find the mid element
                    int right = n - 1;

                    //starting from left place
                    for (int left = 0; left < mid; left++) {
                        int temp = arr[right];
                        arr[right--] = arr[left];
                        arr[left] = temp;
                    }
                    //93 80 75 47 43 40 30
                    Arrays.sort(arr, 0, mid);
                    // 75 80 93 47 43 40 30
                    //then check again for strictly ascending and descending (pending)
                    if(arr[mid]==arr[mid+1] && arr[0]!=arr[mid]){
                        int temp = arr[0];
                        arr[0] = arr[mid];
                        arr[mid] = temp;
                    }
                    if(checkForSame(arr,n)){
                        System.out.println(-1);
                        continue;
                    }
                    for (Integer k : arr) {
                        System.out.print(k + " ");
                    }
                    System.out.println();
                }
                else {
                    //find the just greater mid element
                    int right = mid + 1;

                    //we compare one less
                    for (int left = 0; left < (mid - 1); left++) {
                        int temp = arr[right];
                        arr[right--] = arr[left];
                        arr[left] = temp;
                    }
                    // 4 2 3 1
                    Arrays.sort(arr, 0, mid );
                    // 2 4 3 1
                    //now swap mid with first  why swap
//                    int temp = arr[mid];
//                    arr[mid] = arr[0];
//                    arr[0] = temp;


//                    if(checkForSame(arr,n)){
//                        System.out.println(-1);
//                        continue;
//                    }

                    for (Integer k : arr) {
                        System.out.print(k + " ");
                    }
                    System.out.println();
                    // 3 4 2 1
                }
            }
        }
    }

    static void hillseq2() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            Map<Long, Long> m  = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            long arr[] = new long[n];
            String line = br.readLine();
            String[] str = line.trim().split("\\s+");
            long mx=0;
            boolean flag=false;
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(str[i]);
                mx = Math.max(arr[i], mx);

                    if(m.containsKey(arr[i])){
                        m.put(arr[i],m.get(arr[i])+1);
                    }
                    else{
                        m.put(arr[i], 1L);
                    }
                    if(m.get(arr[i])>2){
                        System.out.println(-1);
                        flag=true;
                        break;
                    }
                }

            //largest element occurs more then 2 times
            if(m.get(mx)>1 && !flag){
                System.out.println(-1);
                continue;
            }
            else if(!flag){
                //sort left vector in increasing order
                //sort right vector in decreasing order
                //if any element occurs more then 2 times then
                //put the element in both vector
                ArrayList<Long> left = new ArrayList<>();
                ArrayList<Long> right = new ArrayList<>();

                Arrays.sort(arr);
                for(int i=0; i<n; i++){
                   if(m.get(arr[i])==2){
                       left.add(arr[i]);
                       right.add(arr[i]);
                       m.put(arr[i],m.get(arr[i])-2);
                   }
                   else if(m.get(arr[i])==1){
                       left.add(arr[i]);
                   }
                }
                ArrayList<Long> ne = new ArrayList<>();
                for(Long i: left){
                    ne.add(i);
                }
                for(Long i: right){
                    ne.add(i);
                }
                for(int i=ne.size()-1; i>=0; i--){
                    System.out.print(ne.get(i)+" ");
                }
                System.out.println();
            }


        }
        }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            hillseq();

        }
    }

