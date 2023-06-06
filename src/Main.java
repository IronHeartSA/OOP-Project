import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserManager userManager = new UserManager();

        // Prompt the user to login or register
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("----- Student Management System -----");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    // Login
                    loggedIn = userManager.loginUser();
                    break;
                case 2:
                    // Register
                    userManager.registerUser();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        String[] subjectNames = new String[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            scanner.nextLine(); // Consume newline character
            System.out.print("Enter subject name " + (i + 1) + ": ");
            subjectNames[i] = scanner.nextLine();
        }

        StudentManagementSystem[] students = new StudentManagementSystem[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1));
            scanner.nextLine(); // Consume newline character

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter roll number: ");
            int roll = scanner.nextInt();

            System.out.print("Enter student age: ");
            int age = scanner.nextInt();

            System.out.print("Enter student grade: ");
            String grade = scanner.next();

            students[i] = new StudentManagementSystem(name, roll, age, grade, subjectNames);
        }

        // Create a new file to store student data
        try {
            FileWriter writer = new FileWriter("student_data.txt");

            // Write the number of students and subjects
            writer.write(numStudents + "," + numSubjects + "\n");

            // Write subject names on a new line
            for (String subjectName : subjectNames) {
                writer.write(subjectName + ",");
            }
            writer.write("\n");

            // Write each student's data on a new line
            for (int i = 0; i < numStudents; i++) {
                writer.write(students[i].studentName + "," + students[i].rollNumber + "," + students[i].age + "," + students[i].grade);
                for (boolean attendance : students[i].attendance) {
                    writer.write("," + (attendance ? "P" : "A"));
                }
                writer.write("\n");
            }

            writer.close();
            System.out.println("Student data written to file successfully!");

            // Show the menu
            StudentMenu.showMenu(students);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }

        scanner.close();
    }
}
