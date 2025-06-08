package labprogram4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Course {
    private String courseName;
    private int marks;

    public Course(String courseName, int marks) {
        this.courseName = courseName;
        this.marks = marks;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMarks() {
        return marks;
    }
}

class Student {
    private String name;
    private String program;
    private String semester;
    private List<Course> courses;

    public Student(String name, String program, String semester) {
        this.name = name;
        this.program = program;
        this.semester = semester;
        this.courses = new ArrayList<>();
    }

    public void registerCourse(String courseName, int marks) {
        courses.add(new Course(courseName, marks));
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }

    public String getSemester() {
        return semester;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Course> getFailingCourses() {
        List<Course> failCourses = new ArrayList<>();
        for (Course c : courses) {
            if (c.getMarks() < 40) {
                failCourses.add(c);
            }
        }
        return failCourses;
    }
}

public class StudentCourseInfo {
    public static void main(String[] args) {
        System.out.println("Student details");
        // Create some students with courses and marks
        Student s1 = new Student("John Doe", "Computer Science", "Semester 1");
        s1.registerCourse("Mathematics", 75);
        s1.registerCourse("Physics", 35);
        s1.registerCourse("Chemistry", 65);

        Student s2 = new Student("Jane Smith", "Information Technology", "Semester 2");
        s2.registerCourse("Networking", 38);
        s2.registerCourse("Databases", 55);
        s2.registerCourse("Software Engg", 42);

        List<Student> students = Arrays.asList(s1, s2);

        // 1. Retrieve and display the name of the student, program, semester, and courses registered
        System.out.println("Student Details and Courses Registered:");
        for (Student s : students) {
            System.out.println("student details");
            System.out.println("Name: " + s.getName());
            System.out.println("Program: " + s.getProgram());
            System.out.println("Semester: " + s.getSemester());
            System.out.println("Courses Registered:");
            for (Course c : s.getCourses()) {
                System.out.println(" - " + c.getCourseName() + " (Marks: " + c.getMarks() + ")");
            }
            System.out.println();
        }

        // 2. Retrieve marks of students and respective courses with marks less than 40
        System.out.println("Students with marks less than 40:");
        for (Student s : students) {
            List<Course> failCourses = s.getFailingCourses();
            if (!failCourses.isEmpty()) {
                System.out.println("Student: " + s.getName());
                for (Course c : failCourses) {
                    System.out.println(" Course: " + c.getCourseName() + ", Marks: " + c.getMarks());
                }
                System.out.println();
            }
        }
    }
}

