package ee.taltech.iti0202.generics.foods;

public class Meat extends Food {
    private String name = "MEAT";

    public String getName() {
        return name;
    }

    @Override
    public String foodName() {
        return name;
    }
}
