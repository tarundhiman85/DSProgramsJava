import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

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
        //last visit 19/11
        if(root==null)  return 0;
        else{
            //for every node we are counting and we are just taking the max
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
        //last visit 19/11
        if (root==null) return 0;

        else{
            //we will find the left height
            int leftHeight= heightTree(root.left);
            //we will find the right height
            int rightHeight= heightTree(root.right);

            //we will find the left diameter and right diameter
            int leftDiameter = diameterTree(root.left);
            int rightDiameter = diameterTree(root.right);
            //just check the max ont both diameter then with height
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
        //last visit 20/11
        if(root==null) return true;
        if(Math.abs(heightTree(root.left)-heightTree(root.right))<=1&&  isTreeBalanced(root.left)&& isTreeBalanced(root.right))
            return true;
        else
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

    @Override
    public boolean isIdenticalBTrees(BNode root1, BNode root2)
    {

        // Code Here last visit 19/17
        //if both roots are null then return true;
        if(root1==null && root2==null)
            return true;

            //if both are not null at the same time
        else if(root1==null || root2==null)
            return false;

        //if the root data is not same
        if(root1.data!=root2.data)
            return false;
        //then we check on left on both side and right on both side
        boolean c1=(isIdenticalBTrees(root1.left,root2.left));
        boolean c2=(isIdenticalBTrees(root1.right,root2.right));
        return (c1 && c2);
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

    @Override
    public void mirrorTree(BNode root) {
        // Your code here
        if(root==null) return;
        BNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
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

    @Override
    public  boolean isSymmetric(BNode root1, BNode root2){
        //we will check if both root are null or not las visit 20/11
        if(root1 == null && root2 == null)
            return true;
        //then we will check the main condition and recurse further
        if(root1 != null && root2 != null && root1.data == root2.data)
            return isSymmetric(root1.left,root2.right) && isSymmetric(root1.right,root2.left);
        return false;
    }

    @Override
    public boolean isBST(Node root) {
        return false;
    }

    BSTPair isBSTP(BNode root)
    {
        if(root==null){
            BSTPair bp = new BSTPair();
            bp.mn = Integer.MAX_VALUE;
            bp.mx = Integer.MIN_VALUE;
            bp.isBST = true;
            return bp;
        }
        BSTPair lp = isBSTP(root.left);
        BSTPair rp = isBSTP(root.right);

        BSTPair mp = new BSTPair();

        mp.isBST = lp.isBST && rp.isBST && (root.data>=lp.mx && root.data <=rp.mn);
        mp.mx = Math.min(root.data, Math.min(lp.mn, lp.mx));
        mp.mn = Math.max(root.data, Math.min(rp.mn, rp.mx));

        return mp;
    }

    @Override
    public boolean isBST(BNode root){
        BSTPair bp = isBSTP(root);
        return bp.isBST;
    }

    @Override
    public int isSumProperty(BNode node)
    {
          //last visit is 20/11
        /* left_data is left child data and right_data is for right
           child data*/

        int left_data = 0, right_data = 0;

        /* If node is NULL or it's a leaf node then
        return true */
        if (node == null || (node.left == null && node.right == null))
            return 1;
        else
        {
            /* If left child is not present then 0 is used
               as data of left child */
            if (node.left != null)
                left_data = node.left.data;

            /* If right child is not present then 0 is used
               as data of right child */
            if (node.right != null)
                right_data = node.right.data;

            /* if the node and both of its children satisfy the
               property return 1 else 0
               also we are checking if the if both the leaves exists or not then we continue
               */
            if ((node.data == left_data + right_data)
                    && (isSumProperty(node.left)!=0)
                    && isSumProperty(node.right)!=0)
                return 1;
            else
                return 0;
        }
    }

    @Override
    public ArrayList<Integer> largestValues(BNode root){
        //we will do level order traversal by creating a queue last visit 21
        //while q is not empty we will get the first item in the queue check its left right if node is not null
        //then add the max to the list also we need something which helps us in differentiating that is null

        ArrayList<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<BNode> q = new LinkedList();
        int max  = Integer.MIN_VALUE;
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            BNode temp = q.poll();
            if(temp!=null){
                max = max<temp.data?temp.data:max;
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            else{
                result.add(max);
                max = Integer.MIN_VALUE;
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
        }
        return result;
    }

    @Override
    public  void inOrderWithAdd(BNode root, ArrayList<BNode> a){
        if(root==null) return;
        inOrderWithAdd(root.left, a);
        a.add(root);
        inOrderWithAdd(root.right, a);
    }
    // returns the inorder successor of the Node x in BST (rooted at 'root')

    @Override
    public BNode inorderSuccessor(BNode root, BNode x)
    {
        //last visit 21/10
        //add code here.
        ArrayList<BNode> a = new ArrayList<>();
        inOrderWithAdd(root, a);
        for(int i =0 ; i<a.size()-1; i++)
        {
            if(a.get(i)==x)
                return a.get(i+1);
        }
        return null;
    }

    @Override
    public int kthLargest(BNode root,int K)
    {
        //Your code here last visit 21/11
//        ArrayList<Integer> a = new ArrayList<>();
//        inOrderWithAdd(root, a);
//        // System.out.println(a);
//        if(K>a.size()) return -1;
//        return a.get(a.size()-K);
return 0;
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

class BSTPair
{
    boolean isBST;
    int mn;
    int mx;
}
