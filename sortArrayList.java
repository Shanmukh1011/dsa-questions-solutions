  import java.util.ArrayList;
  import java.util.Collections;
 class Code{



    public static void main(String[] args) {


    ArrayList<Integer> list = new ArrayList<>();
    list.add(10);
    list.add(20);
    list.add(9);
    list.add(7);
    list.add(8);
    System.out.println(list);
    Collections.sort(list);
    System.out.println(list);
    Collections.sort(list,Collections.reverseOrder());
    System.out.println(list);



    }
 }

 
