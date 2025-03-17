import java.util.*;

public class Main {
    // Definition of a Node in a Binary Search Tree (BST)
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    // Function to insert a value into the BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val); // Create a new node if root is null
        }
        if (root.data > val) {
            root.left = insert(root.left, val); // Insert into left subtree
        } else {
            root.right = insert(root.right, val); // Insert into right subtree
        }
        return root;
    }

    // Function to perform In-Order Traversal (Left, Root, Right)
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " "); // Print node data
        inOrder(root.right);
    }

    // Function to search for a value in the BST
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true; // Found the key
        }
        return root.data > key ? search(root.left, key) : search(root.right, key);
    }

    // Function to delete a node from BST
    public static Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.data > key) {
            root.left = delete(root.left, key); // Delete from left subtree
        } else if (root.data < key) {
            root.right = delete(root.right, key); // Delete from right subtree
        } else {
            // Case 1: Node has no child
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Node has one child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Node has two children
            Node IS = inOrderSuccessor(root.right); // Get in-order successor
            root.data = IS.data; // Replace node data with successor data
            root.right = delete(root.right, IS.data); // Delete successor
        }
        return root;
    }

    // Function to find the in-order successor (smallest node in right subtree)
    public static Node inOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Function to print nodes within a given range [k1, k2]
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (k1 <= root.data && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data > k2) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    // Function to print root-to-leaf paths
    public static void root2leaf(Node root, ArrayList<Node> path) {
        if (root == null) {
            return;
        }
        path.add(root);
        if (root.left == null && root.right == null) {
            printPath(path);
            path.remove(path.size() - 1);
            return;
        }
        root2leaf(root.left, path);
        root2leaf(root.right, path);
        path.remove(path.size() - 1);
    }

    // Helper function to print the path
    public static void printPath(ArrayList<Node> path) {
        for (Node node : path) {
            System.out.print(node.data + " ");
        }
        System.out.println();
    }

    // Function to mirror a tree (swap left and right subtrees)
    public static Node mirrorTree(Node root) {
        if (root == null) {
            return null;
        }
        Node temp = root.right;
        root.right = root.left;
        root.left = temp;
        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);
        return root;
    }

    // Function to check if a tree is a valid BST using min-max approach
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false; // Violates BST property
        }
        if (max != null && root.data >= max.data) {
            return false; // Violates BST property
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    // Main function to test the BST operations
    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        // Insert values into BST
        for (int val : values) {
            root = insert(root, val);
        }

        // Print In-Order Traversal
        System.out.print("In-Order Traversal: ");
        inOrder(root);
        System.out.println();

        // Check if the tree is a valid BST
        System.out.println("Is valid BST: " + isValidBST(root, null, null));
    }
}







import com.sun.jdi.ArrayReference;

import java.util.*;

public class Main {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

//    static class Info {
//        boolean isBST;
//        int size;
//        int min;
//        int max;
//
//        Info(boolean isBST, int size, int min, int max) {
//            {
//                this.isBST = isBST;
//                this.size = size;
//                this.min = min;
//                this.max = max;
//            }
//
//        }
//
//    }
//    public static int maxBST = 0;
//
//    public static Info largestBST(Node root) {
//        if (root == null) {
//            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
//        }
//        Info leftInfo = largestBST(root.left);
//        Info rightInfo = largestBST(root.right);
//        int size = leftInfo.size + rightInfo.size+1;
//        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
//        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
//
//        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
//            return new Info(false, size, min, max);
//        }
//        //checking for both the left and right nodes
//
//        if (leftInfo.isBST && rightInfo.isBST) {
//
//            maxBST = Math.max(maxBST, size);
//             return new Info(true, size, min, max);
//        }
//        return new Info(false,size,min,max);
//    }
//
//

    public static void inOrderSeq(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        inOrderSeq(root.left,inorder);
        inorder.add(root.data);
        inOrderSeq(root.right,inorder);

    }
    public static Node toBalancedTree(ArrayList<Integer> finalArr,int si,int ei){
        if(si > ei){
            return null;
        }
        int mid = si+(ei-si)/2;
        Node root = new Node(finalArr.get(mid));
        root.left = toBalancedTree(finalArr,si,mid-1);
        root.right = toBalancedTree(finalArr,mid+1,ei);
        return root;



    }

    public static Node MergBST(Node root1,Node root2){
        ArrayList<Integer> BST1 =  new ArrayList<>();
        ArrayList<Integer> BST2 =  new ArrayList<>();
        inOrderSeq(root1,BST1);
        inOrderSeq(root2,BST2);

        //code for merge;
        int i = 0; int j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i < BST1.size() && j < BST2.size()){
            if(BST1.get(i) <=BST2.get(j)){
                finalArr.add(BST1.get(i));
                i++;

            }else{
                finalArr.add(BST2.get(j));
                j++;
            }

        }
        while(i <BST1.size()){
            finalArr.add(BST1.get(i));
            i++;
        }
        while(j < BST2.size()){
            finalArr.add(BST2.get(j));
            j++;
        }

        //sorted ARRAY TO BALANCED TREE..
        Node root = toBalancedTree(finalArr,0,finalArr.size()-1);
        return root;




    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
    //        Node root = new Node(50);
    //        root.left = new Node(30);
    //        root.left.left = new Node(5);
    //        root.left.right = new Node(20);
    //
    //        root.right = new Node(60);
    //        root.right.left = new Node(45);
    //        root.right.right = new Node(70);
    //        root.right.right.left = new Node(65);
    //        root.right.right.right = new Node(80);
    //
    //        Info info = largestBST(root);
    //        System.out.println("largest bst = " + maxBST);

            Node root1 = new Node(2);
            root1.left = new Node(1);
            root1.right = new Node(4);

            Node root2 = new Node(9);
            root2.left = new Node(3);
            root2.right = new Node(12);

          Node root =   MergBST(root1,root2);
          preOrder(root);

          // O(n+m)... linear time complixity..
    }

}



