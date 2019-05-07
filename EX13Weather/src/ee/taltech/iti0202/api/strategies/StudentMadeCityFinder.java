package ee.taltech.iti0202.api.strategies;

import ee.taltech.iti0202.api.destinations.City;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StudentMadeCityFinder implements CityFinderStrategy {
    private final int lowestAcceptableTemp = 20;
    private final int highestAcceptableHumidity = 50;
    @Override
    public Optional<City> findBestCity(List<City> candidateCities) {
        return candidateCities.stream()
                .filter(city -> city.getAverageTemperature() > lowestAcceptableTemp)
                .filter(city -> city.getAverageHumidity() < highestAcceptableHumidity)
                .max(Comparator.comparingDouble(City::getAverageTemperature));
    }
}
