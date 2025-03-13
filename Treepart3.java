

import javax.xml.crypto.dsig.Transform;
import java.util.*;
public class Main{
    // creating a node class to create nodes of the binary tree..
    static class Node{
        int data ;
        Node left;
        Node right;

        // creating constructor of the Node class to store the data and the address of the left and right nodes..
        public Node(int data){// it gets the paramenter as data
            this.data = data;
            this.left = null;
            this.right = null;

        }
    }
    // creating a Binary class of  BinaryTree to create a BinaryTree
    public static  class BinaryTree {
        static int idx = -1;

        public Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

      // level order triversal..
        public static void levelOrder(Node root){
            if(root == null){
                return ;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+ " ");
                    if(currNode.left!= null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        // code to count the number of nodes in the tree;
        public static int count(Node root){
            if(root == null){
                return 0;
            }
             int lc = count(root.left);
            int rc = count(root.right);
            return  lc+rc+1;
        }
        public static int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }
            int lsum = sumOfNodes(root.left);
            int rsum = sumOfNodes(root.right);

            return  lsum+rsum+root.data;
        }
      // bruteForce approach


    }

    public static boolean isIdentical(Node node,Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }
        // checking non identical conditions
       else if(node == null || subRoot == null||node.data != subRoot.data){
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
        if(root.data ==subRoot.data){
            if(isIdentical(root,subRoot))
                return true;
        }


        return isSubtree(root.left ,subRoot)||isSubtree( root.right, subRoot);
    }
    static class Info{
        Node node;
        int hd;
        public Info(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
       int min = 0,max =0;
       q.add(new Info(root,0));
       q.add(null);
       while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
            }


       }
       for(int i = min;i <= max;i++){
           System.out.println(map.get(i).data);
       }

    }
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int ldiam = diameter(root.left);
        int rdiam = diameter(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(Math.max(ldiam,rdiam),lh+rh+1);
    }
    // code to calculate height of the tree;
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }
    public class Infoo{
        int ht;
        int diam;
        public Infoo(int ht,int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }
//   public static void Klevel(Node root,int level,int K){
//        if(root == null){
//            return ;
//        }
//        if(level == K){
//            System.out.print(root.data+" ");
//        }
//        Klevel(root.left,level+1,K);
//        Klevel(root.right,level+1,K);
//   }

public static void Kthlevel(Node root,int level,int k){
        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.data + " ");
        }
        // if the data is not mached check in both left and right subroots with recursion;
        Kthlevel(root.left,level+1,k);
        Kthlevel(root.right,level+1,k);
}



//   public static boolean getPath(Node root,int n,ArrayList<Node> path){
//        if(root == null){
//            return false;
//        }
//        path.add(root);
//        if(root.data == n){
//            return true;
//        }
//        boolean foundLeft = getPath(root.left,n,path);
//        boolean foundRight = getPath(root.right,n,path);
//
//        if(foundLeft||foundRight){
//            return true;
//       }
//
//        path.remove(path.size()-1);
//
//    return false;
//    }
//
//   public static Node lca(Node root,int n1,int n2){
//        ArrayList<Node> path1 = new ArrayList<>();
//        ArrayList<Node> path2 = new ArrayList<>();
//
//        getPath(root,n1,path1);
//        getPath(root,n2,path2);
//
//        int i = 0;
//        for(;i < path1.size()&&i<path2.size();i++){
//            if(path1.get(i)!= path2.get(i)){
//                break;
//            }
//        }
//        //System.out.println(path1.get(i-1).data);
//       Node lca = path1.get(i-1);
//        return lca;
//   }

    public static boolean getPath(Node root,int n,LinkedList<Node> path){
        if(root ==null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }
        boolean foundLeft  = getPath(root.left,n,path);
        boolean foundRight = getPath(root.right,n,path);

        if(foundLeft||foundRight){
            return true;
        }
        path.remove(path.size()-1);

        return false;
    }

    public static Node lca(Node root,int n1,int n2){
        LinkedList<Node> path1 = new LinkedList<>();
        LinkedList<Node> path2 = new LinkedList<>();
        getPath(root,n1,path1);
        getPath(root,n2,path2);

        int i = 0;//to use in return statement
        for(;i < path1.size()&&i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        return path1.get(i-1);
    }


//   public static Node lca2(Node root,int n1,int n2){
//        if(root == null||root.data == n1||root.data == n2){
//            return root;
//        }
//        Node leftlca = lca2(root.left,n1,n2);
//        Node rightlca = lca2(root.right,n1,n2);
//        // if ldft lca == val, rlca == null
//       if(rightlca == null){
//           return leftlca;
//       }
//       if(leftlca == null){
//           return rightlca;
//       }
//       return root;
//
//   }

    public static Node lca2(Node root,int n1,int n2){
        //base case..
        if(root == null){
            return null;
        }
        if(root.data == n1||root.data == n2){
            return root;
        }
        // recursive calls for left and right...
        Node foundLeft = lca2(root.left,n1,n2);
        Node foundRight = lca2(root.right,n1,n2);
        //fleft = vall & fright ==null;
        if(foundRight == null){
            return foundLeft;
        }
        if(foundLeft == null){
            return foundRight;
        }
        return root;

    }



//   public static int lcaDist(Node root,int n) {
//       if (root == null) {
//           return -1;
//       }
//       if(root.data == n){
//           return 0;
//       }
//      int leftDist = lcaDist(root.left,n);
//       int rightDist = lcaDist(root.right,n);
//       if(leftDist ==-1&&rightDist==-1){
//           return -1;
//       }
//       else if(leftDist == -1){
//           return rightDist+1;
//       }
//       else {
//           return leftDist+1;
//       }
//
//   }
//   public static int minDist(Node root,int n1,int n2){
//        //Node lca = lca2(root,n1,n2);
//        int dist1 = lcaDist(root,n1);
//        int dist2 = lcaDist(root,n2);
//
//        return dist1+dist2;
//   }
    public static int dist(Node root,int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int foundL = dist(root.left,n);
        int foundR = dist(root.right,n);

        if(foundL== -1&& foundR== -1){
            return -1;
        }
        if(foundL == -1){
            return foundR+1;
        }else{
            return foundL+1;
        }

    }

    public static int minDistence(Node root,int n1,int n2){
        Node lca = lca2(root,n1,n2);
        int dist1 = dist(lca,n1);
        int dist2 = dist(lca,n2);
        return dist1+dist2;

    }
//   public static int KAnsistor(Node root,int n,int k){
//        if(root == null){
//            return -1;
//        }
//        if(root.data == n){
//            return 0;
//        }
//        int leftDist = KAnsistor(root.left, n,k);
//        int rightDist = KAnsistor(root.right,n,k);
//
//
//
//
//        if(leftDist == -1 && rightDist ==-1){
//            return -1;
//        }
//        int max = Math.max(leftDist,rightDist);
//        if(max+1 == k){
//            System.out.println("KthAnsistor = "+root.data);
//           // return -1;// stops further progression
//        }
//        return max+1;
//
//   }









   public static int Transform(Node root){
        if(root == null){
            return 0;
        }
        int leftChild = Transform(root.left);
        int rightChild = Transform(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0:root.left.data;
        int newRight = root.right == null ? 0:root.right.data;

        root.data = leftChild+rightChild+newLeft+newRight;
        return  data;



   }
   public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.right);
        preOrder(root.left);
   }


    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root =  tree.buildTree(nodes);
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
//        // System.out.println(root.data);
//        tree.preOrder(root);// here we called preOrder using tree because it is inside the BinaryTree class..
//        System.out.println();
//        tree.inOrder(root);
//        System.out.println();
//        tree.levelOrder(root);
//        System.out.println(isSubtree(root,subRoot));
//        topView(root);
      //System.out.println(diameter(root));
        //Klevel(root,1,2);
       //KAnsistor(root,4,2);
        //System.out.print(lca2(root,2,4).data);
        //Kthlevel(root,1,6);
        //System.out.println(minDistence(root,2,6));
      //KthAnsistor(root,6,1);

        Transform(root);
        preOrder(root);
    }
}
