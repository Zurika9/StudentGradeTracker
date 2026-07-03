# Student Grade Tracker

A Java console application to manage student grades.

## Features

- Add Student
- View Students
- Search Student
- Update Student Grade
- Delete Student
- Calculate Average Score
- Find Highest and Lowest Scores
- Assign Letter Grades (A–F)
- Sort Students by Marks
- Save Data to `grades.txt`

## Milestone 4 - File Handling

### Features Added
- Save student records to `grades.txt`
- Load student records automatically on startup
- Persistent storage using Java File I/O
- Exception handling using try-catch
- CSV-based storage format

### Java Concepts Learned
- FileReader
- FileWriter
- BufferedReader
- BufferedWriter
- IOException
- Data Persistence

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- File Handling
- IntelliJ IDEA
- Git & GitHub

## Milestone 5 - Menu-Driven Console Application

### Features Added
- Interactive console menu
- User input using Scanner
- Add Student through the menu
- View Students through the menu
- Exit option with automatic data saving

### Java Concepts Learned
- Scanner
- while loop
- switch-case
- User input handling
- Menu-driven programming


## Milestone 5.1 - Interactive Menu

### Features Added
- Interactive console menu using `Scanner`
- Add Student
- View Students
- Search Student
- Update Student Marks
- Delete Student
- View Class Statistics
- Save student data
- Exit with automatic data saving

### Java Concepts Learned
- Scanner
- while loop
- switch-case
- Object references
- CRUD operations
- Menu-driven programming

## Milestone 6 - Advanced Features

### Feature 1 - Student Sorting

Students can now be sorted in descending order based on their marks.

**Concepts Learned**
- Collections.sort()
- Comparator
- Custom object sorting
- Descending order sorting

### Feature 2 - Class Topper

Displays the student with the highest marks in the class.

**Concepts Learned**
- Traversing an ArrayList
- Finding the maximum value
- Object references
- Encapsulation using getter methods

### Feature 3 - Filter Students by Grade

Users can filter and display students based on their grades (A, B, C, D, F).

**Concepts Learned**
- Filtering data from an ArrayList
- Character comparison
- Boolean flags
- User input handling

## Feature 4 - Input Validation

### Added

- Menu input validation using try-catch
- Duplicate Student ID validation
- Student name validation
- Marks range validation (0-100)
- Non-numeric marks handling

### Feature 5 – Search Student by Name

- Search students using full or partial names
- Case-insensitive search
- Displays all matching student records
- Shows a message when no matching student is found

## Feature 6 – Student Rankings
- Displays students ranked by marks
- Uses descending order sorting
- Shows rank numbers for each student

## Feature 7 – Grade Distribution

### Overview
Implemented a Grade Distribution Report that analyzes student grades and displays the number of students in each grade category using a simple console-based bar chart.

### Features
- Counts students with Grades A, B, C, D, and F.
- Displays grade-wise distribution.
- Generates a console bar chart using '*' characters.
- Handles empty student lists gracefully.
- Automatically reflects changes after adding, updating, or deleting students.

### Sample Output

```text
========== GRADE DISTRIBUTION ==========

Grade A : 4  ****
Grade B : 1  *
Grade C : 0
Grade D : 0
Grade F : 0

========================================
```

### Concepts Used
- Enhanced for loop
- Switch statement
- Conditional logic
- Console visualization
- Report generation
- Object-Oriented Programming (OOP)

### Files Updated
- StudentManager.java
- Main.java
- README.md


## Project Structure

```
StudentGradeTracker/
│
├── src/
├── grades.txt
├── README.md
└── .gitignore
```

## How to Run

1. Clone the repository.
2. Open it in IntelliJ IDEA.
3. Run `Main.java`.

## Author

Bhavya Shukla