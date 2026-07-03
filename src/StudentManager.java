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

    // Add a student
    public void addStudent(Student student)
    {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Display all students
    public void viewStudents()
    {
        if (students.isEmpty())
        {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n============= STUDENT LIST =============");

        for (Student student : students)
        {
            System.out.println(student);
        }

        System.out.println("========================================");
    }

    // Search by ID
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

    // Check duplicate IDs
    public boolean isDuplicateId(int id)
    {
        for (Student student : students)
        {
            if (student.getId() == id)
            {
                return true;
            }
        }

        return false;
    }

    // Delete student
    public void deleteStudent(int id)
    {
        for (Student student : students)
        {
            if (student.getId() == id)
            {
                students.remove(student);

                System.out.println("Student deleted successfully.");

                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Method to update all subject marks
    public void updateMarks(
            int id,
            double english,
            double mathematics,
            double science,
            double computer,
            double social)
    {

        for (Student student : students)
        {

            if (student.getId() == id)
            {

                student.setMarks(
                        english,
                        mathematics,
                        science,
                        computer,
                        social);

                System.out.println("Student marks updated successfully.");

                return;

            }

        }

        System.out.println("Student not found.");

    }

    // Method to display class statistics
    public void displayStatistics()
    {

        if (students.isEmpty())
        {

            System.out.println("No students available.");
            return;

        }

        double totalAverage = 0;

        double highestAverage = students.get(0).getAverageMarks();
        double lowestAverage = students.get(0).getAverageMarks();

        int passCount = 0;
        int failCount = 0;

        for (Student student : students)
        {

            double average = student.getAverageMarks();

            totalAverage += average;

            if (average > highestAverage)
            {
                highestAverage = average;
            }

            if (average < lowestAverage)
            {
                lowestAverage = average;
            }

            if (student.getGrade() != 'F')
            {
                passCount++;
            }
            else
            {
                failCount++;
            }

        }

        double classAverage = totalAverage / students.size();

        System.out.println("\n========== CLASS STATISTICS ==========");

        System.out.println("Total Students : " + students.size());

        System.out.printf("Class Average  : %.2f%n", classAverage);

        System.out.printf("Highest Average: %.2f%n", highestAverage);

        System.out.printf("Lowest Average : %.2f%n", lowestAverage);

        System.out.println("Pass Count     : " + passCount);

        System.out.println("Fail Count     : " + failCount);

        System.out.printf("Pass Percentage: %.2f%%%n",
                (passCount * 100.0) / students.size());

        System.out.println("======================================");

    }


    // Method to save all students into grades.txt
    public void saveToFile()
    {

        try
        {

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("grades.txt"));

            for (Student student : students)
            {

                writer.write(
                        student.getId() + "," +
                                student.getName() + "," +
                                student.getEnglish() + "," +
                                student.getMathematics() + "," +
                                student.getScience() + "," +
                                student.getComputer() + "," +
                                student.getSocial()
                );

                writer.newLine();

            }

            writer.close();

            System.out.println("Student data saved successfully.");

        }
        catch (IOException e)
        {

            System.out.println("Error saving file: " + e.getMessage());

        }

    }

    // Method to load students from grades.txt
    public void loadFromFile()
    {

        System.out.println(new File("grades.txt").getAbsolutePath());

        try
        {

            File file = new File("grades.txt");

            if (!file.exists())
            {

                return;

            }

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null)
            {

                String[] data = line.split(",");

                if (data.length != 7)
                {

                    continue;

                }

                int id = Integer.parseInt(data[0]);

                String name = data[1];

                double english = Double.parseDouble(data[2]);

                double mathematics = Double.parseDouble(data[3]);

                double science = Double.parseDouble(data[4]);

                double computer = Double.parseDouble(data[5]);

                double social = Double.parseDouble(data[6]);

                students.add(
                        new Student(
                                id,
                                name,
                                english,
                                mathematics,
                                science,
                                computer,
                                social
                        )
                );

            }

            reader.close();

            System.out.println("Student data loaded successfully.");

        }
        catch (IOException e)
        {

            System.out.println("Error reading file: " + e.getMessage());

        }

    }

    // Method to sort students by average marks
    public void sortStudentsByMarks()
    {

        if (students.isEmpty())
        {
            System.out.println("No students available.");
            return;
        }

        students.sort((student1, student2) ->
                Double.compare(
                        student2.getAverageMarks(),
                        student1.getAverageMarks()));

        System.out.println("\n========== STUDENTS SORTED BY AVERAGE ==========");

        for (Student student : students)
        {
            System.out.println(student);
        }

    }

    // Method to display topper
    public void displayTopper()
    {

        if (students.isEmpty())
        {

            System.out.println("No students available.");

            return;

        }

        Student topper = students.get(0);

        for (Student student : students)
        {

            if (student.getAverageMarks() > topper.getAverageMarks())
            {

                topper = student;

            }

        }

        System.out.println("\n========== CLASS TOPPER ==========");

        System.out.println("ID       : " + topper.getId());

        System.out.println("Name     : " + topper.getName());

        System.out.printf("Average  : %.2f%n",
                topper.getAverageMarks());

        System.out.println("Grade    : " + topper.getGrade());

    }

    // Method to display rankings
    public void displayRankings()
    {

        if (students.isEmpty())
        {

            System.out.println("No students available.");

            return;

        }

        students.sort((student1, student2) ->
                Double.compare(
                        student2.getAverageMarks(),
                        student1.getAverageMarks()));

        System.out.println("\n========== STUDENT RANKINGS ==========");

        int rank = 1;

        for (Student student : students)
        {

            System.out.println("--------------------------------------");

            System.out.println("Rank : " + rank);

            System.out.println(student);

            rank++;

        }

        System.out.println("--------------------------------------");

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
    // Method to export student report to CSV
    public void exportToCSV()
    {

        try
        {

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("student_report.csv"));

            writer.write(
                    "Rank,ID,Name,English,Mathematics,Science,Computer,Social,Total,Average,Grade");

            writer.newLine();

            students.sort((student1, student2) ->
                    Double.compare(
                            student2.getAverageMarks(),
                            student1.getAverageMarks()));

            int rank = 1;

            for (Student student : students)
            {

                writer.write(
                        rank + "," +
                                student.getId() + "," +
                                student.getName() + "," +
                                student.getEnglish() + "," +
                                student.getMathematics() + "," +
                                student.getScience() + "," +
                                student.getComputer() + "," +
                                student.getSocial() + "," +
                                student.getTotalMarks() + "," +
                                String.format("%.2f", student.getAverageMarks()) + "," +
                                student.getGrade());

                writer.newLine();

                rank++;

            }

            writer.close();

            System.out.println("Student report exported successfully.");

        }
        catch (IOException e)
        {

            System.out.println("Error exporting CSV: " + e.getMessage());

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





