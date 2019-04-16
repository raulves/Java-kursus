package ee.taltech.iti0202.birdwatching.filter;

import ee.taltech.iti0202.birdwatching.bird.Bird;

import java.util.List;
import java.util.stream.Collectors;

public class WingspanFilter implements BirdFilter {

    private Double min;
    private Double max;

    public WingspanFilter(Double min, Double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public List<Bird> getSuitableBirds(List<Bird> birds) {
        return birds
                .stream()
                .filter(bird -> Double.compare(bird.getWingspan(), min) == 0
                        || Double.compare(bird.getWingspan(), min) > 0
                        && Double.compare(bird.getWingspan(), max) == 0 || Double.compare(bird.getWingspan(), max) < 0)
                .collect(Collectors.toList());
    }
}
