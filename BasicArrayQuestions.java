import java.util.*;

public class BasicArrayQuestions implements BasicArray{

    public ArrayList<Integer> recurr(ArrayList<Integer> arr, int end){
        int an=0;
        if(end==1) return arr;
        int i;
        for( i=1; i<end; ){
            if(arr.get(i)-arr.get(i-1)==1){
                if(an!=0){
                    arr.set(an, arr.get(i)+arr.get(i-1));
                    arr.set((i),0);
                    arr.set((i-1),0);
                    an=i;
                }else {
                    arr.set(i - 1, arr.get(i) + arr.get(i - 1));
                    arr.set((i), 0);
                    an = i;
                    //arr.remove(i);
                }
            }
            else if(arr.get(i-1)-arr.get(i)==1){
                if(an!=0){
                    arr.set(an, arr.get(i)+arr.get(i-1));
                    arr.set((i),0);
                    arr.set((i-1),0);
                    an=i;
                }
                else {
                    arr.set(i - 1, arr.get(i) + arr.get(i - 1));
                    arr.set((i), 0);
                    an = i;
                }
            }
            else if(arr.get(i-1).equals(arr.get(i))){
                if(an!=0){
                    arr.set(an, arr.get(i)+arr.get(i-1));
                    arr.set((i),0);
                    arr.set((i-1),0);
                    an=i;
                }
                else {
                    arr.set(i - 1, arr.get(i) + arr.get(i - 1));
//                arr.remove(i);
                    arr.set((i), 0);
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

    @Override
    public void largestLaddu(int n) {
        Map<Integer, Integer> m = new HashMap<>();
        int i = 0;
        Scanner sc = new Scanner(System.in);
        int k = (int) Math.pow(2, (double) n);
        int j = k;
        ArrayList<Integer> arr = new ArrayList<>();
        while (k-- > 0) {
            int x = sc.nextInt();
            arr.add(x);
//            if (m.containsKey(x)) {
//                m.put(x, m.get(x) + 1);
//            } else {
//                m.put(x, 1);
//            }
        }
        System.out.println(recurr(arr,arr.size()));
    }

//        int u=j;
//        //we need to use array approach is correct
//        for(int y=0; y<u; y+=2){
//            if(m.containsKey(arr[y]+1) && m.get(arr[y]+1)>0 && m.get(arr[y])>0){
//                j-=2;
//                m.put(arr[y]+1, m.get((arr[y]+1))-1);
//                m.put(arr[y], m.get(arr[y])-1);
//            }
//            else if(m.containsKey(arr[y]-1) && m.get(arr[y]-1)>0 && m.get(arr[y])>0){
//                //else check 2-1 = 1 exists or not
//                j-=2;
//                m.put(arr[y]-1, m.get(arr[y]-1)-1);  //we reduce the count of that ele
//                m.put(arr[y], m.get(arr[y])-1);   //we also reduce our count
//            }
//            else if(m.get(arr[y])>1)  //==0 case
//            {
//                //here we have created bond
//                j-=2;
//                m.put(arr[y],m.get(arr[y]-2));
//            }
//            else if(j<1) break;  //we dont need to iterate unnecessarily
//        }
//        if(j==0){
//            return true;
//        }
//        else{
//            return false;
//        }
//        for (Map.Entry<Integer,Integer> it : m.entrySet()) {
//            //if the value exists then its count must be greater then 0 then short circuit works
//            if(m.containsKey(it.getKey()+1) && m.get(it.getKey()+1)>0 && m.get(it.getKey())>0)
//            {    //show 2+1 = 3 exists or not
//                j-=2;   //states we have traversed 2 items
//                //we reduce the count
//                m.put(it.getKey()+1, m.get((it.getKey()+1))-1);
//                m.put(it.getKey(), m.get(it.getKey())-1);
//            }
//            else if(m.containsKey(it.getKey()-1) && m.get(it.getKey()-1)>0 && m.get(it.getKey())>0){
//                //else check 2-1 = 1 exists or not
//                j-=2;
//                m.put(it.getKey()-1, m.get(it.getKey()-1)-1);  //we reduce the count of that ele
//                m.put(it.getKey(), m.get(it.getKey())-1);   //we also reduce our count
//            }
//            else if(it.getValue()>1)  //==0 case
//            {
//                //here we have created bond
//                j-=2;
//                m.put(it.getKey(),it.getValue()-2);
//            }
//            else if(j<1) break;  //we dont need to iterate unnecessarily
//        }
//        return true;

    @Override
    public void segregateElements(int arr[], int n)
    {
        // Your code goes here
        //last visit 19/11
        ArrayList<Integer> a = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(arr[i]>=0) a.add(arr[i]);
        }
        for(int i=0; i<n; i++){
            if(arr[i]<0) a.add(arr[i]);
        }
        for(int i=0; i<n; i++){
            arr[i]=a.get(i);
        }
    }

    @Override
    public void sort012(int arr[], int n){
        // code here  last visit 17/11
        int low=0;
        int mid=0;
        int high=n-1;

        //we check two conditions
        while(mid<=high){
            //we just check middle conditions
            if(arr[mid]==0)
            {
                //if we get the middle element as 0 then we exchange it with low index
                int temp = arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                low++;
                mid++;
            }
            else if(arr[mid]==2){
                //then we exchange it with high index
                int temp = arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
            else{
                //means middle element will be 1
                //no need to worry
                mid++;
            }
        }
    }

    @Override
    public void BubbleSort(int arr[], int n){
         for(int i=0; i<n; i++){
             for(int j=1; j<(n-i); j++){
                 if(arr[j-1]>arr[j]){
                     int temp = arr[j-1];
                     arr[j-1] = arr[j];
                     arr[j] = temp;
                 }
             }
         }
    }

    @Override
    public void NapoleanCakeCF(int n, int arr[]){
        List<Integer> li = new ArrayList<Integer>();
        int i=0;
        while(n-->0){
            li.add(0);
            if(arr[i]>li.get(i)){
                int x = arr[i];  //3, 1, 3
                int j = i;    //4, 5
                int k= li.size();  //2, 5, 6
                while (k>0 && x>0){
                    li.set(j--,1);  //1, 0
                    x--;
                    k--;
                }
            }
            i++;  //1,2,3,4, 5
        }
        for (Integer p : li){
            System.out.print(p+" ");
        }
    }

    @Override
    public void reverseArray(int arr[], int n) {
        int start = 0;
        int end = n-1;
        while (start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    @Override
    public void reverseArrayWith(int arr[], int start, int end) {
        while (start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
//        for(int i=0; i<n; i++){
//            System.out.print(+arr[i]+" ");
//        }
//        System.out.println();
    }

    @Override
    public int kthMax(int arr[], int n, int k) {
        //last visit 17/11
        Arrays.sort(arr);
        reverseArray(arr,n);
        return arr[k-1];
    }

    @Override
    public int kthMin(int arr[], int n, int k) {
        //last visit 17/11
        Arrays.sort(arr);
        return arr[k-1];
    }

    @Override
    public void findCommonElementsWith3SortedArray(int arr[], int brr[], int crr[]) {
        int n1=arr.length;
        int n2=brr.length;
        int n3=crr.length;
        int p1=0,p2=0,p3=0;
        while(p1<n1 && p2<n2 && p3<n3){
            if((arr[p1]==brr[p2])&&(brr[p2]==crr[p3])){
                System.out.println(arr[p1]);
                p1++;
                p2++;
                p3++;
            }
            else if((arr[p1]>brr[p2])){
                p2++;
            }
            else if(brr[p2]>crr[p3]){
                p3++;
            }
            else{
                p1++;
            }
        }
    }


    @Override
    public void deleteAnElementInArray(int arr[], int n, int element) {
        int i;
        //find the element
        for( i=0; i<n; i++){
            if(arr[i]==element){
              break;
            }
        }
        //just place all the element
        for(int j=i; j<n-1; j++){
            arr[j]=arr[j+1];
        }
        //last element to 0
        arr[n-1]=0;
        for(int k=0; k< n; k++){
            System.out.print(arr[k]+" ");
        }
        System.out.println();
    }

    @Override
    public void findSecondSmallest(int arr[], int n) {

        int mx=0,scmx=0;
        for(Integer i : arr){
            //update the element based on greater then mx and also previous element
            if(i>mx){
                scmx=mx;
                mx=i;
            }
            //edge case update the second max if the i is less then mx and greater then scndmx
            else if(i<mx && i>scmx){
              scmx = i;
           }
        }
        System.out.println(mx+" "+scmx);
    }


    @Override
    public void twoSum(int arr[], int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i=0; i<n; i++) {
            Integer value = map.get(target-arr[i]);
            //if we dont get the value then we put this value in map with its index
            if(value==null){
                map.put(arr[i],i);
            }
            else{
                //else we sum the value with other value
                System.out.println(value+" "+i);
                break;
            }
        }
    }

    @Override
    public void RemoveDuplicates(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> a = new ArrayList<>(n);
        //just use simple hashmap with cameCase
        for(int i=0; i<n; i++){
            if((map.containsKey(arr[i]))){
                map.put(arr[i], map.get(arr[i])+1);

            }
            else{
                map.put(arr[i], 1);
                a.add(arr[i]);
            }
        }
        for(Integer i: a){
            System.out.print(i+" ");
        }
    }


    @Override
    public void FindMaxDifferenceBW2ArrayEle(int arr[]) {

        //sort the array then find the min element
        int minElem = arr[0];
        //find the first diff
        int maxDiff = arr[1]-arr[0];

        for(int i=1; i<arr.length; i++)
        //if for every element check if we remove min element then are we able to get max value
        {
            if(arr[i]-minElem>maxDiff){
                maxDiff = arr[i]-minElem;
            }
            //also update inCase the array is not sorted
            else if(arr[i]<minElem){
                minElem = arr[i];
            }
        }
        System.out.println(maxDiff);
        }

    @Override
    public void RotateElements(int arr[], int k){
        int i=0, j=k;
        int n=arr.length;

        k=k%n;   //just modulo that to get number
        //part 1 reverse till array k-1
        reverseArrayWith(arr,0,k-1);

        //part 2 reverse from k to n-1
        reverseArrayWith(arr, k ,n-1);

        //part 3  reverse whole array
        reverseArrayWith(arr,0,n-1);

        //print the whole array
        for(Integer u: arr){
            System.out.print(u+" ");
        }
    }

    @Override
    public void relativePrimePairsCF(long l, long r){
        long k=r-l+1;
        long d=k/2;
        if(k%2==0){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        for(long i=l+1; i<=r; i+=2){
            System.out.println((i-1)+" "+(i));
        }
    }

    static void printThreebyThree(char a[][], int start){
        //printing 3*3
        for(int i=start; i<(start+3); i++){
            for(int j=0; j<3; j++){
                if(i==start+1 && j==1) {
                    a[i][j]='Q';
                }
                else{
                    a[i][j]='.';
                }
            }
        }

    }

    @Override
    public void printQuenn(char a[][], int n, int start){
        if(n==3){
             printThreebyThree(a,start);
             return;
        }

        while(n!=0) {
            printQuenn(a, n - 1, start+1);
            if (n > 3) {
                //start-=2;
                int j;
                for (j = 0; j < n; j++) {
                    a[start][j] = '.';
                }
                a[start][--j] = 'Q';
                for (int row = start + 1; row < n; row++) {
                    a[row][j] = '.';
                }
            }
            return;
        }
    }

    @Override
    public  int peakElement(int arr[], int n){
        //so the basic approach is two pointers
        // Approached by me on [17/11]
        int start=0,end=n-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            //find the middle index
            if((mid==0||arr[mid-1]<=arr[mid])&&(mid==n-1||arr[mid+1]<=arr[mid])) {
                //if the middle-1 element is less then middle and also mid either on the last of array or mid is greater then middle+1
                return mid;
            }
            if(mid>0 && arr[mid-1]>=arr[mid])
            {
                //then we reduce the mid in order to get new mid
                end=mid-1;
            }
            else
            {
                //there are most probabily chances of getting the element apart from middle
                start=mid+1;
            }
        }
        return -1;
    }

    @Override
    public pair getMinMax(long a[], long n)
    {
        //Write your code here
        long mn=Long.MAX_VALUE;
        long mx=0;
        for(int i=0; i<n; i++){
            if(a[i]>mx){
                mx=a[i];
            }
            if(a[i]<mn){
                mn=a[i];
            }
        }
        return new pair(mn, mx);
    }

    @Override
    public void QuickSort(int[] arr, int low, int high) {
        //touched on 17/11
        if(low<high){
            int pIndex = partition(arr, low, high);
            QuickSort(arr, low, pIndex-1);
            QuickSort(arr, pIndex+1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pIndex=low;
        for(int i=low; i<high; i++){
            if(arr[i]<pivot){
                //learning part IMPORTANT
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex]= temp;
                pIndex++;
            }
        }
        int temp = arr[high];
        arr[high] = arr[pIndex];
        arr[pIndex] = temp;
        return pIndex;
    }

    @Override
    public int findFrequency(int A[], int x){
        //last visit 17/11
        Map<Integer, Integer> m = new HashMap<>();
        for(Integer i: A){
            if(m.containsKey(i)){
                m.put(i, m.get(i)+1);
            }
            else{
                m.put(i,1);
            }
        }
        if(m.containsKey(x)) return m.get(x);
        else return 0;
    }

    @Override
    public  void subArraySum(int[] arr, int s){
        // Your code here
        int n = arr.length;
        int low=0;
        int high=-1;
        //if sum is  greater then we increment the lowptr
        //if sum is smaller then we increment the highptr
        int sum=0;
        while(sum != s && (low < n) && (high < n)){
            if(sum<s && (high+1)<n){
                sum+=arr[++high];
            }
            else if(sum>s && (low+1)<n){
                sum-=arr[low++];
            }
            else{
                high++;
                low++;
            }
        }
        if(sum==s){
            System.out.println(low+1+" "+(high+1));
        }
        else{
            System.out.println(-1);
        }
    }

    @Override
    public int doUnionCount(int a[], int n, int b[], int m)  {
        //code here last visit 19/11
        //wer just put the elements in the set and return the set size
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<n; i++){
            s.add(a[i]);
        }
        for(int i=0; i<m; i++){
            s.add(b[i]);
        }
        return s.size();
    }

    public static void main(String[] args)
    {
        BasicArray basicArray = new BasicArrayQuestions();
//        int arr[] = {1,2,3,4,5,6,7};
//        int brr[] = {1,2,3,4};
//        int crr[] = {1,2};
        //int n = arr.length;
//       basicArray.deleteAnElementInArray(arr,n,3);
//        basicArray.RemoveDuplicates(arr,n);
//        basicArray.findSecondSmallest(arr,n);
//        basicArray.twoSum(arr,5);
//        basicArray.findCommonElementsWith3SortedArray(arr,brr,crr);
//        basicArray.FindMaxDifferenceBW2ArrayEle(arr);
//        basicArray.RotateElements(arr, 3);
//        int arr[] = {0,0,0
//        };
        //basicArray.relativePrimePairsCF(1,8);
//        basicArray.NapoleanCakeCF(arr.length,arr);
//        char[][] arr1 = new char[6][6];
//        for (char[] row : arr1) {
//            Arrays.fill(row, '.');
//        }
//        printThreebyThree(arr1,0);
//        basicArray.printQuenn(arr1, 6, 0);
//        for(int i=0; i<arr1.length; i++){
//            for(int j=0; j< arr1.length; j++){
//                System.out.print(arr1[i][j]+" ");
//            }
//            System.out.println();
//        }
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter n");
//        int n =sc.nextInt();
//        System.out.println("Enter Array Elements:");
//        basicArray.largestLaddu(n);
        int n=sc.nextInt();
        int sum=sc.nextInt();
        int a[] = new int[n];
        for (int i=0; i<n; i++){
            a[i]=sc.nextInt();
    }

//        basicArray.BubbleSort(a,a.length);
//        basicArray.QuickSort(a,0,a.length-1);
        basicArray.subArraySum(a,sum);
        for(Integer i: a){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

class pair
{
    //approached on 17/11
    long first, second;
    public pair(long first, long second)
    {
        this.first = first;
        this.second = second;
    }
}

class arraylevel2 implements ArrayIntermediate{
    @Override
    public int missingInteger(){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
//        int arrSum=Arrays.stream(arr).sum();
        int x1 = a[0];
        int x2 = 1;

        /* For xor of all the elements
           in array */
        for (int i = 1; i < n; i++)
            x1 = x1 ^ a[i];

        /* For xor of all the elements
           from 1 to n+1 */
        for (int i = 2; i <= n + 1; i++)
            x2 = x2 ^ i;

        return (x1 ^ x2);
    }
    public static void main(String[] args) {
        ArrayIntermediate a = new arraylevel2();
        a.missingInteger();
    }
}