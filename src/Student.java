public class Student
{

    private int id;
    private String name;

    private double english;
    private double mathematics;
    private double science;
    private double computer;
    private double social;

    // Constructor
    public Student(
            int id,
            String name,
            double english,
            double mathematics,
            double science,
            double computer,
            double social)
    {

        this.id = id;
        this.name = name;
        this.english = english;
        this.mathematics = mathematics;
        this.science = science;
        this.computer = computer;
        this.social = social;
    }

    // Getters
    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public double getEnglish()
    {
        return english;
    }

    public double getMathematics()
    {
        return mathematics;
    }

    public double getScience()
    {
        return science;
    }

    public double getComputer()
    {
        return computer;
    }

    public double getSocial()
    {
        return social;
    }

    // Total Marks
    public double getTotalMarks()
    {
        return english + mathematics + science + computer + social;
    }

    // Average Marks
    public double getAverageMarks()
    {
        return getTotalMarks() / 5;
    }

    // Grade
    public char getGrade()
    {

        double average = getAverageMarks();

        if (average >= 90)
            return 'A';
        else if (average >= 80)
            return 'B';
        else if (average >= 70)
            return 'C';
        else if (average >= 60)
            return 'D';
        else
            return 'F';
    }

    // Update name
    public void setName(String name)
    {
        this.name = name;
    }

    // Update all subject marks
    public void setMarks(
            double english,
            double mathematics,
            double science,
            double computer,
            double social)
    {

        this.english = english;
        this.mathematics = mathematics;
        this.science = science;
        this.computer = computer;
        this.social = social;
    }

    @Override
    public String toString()
    {

        return "ID: " + id +
                " | Name: " + name +
                " | English: " + english +
                " | Mathematics: " + mathematics +
                " | Science: " + science +
                " | Computer: " + computer +
                " | Social: " + social +
                " | Average: " + String.format("%.2f", getAverageMarks()) +
                " | Grade: " + getGrade();
    }
}