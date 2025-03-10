import java.net.StandardSocketOptions;
import java.util.*;

import java.util.*;
public class Main{
     static class  Node{
        int data;
        Node left;
        Node right;
         Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
        public static void preorder(Node root){
            if(root == null){
                return;
            }

            System.out.println(root.data);
            preorder((root.left));
            preorder(root.right);
            return;
        }
        public static void inorder(Node root){
            if(root == null) return;

            inorder((root.left));
            System.out.print(root.data+ " ");
            inorder((root.right));

        }
        public static void postorder(Node root){
            if(root == null) return;

            postorder(root.left);
            postorder((root.right));
            System.out.print(root.data + " ");


        }
        //level order triversal
        public static void levelOrder(Node root){
            if(root == null) return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode ==null) {
                System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!= null){
                        q.add(currNode.right);
                    }
                }
            }
        }

    }
    public static int height(Node root){
         if(root == null){
             return 0;
         }
         int lh = height(root.left);
         int rh = height(root.right);
         return Math.max(lh,rh)+1;
    }
    public static int diameter2(Node root){//0(n^2);
         if(root == null){
             return 0;
         }
         int ldiam = diameter2(root.left);
         int rdiam = diameter2(root.right);
         int lh = height(root.left);
         int rh = height(root.right);
         int selfdiam = lh+rh+1;
         return Math.max(selfdiam,Math.max(ldiam,rdiam));
    }
    static class Info{
         int diam,ht;
         Info( int diam,int ht){
             this.diam = diam;
             this.ht = ht;

         }

    }
    public static Info diameter(Node root){//0(n)
         if(root == null){
             return new Info(0,0);// returns in the form form of class
         }
         Info leftInfo = diameter(root.left);
         Info rightInfo = diameter(root.right);

         int  diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
         int ht = Math.max(leftInfo.ht,rightInfo.ht)+1;
         return new Info(diam,ht);
    }
    public static boolean isIdentical(Node node,Node subRoot){
         // insted of searching for identical seachearing for non identical is easy...
        if(node == null && subRoot == null){
            return true;
        } else if (node == null||subRoot == null||node.data!=subRoot.data) {
            return false;
            
        }
        if(!isIdentical(node.left,subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right,subRoot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root,Node subRoot){
         if(root == null){
             return false;
         }
         if(root.data == subRoot.data){
             if(isIdentical(root,subRoot)){
                 return true;
             }
         }
//         boolean left = isSubtree(root.left,subRoot);
//         boolean right = isSubtree(root.right,subRoot); we can directly return them..

         // if any one of the above calls returns true return true..
        return   isSubtree(root.left,subRoot)|| isSubtree(root.right,subRoot);   //(left||right);
    }

    static class Infoo{
         Node node;
         int hd;

         public Infoo(Node node,int hd){
             this.node = node;
             this.hd = hd;
         }
    }
    public static void topView(Node root){
         //levek order triversal;
        Queue<Infoo> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        int min = 0;int max = 0;
        q.add(new Infoo(root,0));
        q.add(null);

        while(!q.isEmpty()){
            Infoo curr = q.remove();
            if(curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }
            else {
                if (!map.containsKey(curr.hd)) {// if return true;
                    map.put(curr.hd, curr.node);
                }
                if (curr.node.left != null) {
                    q.add(new Infoo(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Infoo(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }

        }
        for(int i = min;i <= max;i++){
            System.out.print(map.get(i).data + " ");

        }
        System.out.println();

    }

    public static void main(String args[]){
       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right =  new Node(7);

       Node subRoot = new Node(2);
       subRoot.left = new Node(4);
       subRoot.right = new Node(5);



//   System.out.println(isSubtree(root,subRoot));

topView(root);


    }
}
