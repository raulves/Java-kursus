package ee.taltech.iti0202.birdwatching.filter;

import ee.taltech.iti0202.birdwatching.bird.Bird;

import java.util.List;
import java.util.stream.Collectors;

public class SpeciesFilter implements BirdFilter {

    private String species;

    public SpeciesFilter(String species) {
        this.species = species;
    }

    @Override
    public List<Bird> getSuitableBirds(List<Bird> birds) {
        return birds
                .stream()
                .filter(s -> s.getSpecies().equals(species))
                .collect(Collectors.toList());
    }
}
