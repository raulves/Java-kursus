package ee.taltech.iti0202.generics;

import ee.taltech.iti0202.generics.foods.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnimalBox<T extends Animal> {

    // private List<T> animalInBox = new ArrayList<>();
    private T animalBox;

    public void put(T animal) {
        // animalInBox.add(animal);
        if (animalBox == null) {
            animalBox = animal;
        }

    }

    public void sound() {
        animalBox.sound();
    }

    public void feed(Food food) {
        if (animalBox != null) {
            String result = animalBox + " was fed with " + food.foodName();
            System.out.println(result);
        }
    }

    public Optional<T> getAnimal() {
        return Optional.ofNullable(animalBox);
    }

}
