package ee.taltech.iti0202.herbgarden.plantingstrategy;

import java.util.*;
import java.util.stream.Collectors;

public class PlantInRows implements PlantingStrategy {
    @Override
    public String[][] plantHerbs(int height, int width, Map<String, Integer> plants) {
        Map<String, Integer> sortedByValues = plants.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        List<String> allPlants = new ArrayList<>();

        for (String plant : sortedByValues.keySet()) {
            for (int i = 0; i < sortedByValues.get(plant); i++) {
                allPlants.add(plant);
            }
        }

        String[][] plantedHerbs = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                plantedHerbs[i][j] = allPlants.get(0);
                allPlants.remove(0);
            }
        }
        return plantedHerbs;
    }
}
