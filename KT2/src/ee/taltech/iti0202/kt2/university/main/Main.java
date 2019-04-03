/*
package ee.taltech.iti0202.kt2.university.main;

import ee.taltech.iti0202.kt2.university.course.Course;
import ee.taltech.iti0202.kt2.university.student.Student;
import ee.taltech.iti0202.kt2.university.university.University;

public class Main {
    public static void main(String[] args) {
        University talTech = new University("TalTech");
        Student mari = new Student("Mari");
        Student mati = new Student("Mati");
        talTech.addStudent(mari);
        System.out.println(talTech.addStudent(mati));  // true
        System.out.println(talTech.addStudent(mati));  // false

        Course java = talTech.createCourse("Programmeerimise põhikursus", 6).get();
        System.out.println(java);  // TalTech: Programmeerimise põhikursus (6)
        System.out.println(talTech.createCourse("Programmeerimise põhikursus", 7));  // Optional.empty
        System.out.println(talTech.createCourse("Java", 0));  // Optional.empty
        System.out.println(talTech.createCourse("Java", 6));  // Optional[TalTech: Java (6)]
    }


}
*/
