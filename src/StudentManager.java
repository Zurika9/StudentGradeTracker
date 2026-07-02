import java.util.ArrayList;

public class StudentManager {

    // List that stores all students
    private ArrayList<Student> students;

    // Constructor
    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void viewStudents() {

        if (students.isEmpty()) {

            System.out.println("No students found.");

            return;

        }

        System.out.println("\n===== Student List =====");

        for (Student student : students) {

            System.out.println(student);

        }

    }

    public Student searchStudent(int id) {

        for(Student student : students){

            if(student.getId()==id){

                return student;

            }

        }

        return null;

    }

    public boolean deleteStudent(int id){

        Student student = searchStudent(id);

        if(student!=null){

            students.remove(student);

            return true;

        }

        return false;

    }

    public boolean updateMarks(int id,double marks){

        Student student = searchStudent(id);

        if(student!=null){

            student.setMarks(marks);

            return true;

        }

        return false;

    }

    // Method to display statistics of all students
    public void displayStatistics() {

        // Check if there are any students in the list
        if (students.isEmpty()) {

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
        for (Student student : students) {

            // Get the current student's marks
            double marks = student.getMarks();

            // Add marks to the running total
            totalMarks += marks;

            // Check if current marks are greater than highest marks
            if (marks > highestMarks) {

                highestMarks = marks;

            }

            // Check if current marks are lower than lowest marks
            if (marks < lowestMarks) {

                lowestMarks = marks;

            }

            // Students with 40 or more marks are considered passed
            if (marks >= 40) {

                passCount++;

            } else {

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


}
