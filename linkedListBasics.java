
public class LinkedList {

    public static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
       
    public void addFirst(int data){
        //steop1 = creating a new Node;
     Node newNode = new Node(data);
     size++;
     if(head == null){
        head = tail= newNode;
        return;
     }

        //step 2 = newNode next = head;
        newNode.next = head;//link;
        //step 3 = head = newNode;
        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void print(){//O(n)
        
        Node temp = head;
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
       
    }
    public void add(int idx,int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i <idx-1){
            temp = temp.next;
            i++;
        }
        //i = idx-1;temp = prev
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int removeFirst(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            size = 0;
            int val = head.data;
            head=tail=null;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head=tail=null;
            size = 0;
            return val;
        }
        //prive:i==size-2;
        Node prev = head;
        for(int i = 0;i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;//tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
        
    }
    public int itrSearch(int key){//O(n);
        Node temp = head;
        int idx = 0;
        while(temp!=null){
            if(temp.data==key){
                return idx;
            }
            temp = temp.next;
            idx++;

        }
        return -1;
    }
    public int helper(Node head,int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next,key);
            if(idx == -1){
                return -1;
            }
                return idx+1;
            
        
    }
    public int recSearch(int key){
       return  helper(head,key);
    }
    public void reverse(){
        Node prev = null;
        Node curr = tail= head;//java assaigns right to left;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
            
        }
        head = prev;
    }
    public void deleteNthfromEnd(int n){
        int sz = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }
        if(n==sz){
            head = head.next;
            return;
        }
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i<iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null&&fast.next != null){
            slow = slow.next;//+1
            fast = fast.next.next;//+2
        }
        return slow;//slow is my mid;
    }

    public boolean checkPelendrom(){
        if(head == null || head.next==null){
            return true;
        }
        //find the mid
        Node midNode = findMid(head);
        //reverse the 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next ;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        Node right = prev;
        Node left = head;
        //check left half and right half
        while(right!=null){
            if(right.data!=left.data){
                return false;
            }
            left = left.next;
            right = right.next;

        }
        return true;
    }

    public static  boolean isCycle(){
        Node fast = head;
        Node slow = head;

        while(fast != null&& fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void removeCycle(){//code does not work for corner case..when last node connects to head;
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow  = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                cycle = true;
                break;

            }

        }
        if(cycle == false){
            return ;
        }


        //find meeting point;
        slow = head;
        Node prev = null;
        while(slow!=fast){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        //remove cycle ->last.next = null;
        prev.next = null;//last node;
    }


    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        
        ll.addFirst(2);
        
        ll.addFirst(1);
        
        ll.addLast(2);
        
        ll.addLast(1);
        ll.print();
        System.out.println(ll.checkPelendrom());
       
        

    }
}
