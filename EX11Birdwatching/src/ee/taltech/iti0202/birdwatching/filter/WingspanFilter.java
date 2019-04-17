package ee.taltech.iti0202.birdwatching.filter;

import ee.taltech.iti0202.birdwatching.bird.Bird;

import java.util.List;
import java.util.stream.Collectors;

public class WingspanFilter implements BirdFilter {

    private double min;
    private double max;

    public WingspanFilter(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public List<Bird> getSuitableBirds(List<Bird> birds) {
        return birds
                .stream()
                .filter(bird -> bird.getWingspan() >= min && bird.getWingspan() <= max)
                .collect(Collectors.toList());
    }
}
