package ee.taltech.iti0202.herbgarden.plantingstrategy;

import java.util.List;
import java.util.Map;

public class PlantInRows extends AbstractPlanting implements PlantingStrategy {
    @Override
    public String[][] plantHerbs(int height, int width, Map<String, Integer> plants) {
        Map<String, Integer> sortedByValues = sortMapToReverseOrder(plants);

        List<String> allPlants = sortedList(sortedByValues);


        return createArray(height, width, allPlants);
    }
}
