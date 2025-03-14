import java.util.*;
public class Main{
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static Node insert(Node root,int val){
        if(root == null){
            root =  new Node(val);
            return root;//forget to return the root
        }
        if(root.data > val){// carefull with <,> symboles..
            // left subtree
            root.left = insert(root.left,val);
        }else{
            // right subtree
            root.right = insert(root.right,val);

        }
        return root;

    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root,int key){//O(H)
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return search(root.left,key);// forget to return..
        }
        else{
           return  search(root.right,key);// forget to add return..
        }

    }

    public static Node delete(Node root,int val){
        if(root.data > val){
            root.left = delete(root.left,val);
        }
        else if(root.data < val){
            root.right = delete(root.right,val);
        }else{
           // leaf node
            if(root.left == null && root.right == null){
                return  null;
            }
            //sing child case..
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            // case 3 -- 2 children exists
            Node IS = findInorderSuccessor(root.right);//left most node in the right subtree;
            root.data  = IS.data;// stors is data in root data
            root.right = delete(root.right,IS.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root){
        // run a loop until the root.left becomes null and return the root;
        while(root.left != null){
            root = root.left;// didn't understood the logic of assigining here...
        }
        return root;
    }
    public static void printInRange(Node root,int k1,int k2){
        if(root == null){
            return;
        }
        if(k1 <= root.data && root.data <=k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.data + " ");
            printInRange(root.right,k1,k2);


        }else if(root.data > k2){
            printInRange(root.left,k1,k2);

        }else{
            printInRange(root.right,k1,k2);;
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i = 0;i < path.size();i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");


    }
    public static void printRoot2Leaf(Node root,ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);// forget to add data..
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRoot2Leaf(root.left, path);;
        printRoot2Leaf(root.right,path);;
        path.remove(path.size()-1); //forgot to remove data...
    }

    public static boolean isValiedBST(Node root,Node min,Node max){
        if(root == null){
            return true;
        }
        if(min!=null && root.data <= min.data){
            return false;

        }
        else if(max !=null && root.data >= max.data){
            return  false;
        }
        return isValiedBST(root.left,min,root) && isValiedBST(root.right,root,max);
    }
    public static Node mirrorBST(Node root) {
        if (root == null) {
            return null;
        }
        Node temp = root.right;
        root.right = root.left;
        root.left = temp;



        mirrorBST(root.left);
        mirrorBST(root.right);

    return root;
    }
    public static Node mirrorBTS2 (Node root){
        if(root == null){
            return null;
        }
        Node leftMirror = mirrorBTS2(root.left);
        Node rightMirror = mirrorBTS2(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

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
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        // loop for to add valuse in tree in the form of bst
        for(int i = 0;i < values.length;i++){
           root =  insert(root,values[i]);//forget the storage of value in root
        }
        //inOrder(root);
        System.out.println();
//
//        ArrayList<Integer> a = new ArrayList<>();
//
//        printInRange(root,5,11);
//       // printRoot2Leaf(root,a);
//        if(isValiedBST(root,null,null)){
//            System.out.println("vallied ");
//        }else{
//            System.out.println("unvallied");
//        }
        preOrder(root);
       root = mirrorBST(root);
        System.out.println();
        preOrder(root);

        System.out.println();

        preOrder(root);
        root = mirrorBTS2(root);
        System.out.println();
        preOrder(root);
    }
}
