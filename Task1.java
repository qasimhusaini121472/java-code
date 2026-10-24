import java.util.*;
public class Task1 {
    public static void main(String[] args) {
    ArrayList<String> squad = new ArrayList<>();
            squad.add("OMAR");
    squad.add("EJAZ");
    squad.add("FAKHAR");
    squad.add("HUSAIN");
    squad.add("HAIDER");
    squad.add("SHAHID");
    squad.add("IMRAN");
    squad.add("SHAHEEN");
    squad.add("NADIR");
    squad.add("HARIS");
    squad.add("HUSNAIN");
    System.out.println("Player at position 4: " + squad.get(3));
    squad.set(3, "WALEED");
    System.out.println("\nUpdated Squad:");
    for (int i = 0; i < squad.size(); i++) {
    System.out.println((i + 1) + ". " + squad.get(i));
    }
}
}