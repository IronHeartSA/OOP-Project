import java.util.Scanner;

public class StudentMenu {
    public static void showMenu(StudentManagementSystem[] students) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Display Student Details");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Show Subjects");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Display student details
                    System.out.print("Enter student number to display details (1-" + students.length + "): ");
                    int studentNum = scanner.nextInt();
                    if (studentNum >= 1 && studentNum <= students.length) {
                        System.out.println("\nStudent " + studentNum + " Details:");
                        students[studentNum - 1].displayDetails();
                    } else {
                        System.out.println("Invalid student number!");
                    }
                    break;
                case 2:
                    // Mark attendance
                    System.out.print("Enter student number to mark attendance (1-" + students.length + "): ");
                    int studentIndex = scanner.nextInt();
                    if (studentIndex >= 1 && studentIndex <= students.length) {
                        StudentManagementSystem student = students[studentIndex - 1];
                        System.out.print("Enter subject name to mark attendance: ");
                        scanner.nextLine(); // Consume newline character
                        String subjectName = scanner.nextLine();
                        if (subjectName.trim().isEmpty()) {
                            System.out.println("Subject name cannot be empty!");
                        } else {
                            System.out.print("Mark attendance (P/A): ");
                            String attendance = scanner.next();
                            if (attendance.equalsIgnoreCase("P")) {
                                student.markPresent(subjectName);
                            } else if (attendance.equalsIgnoreCase("A")) {
                                student.markAbsent(subjectName);
                            } else {
                                System.out.println("Invalid attendance option!");
                            }
                        }
                    } else {
                        System.out.println("Invalid student number!");
                    }
                    break;
                case 3:
                    // Show subjects
                    System.out.println("\nSubjects:");
                    for (StudentManagementSystem student : students) {
                        for (String subject : student.getSubjects()) {
                            System.out.println(subject);
                        }
                    }
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();

    }
}
