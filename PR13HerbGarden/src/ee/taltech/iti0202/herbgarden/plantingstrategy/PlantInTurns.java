package ee.taltech.iti0202.herbgarden.plantingstrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlantInTurns implements PlantingStrategy {
    @Override
    public String[][] plantHerbs(int height, int width, Map<String, Integer> plants) {

        Map<String, Integer> sortedByValues = plants.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        int totalPlants = sortedByValues.values().stream().mapToInt(nr -> nr).sum();
        List<String> allPlants = new ArrayList<>();
        String[][] plantedHerbs = new String[height][width];

        for (int i = 0; i < totalPlants; i++) {
            for (String plant : sortedByValues.keySet()) {
                allPlants.add(plant);
                sortedByValues.put(plant, sortedByValues.get(plant) - 1);
                if (sortedByValues.get(plant) == 0) {
                    sortedByValues.remove(plant);
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                plantedHerbs[i][j] = allPlants.get(0);
                allPlants.remove(0);
            }
        }







        // Hakkan sorditud Mapi läbi käima ning iga kord muudan koguse ära taime juures
        // Kui kogus 0, siis skipi.
        return plantedHerbs;
    }
}
