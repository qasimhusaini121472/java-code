import java.util.*;
public class Task3 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("omar");
        queue.add("ayesha");
        queue.add("haris");
        queue.add("usman");
        queue.add("taha");
        System.out.println("Next student: " + queue.peek());
        String student1 = queue.remove();
        String student2 = queue.remove();
        System.out.println("Served: " + student1);
        System.out.println("Served: " + student2);
        System.out.println("Students still waiting:");
        for (String student : queue) {
            System.out.println(student);
        }
        System.out.println("Students waiting: " + queue.size());
    }
}