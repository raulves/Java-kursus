package ee.taltech.iti0202.birdwatching.statistics;
import ee.taltech.iti0202.birdwatching.bird.Bird;
import ee.taltech.iti0202.birdwatching.bird.BirdDataController;
import ee.taltech.iti0202.birdwatching.filter.BirdFilter;


import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Map;


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
        return filter.getSuitableBirds(controller.getBirds());
    }

    public long countBirds() {
        return getBirds().stream().count();
    }

    public OptionalDouble findAverageWeight() {

        return getBirds().stream()
                .mapToDouble(bird -> bird.getWeight())
                .average();
    }

    public OptionalDouble findMinWeight() {
        return getBirds().stream()
                .mapToDouble(bird -> bird.getWeight())
                .min();
    }

    public OptionalDouble findMaxWeight()  {
        return getBirds().stream()
                .mapToDouble(bird -> bird.getWeight())
                .max();
    }

    public OptionalDouble findAverageWingspan() {
        return getBirds().stream()
                .mapToDouble(bird -> bird.getWingspan())
                .average();
    }

    public OptionalDouble findMinWingspan() {
        return getBirds().stream()
                .mapToDouble(Bird::getWingspan)
                .min();
    }

    public OptionalDouble findMaxWingspan() {
        return getBirds()
                .stream()
                .mapToDouble(bird -> bird.getWingspan())
                .max();
    }

    public List<Double> getWingspanData() {
        return getBirds().stream()
                .map(bird -> bird.getWingspan())
                .collect(Collectors.toList());
    }

    public List<Double> getWeightDataInGrams() {
        return getBirds().stream()
                .map(bird -> bird.getWeight() * 1000)
                .collect(Collectors.toList());
    }

    public List<Bird> getSample(int sampleSize) {
        return getBirds().stream()
                .limit(sampleSize)
                .collect(Collectors.toList());
    }

    public Optional<Bird> findSampleBird(String species, Bird.Sex sex, Bird.Age age) {
        return getBirds().stream()
                .filter(bird -> bird.getSpecies().equals(species))
                .filter(bird -> bird.getSex().equals(sex))
                .filter(bird -> bird.getAge().equals(age))
                .findFirst();

    }

    public Set<String> getAllEncounteredSpecies() {
        return getBirds().stream()
                .map(bird -> bird.getSpecies())
                .collect(Collectors.toSet());
    }

    public List<Bird> getLargeBirds(int skipCount) {
        return getBirds().stream()
                .sorted(Comparator.comparing(bird -> bird.getWeight()))
                .skip(skipCount)
                .collect(Collectors.toList());
    }

    public Map<String, List<Bird>> mapBirdsToSpecies() {
        return getBirds().stream()
                .collect(Collectors.groupingBy(bird -> bird.getSpecies()));
    }

}
