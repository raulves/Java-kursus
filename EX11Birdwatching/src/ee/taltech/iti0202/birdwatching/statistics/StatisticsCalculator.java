package ee.taltech.iti0202.birdwatching.statistics;
import ee.taltech.iti0202.birdwatching.bird.Bird;
import ee.taltech.iti0202.birdwatching.bird.BirdDataController;
import ee.taltech.iti0202.birdwatching.filter.BirdFilter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class StatisticsCalculator {

    private BirdDataController controller;
    private BirdFilter filter;

    public StatisticsCalculator(BirdDataController controller, BirdFilter filter) {
        this.controller = controller;
        this.filter = filter;
    }

    public void prepareBirdData(String filename) {
        controller.readBirdDataFromCsvFile(filename);
    }

    public List<Bird> getBirds() {
        return controller.getBirds();
    }

    public long countBirds() {
        return getBirds().stream().count();
    }

    public OptionalDouble findAverageWeight() {

        if (countBirds() > 0) {
            return getBirds().stream().map(bird -> bird.getWeight()).mapToDouble(n -> n).average();
        } else {
            return OptionalDouble.empty();
        }
    }

    public OptionalDouble findMinWeight() {
        if (countBirds() > 0) {
            return getBirds().stream().map(bird -> bird.getWeight()).mapToDouble(n -> n).min();
        } else {
            return OptionalDouble.empty();
        }
    }

    public OptionalDouble findMaxWeight()  {
        if (countBirds() > 0) {
            return getBirds().stream().map(bird -> bird.getWeight()).mapToDouble(n -> n).max();
        } else {
            return OptionalDouble.empty();
        }
    }

    public OptionalDouble findAverageWingspan() {
        if (countBirds() > 0) {
            return getBirds().stream().map(bird -> bird.getWingspan()).mapToDouble(n -> n).average();
        } else {
            return OptionalDouble.empty();
        }
    }

    public OptionalDouble findMinWingspan() {
        if (countBirds() > 0) {
            return getBirds().stream().map(bird -> bird.getWingspan()).mapToDouble(n -> n).min();
        } else {
            return OptionalDouble.empty();
        }
    }

    public OptionalDouble findMaxWingspan() {
        if (countBirds() > 0) {
            return getBirds().stream().map(bird -> bird.getWingspan()).mapToDouble(n -> n).max();
        } else {
            return OptionalDouble.empty();
        }
    }

    public List<Double> getWingspanData() {
        return getBirds().stream().map(bird -> bird.getWingspan()).collect(Collectors.toList());
    }

    public List<Double> getWeightDataInGrams() {
        return getBirds().stream().map(bird -> bird.getWeight() * 1000).collect(Collectors.toList());
    }

    public List<Bird> getSample(int sampleSize) {
        return getBirds().stream().limit(sampleSize).collect(Collectors.toList());
    }

    public Optional<Bird> findSampleBird(String species, Bird.Sex sex, Bird.Age age) {
        return getBirds().stream().filter(bird -> bird.getSpecies().equals(species) && bird.getSex().equals(sex)
                && bird.getAge().equals(age)).findFirst();

    }

    public Set<String> getAllEncounteredSpecies() {
        return getBirds().stream().map(bird -> bird.getSpecies()).distinct().collect(Collectors.toSet());
    }

    public List<Bird> getLargeBirds(int skipCount) {
        List<Bird> lB = new ArrayList<>();
        return lB;
    }

    public Map<String, List<Bird>> mapBirdsToSpecies() {
        Map<String, List<Bird>> mapB = new HashMap<>();
        return mapB;
    }

}
