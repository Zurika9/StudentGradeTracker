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
        int choice;

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
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. View Statistics");
            System.out.println("7. Sort Students By Marks");
            System.out.println("8. Display Topper");
            System.out.println("9. Save Data Exit");
            System.out.println("10. Exit");


            // Ask the user to enter a choice
            System.out.print("Enter your choice: ");

            // Read the user's choice
            choice = scanner.nextInt();

            // Switch statement will execute the selected option
            switch (choice)
            {

                // Temporary placeholder
                case 1:

                    // Ask the user to enter the student ID
                    System.out.print("Enter Student ID: ");

                    // Read the student ID
                    int id = scanner.nextInt();

                    // Consume the leftover newline character
                    scanner.nextLine();

                    // Ask the user to enter the student's name
                    System.out.print("Enter Student Name: ");

                    // Read the full name (including spaces)
                    String name = scanner.nextLine();

                    // Ask the user to enter marks
                    System.out.print("Enter Student Marks: ");

                    // Read the marks
                    double marks = scanner.nextDouble();

                    // Create a new Student object
                    Student student = new Student(id, name, marks);

                    // Add the student to the manager
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

                case 5:

                    // Ask the user to enter the student ID to delete
                    System.out.print("Enter Student ID to delete: ");

                    // Read the student ID
                    int deleteId = scanner.nextInt();

                    // Delete the student from the list
                    manager.deleteStudent(deleteId);

                    // Exit this case
                    break;

                case 6:

                    // Display statistics of all students
                    manager.displayStatistics();

                    // Exit this case
                    break;

                case 7:

                    // Display students sorted by marks
                    manager.sortStudentsByMarks();

                    break;

                case 8:

                    // Display the student with the highest marks
                    manager.displayTopper();

                    break;

                case 9:

                    // Save all students to the file
                    manager.saveToFile();

                    break;

                case 10:

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

