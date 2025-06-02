import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NotesManager notes = new NotesManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to the student grade management system!");
        System.out.println("Please choose an option:");
        do {
            System.out.println("\n1. Add a student");
            System.out.println("2. View all students/grades");
            System.out.println("3. View grade of a specific student");
            System.out.println("4. View passing students");
            System.out.println("5. Save grades");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("\nName: ");
                    String name = scanner.nextLine();
                    System.out.print("Grade: ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine();
                    notes.addStudent(name, grade);
                    System.out.println("Student added successfully!");
                }
                case 2 -> {
                    System.out.println("\nList of students and their grades:");
                    var allNotes = notes.getAllNotes();
                    if (allNotes.isEmpty()) {
                        System.out.println("\nNo students found.");
                    } else {
                        for (var e : allNotes.entrySet()) {
                            System.out.println(e.getKey() + " - " + e.getValue());
                        }
                    }
                }

                case 3 -> {
                    System.out.print("\nEnter a student's name: ");
                    String studentName = scanner.nextLine();
                    Double studentGrade = notes.getNote(studentName);
                    if (studentGrade != null) {
                        System.out.println(studentName + "'s grade: " + studentGrade);
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 4 -> {
                    System.out.println("\nList of passing students:");
                    var passing = notes.getSucessfulStudents();
                    if (passing.isEmpty()) {
                        System.out.println("\nNo passing students found.");
                    } else {
                        for (var e : passing.entrySet()) {
                            System.out.println(e.getKey() + " - " + e.getValue());
                        }
                    }
                }

                case 5 -> {
                    notes.serializeNotes();
                    System.out.println("\nGrades have been successfully saved.");
                }
                case 6 -> System.out.println("\nProgram ended.");
                default -> System.out.println("\nInvalid choice.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
