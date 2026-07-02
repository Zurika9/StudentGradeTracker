public class Student
{
    private int id;
    private String name;
    private double marks;
    private char grade;

    public Student(int id, String name, double marks)
    {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.grade = calculateGrade();
    }

    private char calculateGrade()
    {

        if (marks >= 90)
            return 'A';
        else if (marks >= 80)
            return 'B';
        else if (marks >= 70)
            return 'C';
        else if (marks >= 60)
            return 'D';
        else
            return 'F';
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public double getMarks()
    {
        return marks;
    }

    // Method to return the student's grade
        public char getGrade()
        {

        // Marks 90 and above
        if (marks >= 90)
            return 'A';

            // Marks 80 to 89
        else if (marks >= 80)
            return 'B';

            // Marks 70 to 79
        else if (marks >= 70)
            return 'C';

            // Marks 40 to 69
        else if (marks >= 40)
            return 'D';

            // Below 40
        else
            return 'F';
    }


    public void setName(String name)
    {
        this.name = name;
    }

    public void setMarks(double marks)
    {
        this.marks = marks;
        this.grade = calculateGrade();
    }

    // Return a formatted string containing all student details
    @Override
    public String toString()
    {

        return "ID: " + id +
                " | Name: " + name +
                " | Marks: " + marks +
                " | Grade: " + getGrade();

    }

    }
