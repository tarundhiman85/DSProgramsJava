import java.util.Scanner;

public class LinkedListImpl implements LinkedList {

    @Override
    public Node insertAtFirst(Node head, int data) {

        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
            return head;
        } else {
            node.next = head;
            return node;
        }

    }

    @Override
    public Node deleteAtAny(Node head, int index) {
        if (head == null) {
            System.out.println("Nothing to Delete");
            return head;
        } else if (index == 0) {
            head = head.next;
            return head;
        } else {
            Node n = head;
            Node n1 = null;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            n1 = null;
            return head;
        }

    }

    @Override
    public void show(Node head) {
        if (head == null) {
            System.out.println("Nothing to Print");
        } else {
            Node n = head;
            while (n.next != null) {
                System.out.print(n.data + "->");
                n = n.next;
            }
            System.out.println(n.data);
        }
    }

    @Override
    public Node insertAtLast(Node head, int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            return insertAtFirst(head, data);
        } else {
            Node n = head;
            while (n.next != null) {
//                System.out.println(n.data);
                n = n.next;
            }
            n.next = node;
            return head;
        }
    }

    static Node reverse(Node head) {
        if (head.next == null) return head;
        int i = 0;
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    static int getLengthofLL(Node n) {
        int c = 0;
        while (n != null) {
            n = n.next;
            c++;
        }
        return c;
    }

    static Node getNewHeaditerateTillLimit(Node head, int limit) {
        int initial = 0;
        Node head1 = head;
        while (head1 != null && ++initial < limit)
            head1 = head1.next;
        return head1;
    }

    @Override
    public Node reverseBykNodes(Node head, int k) {
        //1->2->3 ->4->5
        //3->2->1[reverse] [save_link]->5->4
        //
        int len = getLengthofLL(head);

        if (len % k == 0) {
            int ActLen = len / k;
            Node next = head;
            Node newHead = null;
            Node firstHead = head;
            while (ActLen-- > 0) {

                //we will iterate every group  to find new head
                newHead = getNewHeaditerateTillLimit(next, k);

                //we will save the next node
                if (newHead.next != null) {
                    next = newHead.next;
                }

                //we will break the link
                newHead.next = null;

                //we will reverse the ll
                head = reverse(head);

                //we will join the first head with next
                firstHead.next = next;
                ActLen--;
            }
        } else {
            int ActLen = len / k;
            int leftLen = (len - len / k);
            Node next = null;
            Node newHead = null;
            while (ActLen-- > 0) {
                //we will iterate every group  to find new head
                newHead = getNewHeaditerateTillLimit(head, k);

                //we will save the next node
                if (newHead.next != null) {
                    next = newHead.next;
                }

                //we will reverse the ll
                head = reverse(newHead);
                ActLen--;

            }

            while (leftLen-- > 0) {

            }
        }
        return head;
    }

    @Override
    public Node updateEachNode(Node head) {
        return null;
    }

    @Override
    public boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.data == slow.data) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        // Node curr = head;
        Node slow = head;
        Node fast = head;
        Node prev = head;
        boolean f = true;
        while(fast!=null && fast.next!=null){
            if(f){
                slow=slow.next;
                fast=fast.next.next;
                f=false;
                continue;
            }
            prev=prev.next;
            slow=slow.next;
            fast=fast.next.next;

        }
        // Node slowN = slow.next;
        prev.next = slow.next;
        // System.out.println(prev.data);
        return head;
    }

    @Override
    public Node removeDuplicates(Node head){
        Node curr = head;
        while(curr.next!=null){
            if(curr.next.data == curr.data){
                //duplicate found
                if(curr.next.next!=null) curr.next = curr.next.next;
            }
            curr=curr.next;
        }
        return curr;
    }

    static Node mergeSort(Node head) {
        if (head.next == null)
            return head;

        Node mid = findMid(head);
        Node midNext = mid.next;
        mid.next = null;

        Node a = mergeSort(head);
        Node b = mergeSort(midNext);


        Node result = mergeList(a, b);

        return result;
        // add your code here
    }

    static Node findMid(Node head) {
        if (head == null)
            return head;


        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node mergeList(Node head1, Node head2) {
        Node result = null;

        if (head1 == null) {
            return head2;

        }
        if (head2 == null) {
            return head1;
        }

        if (head1.data <= head2.data) {
            result = head1;
            result.next = mergeList(head1.next, head2);
        } else {
            result = head2;
            result.next = mergeList(head1, head2.next);
        }

        return result;
    }

    @Override
    public boolean isPalindromeLL(Node head)
    {
        //Your code here
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node head2=slow.next;
        //break the link
        slow.next=null;

        if(head2==null) return true;
        head2=reverse(head2);

        Node ptr1=head;
        Node ptr2=head2;
        while(ptr1!=null && ptr2!=null){
            if(ptr1.data!=ptr2.data && ptr1!=ptr2) return false;
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return true;
    }

    @Override
    public  Node addOnetoLL(Node head) {

            //code here.
            head=reverse(head);
            Node curr=head;
            int carry=1;
            while(carry!=0)
            {
                //just add one and find the carry and propagate the carry
                curr.data+=1;
                if(curr.data<10) return reverse(head);
                else curr.data=0;
                if(curr.next==null) break;
                else curr=curr.next;
            }
            //if we go here then we just need to add one node 1 and return it
            curr.next=new Node();
            curr.next.data=1;
            return reverse(head);
        }

        @Override
        public int getBthFromLast(Node head, int n) {
            Node front = head;
            Node rear = head;
            int num = 0;
            while (front != null) {
                //simply traverse rear when num becomes greater then n
                if (++num > n) {
                    rear = rear.next;
                }
                front = front.next;
            }
            //if n is still greater then num then return -1
            if (n > num) {
                return -1;
            } else {
                return rear.data;
            }
        }

        @Override
        public Node rotate(Node head, int k) {
            // add code here
            if(head.next==null || k==0) return head;
            Node n = head;
            Node prev= head;
            boolean f = true;

            //checking if k == number of nodes
            Node curr=head;
            int cnt=0;
            while(curr.next!=null){
                curr=curr.next;
                cnt++;
            }
            if(cnt==k) {
                return head;
            }

            // else we take k+1 th node
            while(k-->0){
                if(f){
                    n=n.next;
                    f=false;
                    continue;
                }
                prev=prev.next;
                n=n.next;
            }
            //change links
            Node end=n;
            while(end.next!=null) end=end.next;
            end.next=head;
            prev.next=null;
            return n;
    }
    //Flat a LL
//    Node merge(Node a, Node b){
//
//        if(a==null) return b;
//        if(b==null) return a;
//
//        Node result;
//
//        if(a.data<b.data){
//            result = a;
//            result.bottom = merge(a.bottom,b);
//        }
//        else{
//            result = b;
//            result.bottom = merge(a,b.bottom);
//        }
//        result.next=null;
//        return result;
//    }
//    Node flatten(Node root){
//        if(root==null || root.next==null) return root;
//        else{
//            return merge(root,flatten(root.next));
//        }
//    }
    @Override
    public Node linkdeleteNnodeswithM(Node head, int m, int n)
    {
        if(head==null) return head;
        Node tmp=head;
        while(tmp!=null){
            int count=1;
            //we will go upto m
            while(tmp!=null && count<m){
                tmp=tmp.next;
                count++;
            }
            //if we reached the end then we break
            if(tmp==null) break;

            Node prev=tmp;
            tmp=tmp.next;
            int count1=0;

            //we will delete n nodes
            while(tmp!=null && count1<n){
                tmp=tmp.next;
                count1++;
            }
            //we will assign the previous node here
            prev.next=tmp;
        }
        return head;
    }



    public static void main(String[] args) {
        LinkedList linkedList = new LinkedListImpl();
        //create the object create a null node

        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            Node node = null;
            int n=sc.nextInt();
            int M=sc.nextInt();
            int N=sc.nextInt();
            for(int i=0; i<n; i++){
                int x=sc.nextInt();
                node= linkedList.insertAtLast(node,x);
            }
             node = linkedList.linkdeleteNnodeswithM(node, M, N);
            linkedList.show(node);
        }
//        System.out.println(linkedList.rotate(node,4));
//        linkedList.show(node);
    }
}
class Node{
    int data;
    Node next;
}