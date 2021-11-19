

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SegmentTree  {
     static int n=(int)2e5+2;
     static int []a = new int[n];
     static int []tree=new int[4*n];

     static void build(int node, int st, int en){
         if(st==en){
             tree[node]=a[st];
             return;
         }
         int mid=(st+en)/2;
         build(2*node,st,mid);  //build left child
         build(2*node+1,mid+1,en);  //build right child

         tree[node] = Math.min(tree[2*node], tree[2*node+1]);
     }
     //range minimum query
     static int query(int node, int st, int en, int l, int r){
         //when no overlap
         if(st>r || en<l){
             return Integer.MAX_VALUE;
         }
         //complete overlap
         if( l<=st && en<=r){
             return tree[node];
         }
         int mid = (st+en)/2;
         int q1=query(2*node, st,mid,l,r);
         int q2=query(2*node+1, mid+1, en,l,r);
         return Math.min(q1,q2);
     }

     static void update(int node, int st, int en, int idx, int val){
         if(st==en){
             a[st]=val;
             tree[node] = val;
             return;
         }
         int mid =(st+en)/2;
         if(idx<=mid){
             update(2*node, st, mid, idx, val);
         }
         else {
             update(2*node+1, st, mid, idx, val);
         }
         tree[node] = Math.min(tree[2*node], tree[2*node+1]);
     }
    public static void main(String[] args) throws IOException {
        int n,q;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        q=Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
              a[i]=Integer.parseInt(st1.nextToken());
        }
        build(1,0,n-1);
        while(q-->0){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
              int l=Integer.parseInt(st2.nextToken());
              int r=Integer.parseInt(st2.nextToken());
                int ans=query(1,0,n-1,l-1,r-1);
                System.out.println(ans);
        }


    }
}
