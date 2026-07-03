// Import Scanner class to take keyboard input from the user
import java.util.Scanner;
public class Main
{

    public static void main(String[] args)
    {

        StudentManager manager = new StudentManager();
        // Create the StudentManager object

        // Load previously saved student data
        manager.loadFromFile();

        // Create Scanner object for taking user input
        Scanner scanner = new Scanner(System.in);

        // Variable to store the user's menu choice
        int choice=0;

        // Repeat the menu until the user chooses Exit
        while (true)
        {

            System.out.println("\n=========================================");
            System.out.println(" STUDENT REPORT CARD MANAGEMENT SYSTEM ");
            System.out.println("=========================================");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Update Marks");
            System.out.println("6. Delete Student");
            System.out.println("7. View Statistics");
            System.out.println("8. Sort Students By Average");
            System.out.println("9. Display Topper");
            System.out.println("10. Display Student Rankings");
            System.out.println("11. Filter Students By Grade");
            System.out.println("12. Display Grade Distribution");
            System.out.println("13. Export Student Report To CSV");
            System.out.println("14. Save Data");
            System.out.println("15. Exit");

            try
            {

                System.out.print("\nEnter your choice: ");

                choice = scanner.nextInt();

            }
            catch (Exception e)
            {

                System.out.println("Invalid input!");

                scanner.nextLine();

                continue;

            }

            switch (choice) {

                // Temporary placeholder
                case 1: {

                    // Ask the user to enter the student ID
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();

                    // Check whether the entered ID already exists
                    if (manager.isDuplicateId(id)) {
                        System.out.println("Student ID already exists.");
                        break;
                    }

                    // Consume leftover newline
                    scanner.nextLine();

                    // Read student name
                    String name;
                    while (true) {
                        System.out.print("Enter Student Name: ");
                        name = scanner.nextLine().trim();

                        if (!name.isEmpty())
                            break;

                        System.out.println("Student name cannot be empty.");
                    }

                    // Read English marks
                    double english;
                    while (true) {
                        try {
                            System.out.print("Enter English Marks (0-100): ");
                            english = scanner.nextDouble();

                            if (english >= 0 && english <= 100)
                                break;

                            System.out.println("Marks must be between 0 and 100.");
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                            scanner.nextLine();
                        }
                    }

                    // Read Mathematics marks
                    double mathematics;
                    while (true) {
                        try {
                            System.out.print("Enter Mathematics Marks (0-100): ");
                            mathematics = scanner.nextDouble();

                            if (mathematics >= 0 && mathematics <= 100)
                                break;

                            System.out.println("Marks must be between 0 and 100.");
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                            scanner.nextLine();
                        }
                    }

                    // Read Science marks
                    double science;
                    while (true) {
                        try {
                            System.out.print("Enter Science Marks (0-100): ");
                            science = scanner.nextDouble();

                            if (science >= 0 && science <= 100)
                                break;

                            System.out.println("Marks must be between 0 and 100.");
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                            scanner.nextLine();
                        }
                    }

                    // Read Computer marks
                    double computer;
                    while (true) {
                        try {
                            System.out.print("Enter Computer Marks (0-100): ");
                            computer = scanner.nextDouble();

                            if (computer >= 0 && computer <= 100)
                                break;

                            System.out.println("Marks must be between 0 and 100.");
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                            scanner.nextLine();
                        }
                    }

                    // Read Social marks
                    double social;
                    while (true) {
                        try {
                            System.out.print("Enter Social Marks (0-100): ");
                            social = scanner.nextDouble();

                            if (social >= 0 && social <= 100)
                                break;

                            System.out.println("Marks must be between 0 and 100.");
                        } catch (Exception e) {
                            System.out.println("Invalid input!");
                            scanner.nextLine();
                        }
                    }

                    // Create Student object
                    Student student = new Student(
                            id,
                            name,
                            english,
                            mathematics,
                            science,
                            computer,
                            social
                    );

                    // Add student
                    manager.addStudent(student);

                    break;
                }

                case 2: {

                    // Display all students stored in the system
                    manager.viewStudents();

                    // Exit this case
                    break;
                }

                case 3: {

                    // Ask the user to enter the student ID to search
                    System.out.print("Enter Student ID to search: ");

                    // Read the ID entered by the user
                    int searchId = scanner.nextInt();

                    // Search for the student using StudentManager
                    Student foundStudent = manager.searchStudent(searchId);

                    // Check if a student was found
                    if (foundStudent != null) {

                        // Display the student's details
                        System.out.println("\n===== Student Found =====");
                        System.out.println(foundStudent);

                    } else {

                        // Display message if no student exists with that ID
                        System.out.println("Student not found.");

                    }

                    // Exit this case
                    break;
                }

                case 4: {

                    // Consume the leftover newline character
                    scanner.nextLine();

                    // Ask the user to enter a name to search
                    System.out.print("Enter Student Name: ");

                    // Read the complete name or partial name
                    String searchName = scanner.nextLine();

                    // Search students by name
                    manager.searchStudentByName(searchName);

                    // Exit this case
                    break;
                }

                case 5: {

                    // Ask for Student ID
                    System.out.print("Enter Student ID: ");

                    int updateId = scanner.nextInt();

                    // Input new subject marks
                    System.out.print("Enter English Marks: ");
                    double english = scanner.nextDouble();

                    System.out.print("Enter Mathematics Marks: ");
                    double mathematics = scanner.nextDouble();

                    System.out.print("Enter Science Marks: ");
                    double science = scanner.nextDouble();

                    System.out.print("Enter Computer Marks: ");
                    double computer = scanner.nextDouble();

                    System.out.print("Enter Social Marks: ");
                    double social = scanner.nextDouble();

                    // Update marks
                    manager.updateMarks(
                            updateId,
                            english,
                            mathematics,
                            science,
                            computer,
                            social
                    );

                    break;
                }

                case 6: {

                    // Ask the user to enter the student ID to delete
                    System.out.print("Enter Student ID to delete: ");

                    // Read the student ID
                    int deleteId = scanner.nextInt();

                    // Delete the student from the list
                    manager.deleteStudent(deleteId);

                    // Exit this case
                    break;
                }

                case 7: {

                    // Display statistics of all students
                    manager.displayStatistics();

                    // Exit this case
                    break;
                }

                case 8: {

                    // Display students sorted by average
                    manager.sortStudentsByAverage();

                    break;
                }

                case 9: {

                    // Display the student with the highest marks
                    manager.displayTopper();

                    break;
                }

                case 10:
                {

                    // Display all students with their rankings
                    manager.displayRankings();

                    // Exit this case
                    break;
                }

                case 11:
                {

                    // Ask the user to enter a grade
                    System.out.print("Enter Grade (A/B/C/D/F): ");

                    // Read the grade entered by the user
                    char grade = scanner.next().toUpperCase().charAt(0);

                    // Display students with the entered grade
                    manager.filterStudentsByGrade(grade);

                    break;
                }

                case 12:
                {

                    // Display grade distribution
                    manager.displayGradeDistribution();

                    // Exit this case
                    break;
                }

                case 13:
                {

                    // Export all student records to a CSV file
                    manager.exportToCSV();

                    break;
                }

                case 14:
                {

                    // Save all students to the file
                    manager.saveToFile();

                    break;
                }

                case 15:
                {

                    // Display exit message
                    System.out.println("Exiting program...");

                    // Save all student data before closing
                    manager.saveToFile();

                    System.out.println("Thank you for using Student Report Card Management System.");

                    // Close the Scanner object
                    scanner.close();

                    // Exit the program
                    return;
                }

                default:

                    // Display error for invalid choice
                    System.out.println("Invalid choice! Please try again.");

            }

        }


    }
}

