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
            System.out.println("7. Save Data");
            System.out.println("8. Exit");

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

                    System.out.println("Search Student selected.");

                    break;

                case 4:

                    System.out.println("Update Marks selected.");

                    break;

                case 5:

                    System.out.println("Delete Student selected.");

                    break;

                case 6:

                    System.out.println("View Statistics selected.");

                    break;

                case 7:

                    System.out.println("Save Data selected.");

                    break;

                case 8:

                    System.out.println("Exiting program...");

                    // Save all students before closing
                    manager.saveToFile();

                    // Close Scanner object
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

