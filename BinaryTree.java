import java.util.ArrayList;

public interface BinaryTree {

    BNode createTree();

    void inOrder(BNode root);

    void postOrder(BNode root);

    void preOrder(BNode root);

    int heightTree(BNode root);

    int getLeafNodeSum(BNode root, int sum);

    int diameterTree(BNode root);

    void printExactlyOneChild(BNode root);

    void SpiralOrderTraversal(BNode root);

    boolean isMirror(BNode root1, BNode root2);

    boolean isTreeBalanced(BNode root);

    int sumOfAllNumber(BNode root);

    int addEachleveltoFormAP(BNode root);

    boolean isIdenticalBTrees(BNode root1, BNode root2);

    void mirrorTree(BNode root);

     boolean isSymmetric(BNode root1, BNode root2);

    boolean isBST(Node root);

    boolean isBST(BNode root);

    int isSumProperty(BNode node);

    ArrayList<Integer> largestValues(BNode root);

    void inOrderWithAdd(BNode root, ArrayList<BNode> a);

    BNode inorderSuccessor(BNode root, BNode x);

    int kthLargest(BNode root, int K);
}
