package ee.taltech.iti0202.generics.cats;

import ee.taltech.iti0202.generics.Animal;

public class SphynxCat extends Animal {

    public SphynxCat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Meeeeeoooooww!");
    }

    @Override
    public String toString() {
        return name;
    }
}
