import java.util.Comparator;
import java.util.PriorityQueue;



public class Main{
    //priority queues in classes...
   static class Student implements Comparable<Student>{
       String name;
       int rank;
       Student(String name,int rank){
           this.name = name;
           this.rank = rank;
       }
       @Override

       public int compareTo(Student  s2){
           return this.rank - s2.rank;
       }


    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student("Shyan",4));
        pq.add(new Student("Ram",7));
        pq.add(new Student("Ragav",3));
        pq.add(new Student("Rani",9));
        pq.add(new Student("Roja",6));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + "-->" + pq.peek().rank);
            pq.remove();
        }


    }
}
