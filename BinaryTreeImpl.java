import java.util.Scanner;

public class BinaryTreeImpl implements BinaryTree{

    @Override
    public BNode createTree(){

        BNode root = null;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the Data:");
        int data = sc.nextInt();
        if(data==-1) return null;

        root = new BNode(data);
        //left
        System.out.println("Enter left data for: "+data);
        root.left=createTree();

        //right
        System.out.println("Enter right data for: "+data);
        root.right=createTree();

        return root;
    }
    @Override
    public void inOrder(BNode root) {
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    @Override
    public void postOrder(BNode root) {
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");

    }

    @Override
    public void preOrder(BNode root) {
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    @Override
    public int heightTree(BNode root) {
        if(root==null)  return 0;
        else{
            //for every node we are counting
            return 1 + Math.max(heightTree(root.left),heightTree(root.right));
        }
    }

    @Override
    public int getLeafNodeSum(BNode root, int sum) {
        if(root==null) return 0;
        else if(root.left==null && root.right==null){
            sum+=root.data;
            return sum;
           /// return root.data;
        }
        else {
//            return getLeafNodeSum(root.right)+getLeafNodeSum(root.left);
           return getLeafNodeSum(root.left,sum)
            + getLeafNodeSum(root.right, sum);
        }
    }

    int max(int a, int b){
        return a>b?a:b;
    }
    static int mx=Integer.MIN_VALUE;

    @Override
    public int diameterTree(BNode root) {

        if (root==null) return 0;

        else{
            int leftHeight= heightTree(root.left);
            int rightHeight= heightTree(root.right);

            int leftDiameter = diameterTree(root.left);
            int rightDiameter = diameterTree(root.right);

            return max(leftHeight+rightHeight+1,max(leftDiameter, rightDiameter));
        }
    }

    @Override
    public void printExactlyOneChild(BNode root) {

    }

    @Override
    public void SpiralOrderTraversal(BNode root) {

    }

    @Override
    public boolean isMirror(BNode root1, BNode root2) {
        return false;
    }

    @Override
    public boolean isTreeBalanced(BNode root) {
        if(root==null){
            return true;
        }
        if(heightTree(root.left)+heightTree(root.right)<=1) return true;
        return false;
    }

    @Override
    public int sumOfAllNumber(BNode root) {
        if(root==null) return 0;
        else return root.data+sumOfAllNumber(root.left)+sumOfAllNumber(root.right);
    }

    @Override
    public int addEachleveltoFormAP(BNode root) {
        return 0;
    }


    static int mxi=0;
    static BNode maxN;
    static BNode  BigManager(BNode root, int sum, int count){
        if(root==null) return null;
       //for every node we are counting count and avg

        BNode b = BigManager(root.left, sum, count);
         b= BigManager(root.right, sum, count);
        if(b==null){
            return root;
        }
        count += 1;
        sum += root.data;
        if(sum/count>mxi){
            mxi = sum/count;
            maxN = root;
        }
        return b;
    }

    static int distinct=0;
    static int steps(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        int k = steps(n - 1);
        int w = steps(n - 2);
        int cp = k + w;
        return cp;
    }
    public static void main(String[] args) {
        System.out.println(steps(3));
//        BinaryTree binaryTree = new BinaryTreeImpl();
//        BNode bNode=null;
//        bNode=binaryTree.createTree();
////        binaryTree.inOrder(bNode);
////        System.out.println();
////        binaryTree.postOrder(bNode);
////        System.out.println();
////        binaryTree.preOrder(bNode);
////        System.out.println();
//
//        //int sum= binaryTree.getLeafNodeSum(bNode, 0);
////        int heightTree = binaryTree.heightTree(bNode);
////        System.out.println(heightTree);
////        int diameterTree = binaryTree.diameterTree(bNode);
////        System.out.println(diameterTree);
//        BigManager(bNode,0,0);
    }
}
class BNode{
    int data;
    BNode left;
    BNode right;
    BNode(int val){
        this.data=val;
    }
}