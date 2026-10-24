import java.util.ArrayList;
import java.util.Scanner;
/*
 * I used ArrayList because it can store student objects and grow dynamically.
 * It also makes searching, updating, adding, and deleting records convenient.
 * A Set would be a poor choice here because we need to manage complete student
 * records by registration number, and an ordinary Set does not provide direct ID-based lookup.
 */
public class Task5 {
    static class Student {
        String regNo;
        String name;
        int semester;
        double cgpa;
        Student(String regNo, String name, int semester, double cgpa) {
            this.regNo = regNo;
            this.name = name;
            this.semester = semester;
            this.cgpa = cgpa;
        }
        void display() {
            System.out.println("Reg. No.: " + regNo);
            System.out.println("Name: " + name);
            System.out.println("Semester: " + semester);
            System.out.println("CGPA: " + cgpa);
            System.out.println("-------------------------");
        }
    }
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static Student findStudent(String regNo) {
        for (Student s : students) {
            if (s.regNo.equalsIgnoreCase(regNo)) {
                return s;
            }
        }
        return null;
    }
    static void addStudent() {
        System.out.print("Enter Reg. No.: ");
        String regNo = sc.nextLine().trim();
        if (findStudent(regNo) != null) {
            System.out.println("Duplicate Reg. No. is rejected!");
            return;
        }
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Semester: ");
        int semester = Integer.parseInt(sc.nextLine());
        System.out.print("Enter CGPA: ");
        double cgpa = Double.parseDouble(sc.nextLine());
        students.add(new Student(regNo, name, semester, cgpa));
        System.out.println("Student added successfully!");
    }
    static void searchStudent() {
        System.out.print("Enter Reg. No. to search: ");
        String regNo = sc.nextLine().trim();
        Student s = findStudent(regNo);
        if (s == null) {
            System.out.println("Record not found.");
        } else {
            s.display();
        }
    }
    static void updateStudent() {
        System.out.print("Enter Reg. No. to update: ");
        String regNo = sc.nextLine().trim();
        Student s = findStudent(regNo);
        if (s == null) {
            System.out.println("Record not found.");
            return;
        }
        System.out.print("Enter new Semester: ");
        s.semester = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new CGPA: ");
        s.cgpa = Double.parseDouble(sc.nextLine());
        System.out.println("Student record updated successfully!");
    }
    static void deleteStudent() {
        System.out.print("Enter Reg. No. to delete: ");
        String regNo = sc.nextLine().trim();
        Student s = findStudent(regNo);
        if (s == null) {
            System.out.println("Record not found.");
        } else {
            students.remove(s);
            System.out.println("Student deleted successfully!");
        }
    }
    static void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        System.out.println("\n===== All Student Records =====");
        for (Student s : students) {
            s.display();
        }
    }
    static void showDeansList() {
        boolean found = false;
        System.out.println("\n===== Dean's List (CGPA >= 3.5) =====");
        for (Student s : students) {
            if (s.cgpa >= 3.5) {
                s.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students qualify for Dean's List.");
        }
    }
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Records =====");
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Show All");
            System.out.println("6. Dean's List");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        searchStudent();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        showAllStudents();
                        break;
                    case 6:
                        showDeansList();
                        break;
                    case 0:
                        System.out.println("Exiting Student Record System...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a valid number.");
                choice = -1;
            }
        } while (choice != 0);
        sc.close();
    }
}
