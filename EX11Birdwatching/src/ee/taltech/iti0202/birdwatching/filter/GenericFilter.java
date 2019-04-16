package ee.taltech.iti0202.birdwatching.filter;

import ee.taltech.iti0202.birdwatching.bird.Bird;

import java.util.List;
import java.util.stream.Collectors;

public class GenericFilter implements BirdFilter {
    @Override
    public List<Bird> getSuitableBirds(List<Bird> birds) {
        List<Bird> allBirds = birds.stream().collect(Collectors.toList());
        return allBirds;
    }
}
