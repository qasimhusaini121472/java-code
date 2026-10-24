import java.util.*;
public class Task2 {
    public static void main(String[] args) {
        HashSet<String> courses = new HashSet<>();
        courses.add("CS101");
        courses.add("CS102");
        courses.add("MT105");
        courses.add("CS101");
        courses.add("EN110");
        courses.add("CS102");
        courses.add("MT105");
        courses.add("CS205");
        courses.add("EN110");
        courses.add("CS301");
        System.out.println("Unique Course Codes:");
        for (String course : courses) {
            System.out.println(course);
        }
        System.out.println("\nTotal unique codes: " + courses.size());
        boolean result = courses.add("CS205");
        System.out.println("\nValue returned by add(CS205): " + result);
    }
}