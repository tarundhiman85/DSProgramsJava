public interface LinkedList {

    boolean isPalindromeLL(Node head);

    Node addOnetoLL(Node head);

    Node insertAtFirst(Node head, int data);

    Node deleteAtAny(Node head, int index);

    void show(Node head);

    Node insertAtLast(Node head, int data);

    //int multiplyBy4(Node head);

    Node reverseBykNodes(Node head,int k);

    Node updateEachNode(Node head);

    boolean detectLoop(Node head);

    Node deleteMid(Node head);

    Node removeDuplicates(Node head);

    int getBthFromLast(Node head, int n);

    Node rotate(Node head, int k);

    Node linkdeleteNnodeswithM(Node head, int m, int n);
}
