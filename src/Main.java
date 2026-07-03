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

            // Display application title
            System.out.println("\n=========================================");
            System.out.println("      STUDENT GRADE TRACKER");
            System.out.println("=========================================");

            // Display all available options
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Update Marks");
            System.out.println("6. Delete Student");
            System.out.println("7. View Statistics");
            System.out.println("8. Sort Students By Marks");
            System.out.println("9. Display Topper");
            System.out.println("10. Display Student Rankings");
            System.out.println("11. Filter Students By Grade");
            System.out.println("12. Display Grade Distribution");
            System.out.println("13. Save Data");
            System.out.println("14. Exit");

            while(true)
            {
                try
                {

                    // Ask the user to enter a menu choice
                    System.out.print("Enter your choice: ");

                    // Read the user's choice
                    choice = scanner.nextInt();

                    // Exit the validation loop if input is valid
                    break;

                }
                catch (Exception e) {

                    // Display an error message
                    System.out.println("Invalid input! Please enter a number.");

                    // Remove the invalid input from the Scanner
                    scanner.nextLine();

                }
            }

            // Switch statement will execute the selected option
            switch (choice)
            {

                // Temporary placeholder
                case 1:

                    // Ask the user to enter the student ID
                    System.out.print("Enter Student ID: ");

                    // Read the student ID
                    int id = scanner.nextInt();

                    // Check whether the entered ID already exists
                    if (manager.isDuplicateId(id))
                    {

                        // Display an error message
                        System.out.println("Student ID already exists.");

                        // Return to the main menu
                        break;

                    }

                    // Consume the leftover newline character
                    scanner.nextLine();

                    // Variable to store the student's name
                    String name;

                    // Keep asking until a valid name is entered
                    while (true)
                    {

                        // Ask the user to enter the student's name
                        System.out.print("Enter Student Name: ");

                        // Read the student's name
                        name = scanner.nextLine();

                        // Remove leading and trailing spaces
                        name = name.trim();

                        // Check if the name is not empty
                        if (!name.isEmpty())
                        {

                            // Exit the loop if the name is valid
                            break;

                        }

                        // Display an error message
                        System.out.println("Student name cannot be empty.");

                    }

                    // Variable to store the student's marks
                    double marks;

                    // Keep asking until valid marks are entered
                    while (true)
                    {

                        try
                        {

                            // Ask the user to enter the student's marks
                            System.out.print("Enter Student Marks (0-100): ");

                            // Read the marks
                            marks = scanner.nextDouble();

                            // Check if the marks are between 0 and 100
                            if (marks >= 0 && marks <= 100)
                            {

                                // Exit the loop if marks are valid
                                break;

                            }

                            // Display an error message for invalid marks
                            System.out.println("Marks must be between 0 and 100.");

                        }
                        catch (Exception e)
                        {

                            // Display an error message for non-numeric input
                            System.out.println("Invalid marks! Please enter a number.");

                            // Remove the invalid input from the Scanner
                            scanner.nextLine();

                        }

                    }

                    // Create a new Student object
                    Student student = new Student(id, name, marks);

                    // Add the student to the StudentManager
                    manager.addStudent(student);

                    // Exit this case
                    break;

                case 2:

                    // Display all students stored in the system
                    manager.viewStudents();

                    // Exit this case
                    break;

                case 3:

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

                case 4:

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

                case 5:

                    // Ask the user for the student's ID
                    System.out.print("Enter Student ID to update: ");

                    // Read the student's ID
                    int updateId = scanner.nextInt();

                    // Ask the user for the new marks
                    System.out.print("Enter New Marks: ");

                    // Read the new marks
                    double newMarks = scanner.nextDouble();

                    // Update the student's marks
                    manager.updateMarks(updateId, newMarks);

                    // Exit this case
                    break;

                case 6:

                    // Ask the user to enter the student ID to delete
                    System.out.print("Enter Student ID to delete: ");

                    // Read the student ID
                    int deleteId = scanner.nextInt();

                    // Delete the student from the list
                    manager.deleteStudent(deleteId);

                    // Exit this case
                    break;

                case 7:

                    // Display statistics of all students
                    manager.displayStatistics();

                    // Exit this case
                    break;

                case 8:

                    // Display students sorted by marks
                    manager.sortStudentsByMarks();

                    break;

                case 9:

                    // Display the student with the highest marks
                    manager.displayTopper();

                    break;

                case 10:

                    // Display all students with their rankings
                    manager.displayRankings();

                    // Exit this case
                    break;

                case 11:

                    // Ask the user to enter a grade
                    System.out.print("Enter Grade (A/B/C/D/F): ");

                    // Read the grade entered by the user
                    char grade = scanner.next().toUpperCase().charAt(0);

                    // Display students with the entered grade
                    manager.filterStudentsByGrade(grade);

                    break;

                case 12:

                    // Display grade distribution
                    manager.displayGradeDistribution();

                    // Exit this case
                    break;

                case 13:

                    // Save all students to the file
                    manager.saveToFile();

                    break;

                case 14:

                    // Display exit message
                    System.out.println("Exiting program...");

                    // Save all student data before closing
                    manager.saveToFile();

                    // Close the Scanner object
                    scanner.close();

                    // Exit the program
                    return;

                default:

                    // Display error for invalid choice
                    System.out.println("Invalid choice! Please try again.");

            }

        }


    }
}

