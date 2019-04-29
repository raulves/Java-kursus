package ee.taltech.iti0202.herbgarden.plantingstrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PlantInTurns extends AbstractPlanting implements PlantingStrategy {
    @Override
    public String[][] plantHerbs(int height, int width, Map<String, Integer> plants) {

        Map<String, Integer> sortedByValues = sortMapToReverseOrder(plants);

        int totalPlants = sortedByValues.values().stream().mapToInt(nr -> nr).sum();
        List<String> allPlants = new ArrayList<>();

        for (int i = 0; i < totalPlants; i++) {
            for (String plant : sortedByValues.keySet()) {
                allPlants.add(plant);
                sortedByValues.put(plant, sortedByValues.get(plant) - 1);
                if (sortedByValues.get(plant) == 0) {
                    sortedByValues.remove(plant);
                }
            }
        }


        return createArray(height, width, allPlants);
    }
}
