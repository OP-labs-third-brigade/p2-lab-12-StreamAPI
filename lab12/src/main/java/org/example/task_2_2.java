package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String firstName;
    private String lastName;
    private int studentId;
    private double averageGrade;

    public Student(String firstName, String lastName, int studentId, double averageGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.averageGrade = averageGrade;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (ID: " + studentId + ") - " + averageGrade;
    }
}

class Faculty {
    private String name;
    private List<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}

class Institute {
    private String name;
    private List<Faculty> faculties;

    public Institute(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public List<Student> getAllStudents() {
        return faculties.stream()
                .flatMap(faculty -> faculty.getStudents().stream())
                .collect(Collectors.toList());
    }

    public double getAverageGrade() {
        List<Student> allStudents = getAllStudents();
        return allStudents.stream()
                .mapToDouble(Student::getAverageGrade)
                .average()
                .orElse(0.0);
    }
}

public class task_2_2 {
    public static void main(String[] args) {
        Faculty faculty1 = new Faculty("Факультет комп'ютерних наук");
        Faculty faculty2 = new Faculty("Факультет економіки");

        faculty1.addStudent(new Student("Іван", "Петренко", 1, 85.5));
        faculty1.addStudent(new Student("Марія", "Ковальчук", 2, 78.9));
        faculty2.addStudent(new Student("Олексій", "Бондаренко", 3, 92.3));
        faculty2.addStudent(new Student("Анна", "Лисенко", 4, 67.8));

        Institute kpi = new Institute("KPI");
        kpi.addFaculty(faculty1);
        kpi.addFaculty(faculty2);

        double instituteAverageGrade = kpi.getAverageGrade();

        List<Student> studentsWithHigherGrades = kpi.getAllStudents().stream()
                .filter(student -> student.getAverageGrade() > instituteAverageGrade)
                .collect(Collectors.toList());

        System.out.println("Середній бал у КПІ: " + instituteAverageGrade);
        System.out.println("Студенти з вищими балами, ніж середній бал у КПІ:");
        studentsWithHigherGrades.forEach(System.out::println);
    }
}