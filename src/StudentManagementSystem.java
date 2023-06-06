public class StudentManagementSystem {
    public String studentName;
    public int rollNumber;
    public int age;
    public String grade;
    public boolean[] attendance;
    public String[] subjects;

    // Constructor
    public StudentManagementSystem(String name, int roll, int studentAge, String studentGrade, String[] subjectNames) {
        studentName = name;
        rollNumber = roll;
        age = studentAge;
        grade = studentGrade;
        attendance = new boolean[subjectNames.length];
        subjects = subjectNames;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("Attendance:");

        for (int i = 0; i < attendance.length; i++) {
            System.out.println(subjects[i] + ": " + (attendance[i] ? "Present" : "Absent"));
        }
    }

    // Method to mark student present for a subject
    public void markPresent(String subjectName) {
        int subjectIndex = findSubjectIndex(subjectName);
        if (subjectIndex != -1) {
            attendance[subjectIndex] = true;
        } else {
            System.out.println("Invalid subject name!");
        }
    }
    // Method to mark student absent for a subject
    public void markAbsent(String subjectName) {
        int subjectIndex = findSubjectIndex(subjectName);
        if (subjectIndex != -1) {
            attendance[subjectIndex] = false;
        } else {
            System.out.println("Invalid subject name!");
        }
    }

    // Helper method to find the index of a subject
    public int findSubjectIndex(String subjectName) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equalsIgnoreCase(subjectName)) {
                return i;
            }
        }
        return -1;
    }

    // Method to get the subjects
    public String[] getSubjects() {
        return subjects;
    }
}
