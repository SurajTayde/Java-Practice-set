import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    static class Subject {
        String name;
        double grade;

        public Subject(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Subject> subjects = new ArrayList<>();

        System.out.println("Welcome to the Student Grade Tracker!");
        while (true) {
            try {
                System.out.println("\nOptions:");
                System.out.println("1. Add a Subject and Grade");
                System.out.println("2. Calculate Average and Display Grades");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine()); // Use nextLine for better input handling

                switch (choice) {
                    case 1:
                        // Add a subject and its grade
                        System.out.print("Enter subject name: ");
                        String subjectName = scanner.nextLine(); // Use nextLine to allow spaces in subject names

                        System.out.print("Enter grade (0-100): ");
                        double grade = Double.parseDouble(scanner.nextLine());

                        if (grade < 0 || grade > 100) {
                            System.out.println("Invalid grade! Please enter a value between 0 and 100.");
                        } else {
                            subjects.add(new Subject(subjectName, grade));
                            System.out.println("Subject added successfully.");
                        }
                        break;

                    case 2:
                        // Calculate average and display grades
                        if (subjects.isEmpty()) {
                            System.out.println("No grades available. Add some subjects first.");
                            break;
                        }

                        double total = 0;
                        System.out.println("\n--- Student Grades ---");
                        for (Subject subject : subjects) {
                            System.out.printf("Subject: %s, Grade: %.2f\n", subject.name, subject.grade);
                            total += subject.grade;
                        }

                        double average = total / subjects.size();
                        String letterGrade = getLetterGrade(average);
                        double cgpa = getGPA(letterGrade);

                        System.out.printf("\nOverall Average Grade: %.2f\n", average);
                        System.out.printf("Letter Grade: %s\n", letterGrade);
                        System.out.printf("GPA: %.2f\n", cgpa);
                        break;

                    case 3:
                        // Exit the program
                        System.out.println("Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numeric values where required.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    // Function to calculate letter grade
    public static String getLetterGrade(double average) {
        if (average >= 90)
            return "A";
        if (average >= 80)
            return "B";
        if (average >= 70)
            return "C";
        if (average >= 60)
            return "D";
        return "F";
    }

    // Function to calculate GPA based on letter grade
    public static double getGPA(String letterGrade) {
        switch (letterGrade) {
            case "A":
                return 4.0;
            case "B":
                return 3.0;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            default:
                return 0.0;
        }
    }
}
