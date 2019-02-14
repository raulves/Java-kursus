package ee.taltech.iti0202.socialnetwork.user;
public class User {
    String name;
    Integer age;

    public User(String name) {
        this.name = name;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

}