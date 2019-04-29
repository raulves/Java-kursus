package ee.taltech.iti0202.herbgarden.plantingstrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlantInRows extends AbstractPlanting implements PlantingStrategy {
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

        return createArray(height, width, allPlants);
    }
}
