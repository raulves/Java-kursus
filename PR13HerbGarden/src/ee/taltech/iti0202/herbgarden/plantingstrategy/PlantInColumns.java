package ee.taltech.iti0202.herbgarden.plantingstrategy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlantInColumns implements PlantingStrategy {
    @Override
    public String[][] plantHerbs(int height, int width, Map<String, Integer> plants) {
        Map<String, Integer> sorted =
                plants.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        List<String> allPlants = new ArrayList<>();

        for (String plant : sorted.keySet()) {
            for (int i = 0; i < sorted.get(plant); i++) {
                allPlants.add(plant);
            }
        }

        String[][] plantedHerbs = new String[height][width];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                plantedHerbs[j][i] = allPlants.get(0);
                allPlants.remove(0);
            }
        }
        return plantedHerbs;
    }
}
