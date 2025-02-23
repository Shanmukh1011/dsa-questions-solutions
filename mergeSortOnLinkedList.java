import java.util.*;

class Main{
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;//mid Node;
    }
    private Node merge(Node head1,Node head2){
        Node mergedll = new Node(-1);
        Node temp = mergedll;

        while(head1 != null && head2 !=null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }

        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedll.next; //bcz 1st one is dumy
    }
    public Node mergeSort(Node head){
        if(head == null || head.next==null){
            return head;
        }
        //find mid
        Node mid = getMid(head);

        //left and right merge sort
        Node rightHead = mid.next;
        mid.next = null;
        //left and right ms
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        return merge(newLeft,newRight);
    }

    public Node convertToLinkedList(LinkedList<Integer> list) {
        if (list.isEmpty()) return null;

        Node head = new Node(list.get(0));
        Node temp = head;

        for (int i = 1; i < list.size(); i++) {
            temp.next = new Node(list.get(i));
            temp = temp.next;
        }
        return head;
    }

    // Convert custom linked list to LinkedList<Integer>
    public LinkedList<Integer> convertToList(Node head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.data);
            head = head.next;
        }
        return list;
    }

    public static void main(String args[]){
        Main obj = new Main();
        //create ll
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(5);
        ll.add(4);
        ll.add(3);
        ll.add(2);
        ll.add(1);
        System.out.println(ll);
        Node head = obj.convertToLinkedList(ll);
        head = obj.mergeSort(head);

        // Convert back to LinkedList<Integer>
        LinkedList<Integer> sortedList = obj.convertToList(head);

        System.out.println("After sorting: " + sortedList);


    }
        }
