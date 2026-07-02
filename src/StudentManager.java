// Import Collections class for sorting ArrayLists
import java.util.Collections;

// Import Comparator interface to define custom sorting logic
import java.util.Comparator;

import java.util.ArrayList;

// Used to read data from a file
import java.io.BufferedReader;

// Used to write data to a file
import java.io.BufferedWriter;

// Reads characters from a file
import java.io.FileReader;

// Writes characters to a file
import java.io.FileWriter;

// Handles file-related exceptions
import java.io.IOException;

// Used to check whether a file exists
import java.io.File;

public class StudentManager
{

    // List that stores all students
    private ArrayList<Student> students;

    // Constructor
    public StudentManager()
    {
        students = new ArrayList<>();
    }


    public void addStudent(Student student)
    {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void viewStudents()
    {

        if (students.isEmpty())
        {

            System.out.println("No students found.");

            return;

        }

        System.out.println("\n===== Student List =====");

        for (Student student : students)
        {

            System.out.println(student);

        }

    }

    public Student searchStudent(int id)
    {

        for (Student student : students)
        {

            if (student.getId() == id)
            {

                return student;

            }

        }

        return null;

    }

    // Method to delete a student using their ID
    public void deleteStudent(int id)
    {

        // Loop through all students
        for (Student student : students)
        {

            // Check if the current student's ID matches
            if (student.getId() == id)
            {

                // Remove the student from the list
                students.remove(student);

                // Display success message
                System.out.println("Student deleted successfully.");

                // Exit the method after deletion
                return;
            }
        }

        // Display message if no student was found
        System.out.println("Student not found.");
    }

    // Method to update a student's marks
    public void updateMarks(int id, double newMarks)
    {

        // Search through every student
        for (Student student : students)
        {

            // Check if the ID matches
            if (student.getId() == id)
            {

                // Update the marks
                student.setMarks(newMarks);

                // Display success message
                System.out.println("Marks updated successfully.");

                return;
            }
        }

        // Display message if student was not found
        System.out.println("Student not found.");
    }

    // Method to display statistics of all students
    public void displayStatistics()
    {

        // Check if there are any students in the list
        if (students.isEmpty())
        {

            System.out.println("No students available.");

            return;
        }

        // Variable to store the total marks
        double totalMarks = 0;

        // Assume the first student's marks are both highest and lowest
        double highestMarks = students.get(0).getMarks();
        double lowestMarks = students.get(0).getMarks();

        // Variables to count pass and fail students
        int passCount = 0;
        int failCount = 0;

        // Loop through every student in the list
        for (Student student : students)
        {

            // Get the current student's marks
            double marks = student.getMarks();

            // Add marks to the running total
            totalMarks += marks;

            // Check if current marks are greater than highest marks
            if (marks > highestMarks)
            {

                highestMarks = marks;

            }

            // Check if current marks are lower than lowest marks
            if (marks < lowestMarks)
            {

                lowestMarks = marks;

            }

            // Students with 40 or more marks are considered passed
            if (marks >= 40)
            {

                passCount++;

            } else
            {

                failCount++;

            }

        }

        // Calculate average marks
        double averageMarks = totalMarks / students.size();

        // Calculate pass percentage
        double passPercentage = (double) passCount / students.size() * 100;

        // Display the statistics
        System.out.println("\n========== CLASS STATISTICS ==========");

        System.out.println("Total Students : " + students.size());

        System.out.println("Average Marks  : " + averageMarks);

        System.out.println("Highest Marks  : " + highestMarks);

        System.out.println("Lowest Marks   : " + lowestMarks);

        System.out.println("Pass Count     : " + passCount);

        System.out.println("Fail Count     : " + failCount);

        System.out.printf("Pass Percentage: %.2f%%\n", passPercentage);

        System.out.println("======================================");
    }

    // Method to save all students into grades.txt
    public void saveToFile()
    {

        try
        {

            // Create a writer object for grades.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("grades.txt"));

            // Loop through every student
            for (Student student : students)
            {

                // Save one student per line in CSV format
                writer.write(
                        student.getId() + "," +
                                student.getName() + "," +
                                student.getMarks()
                );

                // Move to the next line
                writer.newLine();
            }

            // Close the writer to save the file properly
            writer.close();

            // Display success message
            System.out.println("Student data saved successfully.");

        }
        catch (IOException e)
        {

            // Display error message if saving fails
            System.out.println("Error saving file: " + e.getMessage());

        }

    }

    // Method to load students from grades.txt
    public void loadFromFile()
    {

        // Print the absolute path of the file being read
        System.out.println(new File("grades.txt").getAbsolutePath());

        try
        {

            // Check if the file exists
            File file = new File("grades.txt");

            if (!file.exists())
            {

                // No file means no saved data
                return;

            }

            // Create a reader object
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            // Read every line until the end of the file
            while ((line = reader.readLine()) != null)
            {

                // Split the line using comma
                String[] data = line.split(",");

                // Convert String values to appropriate data types
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double marks = Double.parseDouble(data[2]);

                // Create a Student object and add it to the list
                students.add(new Student(id, name, marks));

            }

            // Close the reader after reading all data
            reader.close();

            // Display success message
            System.out.println("Student data loaded successfully.");

        }
        catch (IOException e)
        {

            // Display an error message if file reading fails
            System.out.println("Error reading file: " + e.getMessage());

        }

    }
    // Method to sort students by marks in descending order
    public void sortStudentsByMarks()
    {

        // Check if there are any students
        if (students.isEmpty())
        {

            // Display message if the list is empty
            System.out.println("No students available.");

            return;
        }

        // Sort students in descending order of marks
        Collections.sort(students, new Comparator<Student>()
        {

            @Override
            public int compare(Student student1, Student student2)
            {

                // Compare marks in descending order
                return Double.compare(student2.getMarks(), student1.getMarks());

            }

        });

        // Display heading
        System.out.println("\n===== Students Sorted By Marks =====");

        // Display every student
        for (Student student : students)
        {

            System.out.println(student);

        }

    }

    // Method to display the student with the highest marks
    public void displayTopper()
    {

        // Check if the student list is empty
        if (students.isEmpty())
        {

            // Display a message if there are no students
            System.out.println("No students available.");

            return;
        }

        // Assume the first student is the topper initially
        Student topper = students.get(0);

        // Loop through all students
        for (Student student : students)
        {

            // Check if the current student has more marks
            if (student.getMarks() > topper.getMarks())
            {

                // Update the topper
                topper = student;

            }

        }

        // Display the topper details
        System.out.println("\n===== CLASS TOPPER =====");

        System.out.println("ID    : " + topper.getId());

        System.out.println("Name  : " + topper.getName());

        System.out.println("Marks : " + topper.getMarks());

        System.out.println("Grade : " + topper.getGrade());
    }

    // Method to display students having a specific grade
    public void filterStudentsByGrade(char grade)
    {

        // Check if there are any students
        if (students.isEmpty())
        {

            // Display message if the list is empty
            System.out.println("No students available.");

            return;

        }

        // Variable to check whether any student matches the grade
        boolean found = false;

        // Display heading
        System.out.println("\n===== STUDENTS WITH GRADE " + grade + " =====");

        // Loop through every student
        for (Student student : students)
        {

            // Check if the student's grade matches the entered grade
            if (student.getGrade() == grade)
            {

                // Display the student's details
                System.out.println(student);

                // At least one student was found
                found = true;

            }

        }

        // Display message if no student matches
        if (!found)
        {

            System.out.println("No students found with Grade " + grade);

        }

    }
}





