package ee.taltech.iti0202.birdwatching.filter;

import ee.taltech.iti0202.birdwatching.bird.Bird;

import java.util.List;
import java.util.stream.Collectors;

public class AgeFilter implements BirdFilter {

    private Bird.Age age;

    public AgeFilter(Bird.Age age) {
        this.age = age;
    }

    @Override
    public List<Bird> getSuitableBirds(List<Bird> birds) {
        return birds
                .stream()
                .filter(bird -> bird.getAge() == age)
                .collect(Collectors.toList());
    }
}
