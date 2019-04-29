package ee.taltech.iti0202.herbgarden.plantingstrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlanting {

    public String[][] createArray(Integer height, Integer width, List<String> plants) {
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
}
