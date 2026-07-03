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
    // Method to check whether a student ID already exists
    public boolean isDuplicateId(int id)
    {

        // Loop through every student in the list
        for (Student student : students) {

            // Check if the entered ID matches an existing student's ID
            if (student.getId() == id) {

                // Duplicate ID found
                return true;

            }

        }

        // No duplicate ID found
        return false;

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

    // Method to display student rankings
    public void displayRankings()
    {

        // Check whether any students exist
        if (students.isEmpty())
        {

            System.out.println("No students available.");

            return;

        }

        // Sort students in descending order of marks
        students.sort((student1, student2) ->
                Double.compare(student2.getMarks(), student1.getMarks()));

        // Display heading
        System.out.println("\n===== STUDENT RANKINGS =====");

        // Variable to store the rank
        int rank = 1;

        // Display each student with rank
        for (Student student : students)
        {

            System.out.println("Rank " + rank);
            System.out.println(student);
            System.out.println();

            // Move to the next rank
            rank++;

        }

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

    // Method to display the distribution of grades in the class
    public void displayGradeDistribution()
    {

        // Check if there are any students
        if (students.isEmpty())
        {

            // Display a message if the list is empty
            System.out.println("No students available.");

            return;

        }

        // Variables to count each grade
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        // Loop through every student
        for (Student student : students)
        {

            // Count grades using switch statement
            switch (student.getGrade())
            {

                case 'A':
                    countA++;
                    break;

                case 'B':
                    countB++;
                    break;

                case 'C':
                    countC++;
                    break;

                case 'D':
                    countD++;
                    break;

                case 'F':
                    countF++;
                    break;

            }

        }

        // Display heading
        System.out.println("\n========== GRADE DISTRIBUTION ==========\n");

        // Display each grade with a bar chart
        System.out.print("Grade A : " + countA + "  ");
        for (int i = 0; i < countA; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("Grade B : " + countB + "  ");
        for (int i = 0; i < countB; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("Grade C : " + countC + "  ");
        for (int i = 0; i < countC; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("Grade D : " + countD + "  ");
        for (int i = 0; i < countD; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("Grade F : " + countF + "  ");
        for (int i = 0; i < countF; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        System.out.println("\n========================================");

    }

    // Method to export student data to a CSV file
    public void exportToCSV()
    {

        try
        {

            // Create a writer for the CSV file
            BufferedWriter writer = new BufferedWriter(new FileWriter("student_report.csv"));

            // Write the column headings
            writer.write("Rank,ID,Name,Marks,Grade");
            writer.newLine();

            // Sort students by marks in descending order
            students.sort((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()));

            // Variable to store the rank
            int rank = 1;

            // Write every student's data
            for (Student student : students)
            {

                writer.write(
                        rank + "," +
                                student.getId() + "," +
                                student.getName() + "," +
                                student.getMarks() + "," +
                                student.getGrade()
                );

                writer.newLine();

                rank++;

            }

            // Close the writer
            writer.close();

            System.out.println("Student report exported successfully to student_report.csv");

        }
        catch (IOException e)
        {

            System.out.println("Error exporting CSV file: " + e.getMessage());

        }

    }


    // Method to search students by name
    public void searchStudentByName(String searchName) {

        // Variable to check whether a student was found
        boolean found = false;

        // Display heading
        System.out.println("\n===== SEARCH RESULTS =====");

        // Convert search text to lowercase
        searchName = searchName.toLowerCase();

        // Loop through every student
        for (Student student : students) {

            // Check whether the student's name contains the search text
            if (student.getName().toLowerCase().contains(searchName)) {

                // Display the student
                System.out.println(student);

                // Student found
                found = true;

            }

        }

        // Display message if no student matches
        if (!found) {

            System.out.println("No students found.");

        }

    }

}





