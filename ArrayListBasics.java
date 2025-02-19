 import java.util.ArrayList;
 
 class Code{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Boolean> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();

        //to add an number O(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //2nd type add O(n); somthing like inserting element;

        list.add(1,5);
        System.out.println(list);
        //to get a number = O(1);
        int element = list.get(2);
        System.out.println(element);

        //deleting or removing ele O(n);
        list.remove(2);
        System.out.println(list);
        //Set an element; O(n);
        list.set(2,3);
        System.out.println(list);

        //contains O(n);
        System.out.println(list.contains(2));
        System.out.println(list.contains(10));

        //size of arrayList;
      System.out.println(list.size());

      for(int i = 0;i <list.size();i++){
        System.out.print(list.get(i)+" ");
      }
    }
 }
