package ee.taltech.iti0202.herbgarden.gardener;

import ee.taltech.iti0202.herbgarden.plantingstrategy.PlantingStrategy;

import java.util.Map;

public class Gardener {

    private String name;
    private PlantingStrategy strategy;

    public Gardener(String name, PlantingStrategy strategy) {

        this.name = name;
        this.strategy = strategy;
    }

    public String[][] plantHerbs(int height, int width, Map<String, Integer> plants) {
        String[][] plantedHerbs = new String[height][width];
        return plantedHerbs;

    }

    public String getName() {
        return name;
    }

    public PlantingStrategy getStrategy() {
        return strategy;
    }
}
