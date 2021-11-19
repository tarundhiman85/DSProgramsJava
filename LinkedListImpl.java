public class LinkedListImpl implements LinkedList{
    @Override
    public Node insertAtFirst(Node head, int data) {

        Node node = new Node();
        node.data= data;
        node.next = null;

        if(head==null){
            head=node;
            return head;
        }
        else{
            node.next=head;
            return node;
        }

    }

    @Override
    public Node deleteAtAny(Node head, int index) {
        if(head==null){
            System.out.println("Nothing to Delete");
            return head;
        }
        else if(index==0){
            head=head.next;
            return head;
        }
        else{
            Node n= head;
            Node n1=null;
            for(int i=0; i<index-1; i++){
                n=n.next;
            }
            n1=n.next;
            n.next=n1.next;
            n1=null;
            return head;
        }

    }

    @Override
    public void show(Node head) {
        if(head==null){
            System.out.println("Nothing to Print");
        }
        else{
            Node n = head;
            while(n.next!=null){
                System.out.print(n.data+"->");
                n=n.next;
            }
            System.out.println(n.data);
        }
    }

    @Override
    public Node insertAtLast(Node head,int data) {
        Node node = new Node();
        node.data= data;
        node.next = null;
        if(head==null){
            return insertAtFirst(head, data);
        }
        else{
            Node n = head;
            while(n.next!=null){
                System.out.println(n.data);
                n=n.next;
            }
            n.next=node;
            return head;
        }
    }

    static Node reverse(Node head){
        if(head.next == null) return head;
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

    static int getLengthofLL(Node n){
        int c=0;
        while(n!=null) {
            n = n.next;
            c++;
        }
        return c;
    }

    static Node getNewHeaditerateTillLimit(Node head, int limit){
        int initial = 0;
        Node head1 = head;
        while(head1!=null && ++initial<limit)
            head1=head1.next;
        return head1;
    }

    @Override
    public Node reverseBykNodes(Node head, int k)
    {
        //1->2->3 ->4->5
        //3->2->1[reverse] [save_link]->5->4
        //
        int len=getLengthofLL(head);

        if(len%k==0)
        {
            int ActLen = len/k;
            Node next = head;
            Node newHead = null;
            Node firstHead =  head;
            while(ActLen-->0)
            {

                //we will iterate every group  to find new head
                newHead = getNewHeaditerateTillLimit(next, k);

                //we will save the next node
                if(newHead.next!=null){
                    next = newHead.next;
                }

                //we will break the link
                newHead.next=null;

                //we will reverse the ll
                head = reverse(head);

                //we will join the first head with next
                firstHead.next = next;
                ActLen--;
            }
        }
        else{
            int ActLen = len/k;
            int leftLen =  (len-len/k);
            Node next = null;
            Node newHead = null;
            while(ActLen-->0)
            {
                //we will iterate every group  to find new head
                 newHead = getNewHeaditerateTillLimit(head, k);

                 //we will save the next node
                if(newHead.next!=null){
                     next = newHead.next;
                }

                //we will reverse the ll
                head = reverse(newHead);
                ActLen--;

            }

            while(leftLen-->0)
            {

            }
        }
        return head;
    }

    @Override
    public Node updateEachNode(Node head) {
        return null;
    }
    @Override
    public boolean detectLoop(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast.data==slow.data) {
                return true;
            }
         }
        return false;
        }

    Node first;
    Node second;

    static Node mergeSort(Node head)
    {
        if(head.next==null)
            return head;

        Node mid = findMid(head);
        Node midNext = mid.next;
        mid.next = null;

        Node a = mergeSort(head);
        Node b = mergeSort(midNext);


        Node result = mergeList(a,b);

        return result;


        // add your code here
    }

    static Node findMid(Node head)
    {
        if(head==null)
            return head;


        Node slow = head;
        Node fast = head;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node mergeList(Node head1, Node head2)
    {
        Node result = null;

        if(head1==null)
        {
            return head2;

        }
        if(head2==null)
        {
            return head1;
        }

        if(head1.data<=head2.data)
        {
            result = head1;
            result.next = mergeList(head1.next,head2);
        }
        else
        {
            result = head2;
            result.next = mergeList(head1,head2.next);
        }

        return result;
    }
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedListImpl();
        //create the object create a null node
        Node node = null;
        //then at each method you are gonna get the object that you are assigning anyways
        node=linkedList.insertAtFirst(node,5);
        node=linkedList.insertAtLast(node,4);
        node=linkedList.insertAtLast(node,3);
        node=linkedList.insertAtLast(node,2);
        node=linkedList.insertAtLast(node,1);

    }
}
class Node{
    int data;
    Node next;
}