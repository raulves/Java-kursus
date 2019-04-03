package ee.taltech.iti0202.kt2.university;

import ee.taltech.iti0202.kt2.university.Course;
import ee.taltech.iti0202.kt2.university.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class University {

    private String name;
    private List<Student> studentInUniversity = new ArrayList<>();
    private List<Course> coursesInUniversity = new ArrayList<>();
    private List<Course> finishedCourses = new ArrayList<>();

    public University(String name) {

        this.name = name;
    }

    public Course createCourse(String name, Integer eap) {
        return new Course(name, this, eap);
    }

    public boolean addStudent(Student student) {
        if (!studentInUniversity.contains(student)) {
            studentInUniversity.add(student);
            student.setUniversity(this);
            return true;
        }
        return false;
    }

    public Optional<Course> createCourse(String name, int eap) {
        return Optional.empty();
    }

    public List<Student> getStudents() {
        return studentInUniversity;
    }

    public List<Course> getCourses() {
        return coursesInUniversity;
    }

    public String getName() {
        return name;
    }

    public List<Course> getFinishedCourses() {
        return finishedCourses;
    }

    public List<Student> getStudentsOrderedByResults() {
        List<Student> result = new ArrayList<>();

        return result;
    }
}
