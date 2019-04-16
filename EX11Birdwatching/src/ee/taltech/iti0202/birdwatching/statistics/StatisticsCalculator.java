package ee.taltech.iti0202.birdwatching.statistics;
import ee.taltech.iti0202.birdwatching.bird.Bird;
import ee.taltech.iti0202.birdwatching.bird.BirdDataController;
import ee.taltech.iti0202.birdwatching.filter.BirdFilter;

import java.util.*;

public class StatisticsCalculator {

    public StatisticsCalculator(BirdDataController controller, BirdFilter filter) {
    }

    public void prepareBirdData(String filename) {
    }

    public List<Bird> getBirds() {
    }

    public long countBirds() {
    }

    public OptionalDouble findAverageWeight() {
    }

    public OptionalDouble findMinWeight() {
    }

    public OptionalDouble findMaxWeight()  {
    }

    public OptionalDouble findAverageWingspan() {
    }

    public OptionalDouble findMinWingspan() {
    }

    public OptionalDouble findMaxWingspan() {
    }

    public List<Double> getWingspanData() {
    }

    public List<Double> getWeightDataInGrams() {
    }

    public List<Bird> getSample(int sampleSize) {
    }

    public Optional<Bird> findSampleBird(String species, Bird.Sex sex, Bird.Age age) {
    }

    public Set<String> getAllEncounteredSpecies() {
    }

    public List<Bird> getLargeBirds(int skipCount) {
    }

    public Map<String, List<Bird>> mapBirdsToSpecies() {
    }

}