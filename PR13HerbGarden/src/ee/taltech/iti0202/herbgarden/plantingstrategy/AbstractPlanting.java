package ee.taltech.iti0202.herbgarden.plantingstrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractPlanting {

    protected String[][] createArray(Integer height, Integer width, List<String> plants) {
        List<String> allPlants = plants;
        String[][] plantedHerbs = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println(allPlants.get(0));
                plantedHerbs[i][j] = allPlants.get(0);
                allPlants.remove(0);
            }
        }
        return plantedHerbs;
    }

    protected List<String> sortedList(Map<String, Integer> plants) {
        List<String> allPlants = new ArrayList<>();

        for (String plant : plants.keySet()) {
            for (int i = 0; i < plants.get(plant); i++) {
                allPlants.add(plant);
            }
        }
        return allPlants;
    }

    protected Map<String, Integer> sortMapToReverseOrder(Map<String, Integer> map) {
        Map<String, Integer> sortedByValues = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return sortedByValues;
    }
}
