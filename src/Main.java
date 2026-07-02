public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        // Create the StudentManager object

        // Load previously saved student data
        manager.loadFromFile();

        //manager.addStudent(new Student(101, "Bhavya", 92));
        //manager.addStudent(new Student(102, "Rahul", 90));
        //manager.addStudent(new Student(103, "Priya", 76));
        //manager.addStudent(new Student(104, "Aman", 67));
        //manager.addStudent(new Student(105, "Rohan", 25));

        manager.viewStudents();

        System.out.println();

        // Search for the student with ID 999
        //Student student = manager.searchStudent(999);

        // Check if the student exists
        /*if (student != null) {

            // Display the student's details
            System.out.println("Found: " + student);

        } else {

            // Display a message if no student is found
            System.out.println("Student not found.");

        }*/

        //manager.updateMarks(103, 95);

        //System.out.println();

        //manager.viewStudents();

        //manager.deleteStudent(999);

        //System.out.println();

        //manager.viewStudents();

        // Display the statistics of all students
        manager.displayStatistics();


        // Save all students before closing the application
        manager.saveToFile();
    }
}

