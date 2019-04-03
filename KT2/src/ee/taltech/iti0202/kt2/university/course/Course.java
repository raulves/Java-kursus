package ee.taltech.iti0202.kt2.university.course;

import ee.taltech.iti0202.kt2.university.student.Student;
import ee.taltech.iti0202.kt2.university.university.University;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseName;
    private University nameOfUniversity;
    private Integer eap;
    private List<Student> studentsInCourse = new ArrayList<>();
    private boolean hasFinished;

    public Course(String courseName, University nameOfUniv, Integer eap) {
        this.hasFinished = false;
        this.courseName = courseName;
        this.nameOfUniversity = nameOfUniv;
        this.eap = eap;
    }

    public boolean addStudent(Student student) {
        // Lisan veel, kas ülikoolis
        if (student.getUniversity() != null && !studentsInCourse.contains(student)) {
            studentsInCourse.add(student);
            return true;
        }

        return false;
    }

    public List<Student> getStudents() {
        return studentsInCourse;
    }
    public boolean finish() {
        if (!hasFinished) {
            return false;
        }

        return true;
    }

    public boolean isFinished() {
        return hasFinished;
    }

    @Override
    public String toString() {
        return nameOfUniversity + ": " + courseName + " (" + eap + ")";
    }
}
