import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class joshTech {

    public static void main(String[] args) {
        Question_1 question_1 = new Question_1();
        question_1.main(null);
    }

}
class Question_1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[]=new int[n];
        int x= Integer.MIN_VALUE;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            x= scanner.nextInt();
            if(x<-1){
                x*=(-1);
            }
            arrayList.add(x*x);
        }
        System.out.println();
        for(int i= arrayList.size()-1; i>=0; i--){
            System.out.print(arrayList.get(i)+" ");
            }
        }
    }
    class LinkLi{
        private int data;
        LinkLi next;
        LinkLi(){
            data=0;
            next=null;
        }
        LinkLi add_node(int val,LinkLi head){

            LinkLi linkLi =new LinkLi();
            linkLi.data=val;
            linkLi.next=head;
            head=linkLi;
            return  head;
        }
        void delete_node(int val, LinkLi head){
            LinkLi temp=null;
            if(head.data==val){
                head=head.next;
            }
            else{
                LinkLi current=null;
                while(current.next!=null){
                    if(current.next.data==val){
                        current.next=current.next.next;
                        break;
                    }
                    else{
                        current=current.next;
                    }
                }
            }
        }
        void check_next(LinkLi head){
            LinkLi current = head;
            while (current.next.next!=null){
                if(current.next.data == current.data){
                    current.next=current.next.next;
                }
                else {
                    current=current.next;
                }
            }
            if(current.next.data==current.data){
                current.next=null;
            }
        }
        void printList(LinkLi head){
            LinkLi current=head;
            while(current.next!=null){
                System.out.print(current.data+" ");
                current=current.next;
            }
            System.out.print(current.data);
        }
    }
    class Question_2 {
        public static void main(String[] args) {
        LinkLi li=new LinkLi();
        Scanner sc=new Scanner(System.in);
            System.out.println("Enter the Number of Nodes");
            LinkLi head = null;
            int n=sc.nextInt();
            for(int i=0; i<n; i++){
                int x=sc.nextInt();
                head=li.add_node(x,head);
            }
            li.check_next(head);
            li.printList(head);
        }
    }
class ListNode {
     int val;
     ListNode next;
      ListNode() {
      }
     ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
  }
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String sum1="";
        String sum2="";
        ListNode lil = new ListNode();
        lil=l1;
        // System.out.println("Print list of Values:");
        while(lil!=null){
            sum1+=lil.val;
            // System.out.println(sum1);
            lil=lil.next;
        }
        lil=l2;
        while(lil!=null)
        {
            sum2+=lil.val;
            lil=lil.next;
        }
        // System.out.println("sum1:"+sum1);
        // System.out.println("sum2:"+sum2);

        //getting the sum
        int val=Integer.parseInt(sum1);
        val=val+Integer.parseInt(sum2);
        String str = "" + val;

        int length=str.length()-1;

        // System.out.println("String is "+str);

        int i=0;
        ListNode ll = new ListNode();
        ListNode current = new ListNode();
        current = ll;

        while(length-->0){
            if(ll==null){
                System.out.println(i+" th item");
                ll.val=str.charAt(i++)-'0';
                System.out.println(" value:"+ll.val);
                ll.next=current;
            }
            else{
                // System.out.println(i+" th item Value to be Inserted:");
                // current.val=str.charAt(i++)-'0';
                // System.out.println(current.val);
                break;
                // ListNode curr = new ListNode();
                // current=current.next;
            }
        }
        return ll;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();

    }
}