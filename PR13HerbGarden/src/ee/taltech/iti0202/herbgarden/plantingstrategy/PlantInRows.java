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
        Map<String, Integer> sortedByValues = sortMapToReverseOrder(plants);

        List<String> allPlants = sortedList(sortedByValues);


        return createArray(height, width, allPlants);
    }
}
