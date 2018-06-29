package day6_21;

/*
  	   1.所有非叶子结点至多拥有两个儿子（Left和Right）；
       2.所有结点存储一个关键字；
       3.非叶子结点的左指针指向小于其关键字的子树，右指针指向大于其关键字的子树；
 */
class Node{
    int data;
    Node left = null, right = null;

    Node(int data) {
        this.data = data;
    }
}

public class A065{
    public static Node insert(Node root, int key){
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static boolean isBST(Node node, int minKey, int maxKey){
        if (node == null) {
            return true;
        }
        if (node.data < minKey || node.data > maxKey) {
            return false;
        }
        return isBST(node.left, minKey, node.data) &&
            isBST(node.right, node.data, maxKey);
    }
    // Function to determine if given Binary Tree is a BST or not
    public static void isBST(Node root){
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("该二叉树是BST");
        } else {
            System.out.println("该二叉树不是BST");
        }
    }

    private static void swap(Node root) {
        Node left = root.left;
        root.left = root.right;
        root.right = left;
    }
    
    public static void main(String[] args){
        Node root = null;
        int[] keys = {20,10,30,5,40};

        for (int key : keys) {
            root = insert(root, key);
        }
        // swap left and right nodes
        swap(root);
        isBST(root);
    }
}

