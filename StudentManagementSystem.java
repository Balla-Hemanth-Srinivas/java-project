import java.util.ArrayList;
import java.util.Scanner;

// Abstract class to define the blueprint of a Person
abstract class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Abstract method for displaying details
    public abstract String displayDetails();
}

// Student class inheriting from Person
class Student extends Person {
    private String department;

    public Student(int id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String displayDetails() {
        return "Student [ID: " + getId() + ", Name: " + getName() + ", Department: " + department + "]";
    }
}

// GraduateStudent subclass inheriting from Student
class GraduateStudent extends Student {
    private String thesisTitle;

    public GraduateStudent(int id, String name, String department, String thesisTitle) {
        super(id, name, department);
        this.thesisTitle = thesisTitle;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    @Override
    public String displayDetails() {
        return "GraduateStudent [ID: " + getId() + ", Name: " + getName() + ", Department: " + getDepartment() +
               ", Thesis Title: " + thesisTitle + "]";
    }
}

// Main class for managing students
public class StudentManagementSystem {
    private ArrayList<Person> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Method to add a student
    public void addStudent() {
        System.out.println("Add Student Type: 1. Regular Student 2. Graduate Student");
        int choice = scanner.nextInt();

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        if (choice == 1) {
            students.add(new Student(id, name, department));
        } else if (choice == 2) {
            System.out.print("Enter Thesis Title: ");
            String thesisTitle = scanner.nextLine();
            students.add(new GraduateStudent(id, name, department, thesisTitle));
        }
        System.out.println("Student added successfully!");
    }

    // Method to view all students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("List of Students:");
            for (Person student : students) {
                System.out.println(student.displayDetails());
            }
        }
    }

    // Main menu
    public void menu() {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.menu();
    }
}
