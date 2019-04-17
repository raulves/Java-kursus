package ee.taltech.iti0202.birdwatching.bird;

public class Bird {

    public enum Age {
        ADULT, YOUNGLING
    }

    public enum Sex {
        MALE, FEMALE, UNKNOWN
    }

    private String species;
    private double weight;
    private double wingspan;
    private Age age;
    private Sex sex;

    public Bird(String species, double weight, double wingspan, Sex sex, Age age) {
        this.species = species;
        this.weight = weight;
        this.wingspan = wingspan;
        this.age = age;
        this.sex = sex;
    }

    public String getSpecies() {
        return species;
    }

    public double getWeight() {
        return weight;
    }

    public double getWingspan() {
        return wingspan;
    }

    public Age getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }


    @Override
    public String toString() {
        return species;
    }
}
