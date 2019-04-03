package ee.taltech.iti0202.kt2.university.student;

public class Student {

    private String name;
    private Integer eap;
    private String university;

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

    public Integer getEap() {
        return eap;
    }

    public void setEap(Integer eap) {
        this.eap = eap;
    }

    @Override
    public String toString() {
        return name + " (" + eap + ")";
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
