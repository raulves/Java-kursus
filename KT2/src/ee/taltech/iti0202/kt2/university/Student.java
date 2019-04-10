package ee.taltech.iti0202.kt2.university;

public class Student {

    private String name;
    private Integer eap;
    private University university;

    public Student(String name) {
        this.eap = 0;
        this.name = name;
        this.university = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEap() {
        return eap;
    }

    public void setEap(Integer eap) {
        this.eap = eap;
    }

    @Override
    public String toString() {
        return name + " (" + eap + ")";
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
