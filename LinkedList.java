public interface LinkedList {

    Node insertAtFirst(Node head, int data);

    Node deleteAtAny(Node head, int index);

    void show(Node head);

    Node insertAtLast(Node head, int data);

    //int multiplyBy4(Node head);

    Node reverseBykNodes(Node head,int k);

    Node updateEachNode(Node head);

    boolean detectLoop(Node head);
}
