package ee.taltech.iti0202.birdwatching.filter;

import ee.taltech.iti0202.birdwatching.bird.Bird;

import java.util.List;
import java.util.stream.Collectors;

public class WeightFilter implements BirdFilter {

    private double min;
    private double max;

    public WeightFilter(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public List<Bird> getSuitableBirds(List<Bird> birds) {
        return birds
                .stream()
                .filter(bird -> Double.compare(bird.getWeight(), min) == 0 || Double.compare(bird.getWeight(), min) > 0
                        && Double.compare(bird.getWeight(), max) == 0 || Double.compare(bird.getWeight(), max) < 0)
                .collect(Collectors.toList());
    }
}
