package ee.taltech.iti0202.birdwatching.bird;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BirdDataController {

    private List<Bird> birds = new ArrayList<>();

    public List<Bird> getBirds() {
        return birds;
    }

    public void readBirdDataFromCsvFile(String filename) throws BirdDataException {

        List<String> lines;
        try {

            // Path path = Paths.get(filename);
            // System.out.println(path);
            // System.out.println(Files.lines(path));
            lines = Files.readAllLines(Paths.get(filename));
            for (String line : lines) {
                String[] splittedLine = line.split(",");

                birds.add(new BirdBuilder()
                        .setSpecies(splittedLine[0])
                        .setWeight(Double.parseDouble(splittedLine[1]))
                        .setWingspan(Double.parseDouble(splittedLine[2]))
                        .setSex(Bird.Sex.valueOf(splittedLine[3].toUpperCase()))
                        .setAge(Bird.Age.valueOf(splittedLine[4].toUpperCase())).createBird());
            }

        } catch (IOException e) {
            throw new BirdDataException("Error handling bird data", e);
        }

    }


}
