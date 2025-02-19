  import java.util.ArrayList;
 class Code{
public static void swop(ArrayList<Integer> list,int ind1,int ind2){
    int swop = list.get(ind1);
    list.set(ind1,list.get(ind2));
    list.set(ind2,swop);
}
public static void main(String[] args) {


ArrayList<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);
list.add(40);
list.add(5);
int ind1 = 3;
int ind2 = 4;
System.out.println(list);
swop(list,ind1,ind2);
System.out.println(list);


    }
 }

 
