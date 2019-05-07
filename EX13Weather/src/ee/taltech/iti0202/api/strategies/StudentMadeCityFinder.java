package ee.taltech.iti0202.api.strategies;

import ee.taltech.iti0202.api.destinations.City;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StudentMadeCityFinder implements CityFinderStrategy {
    @Override
    public Optional<City> findBestCity(List<City> candidateCities) {
        return candidateCities.stream()
                .filter(city -> city.getAverageTemperature() > 20)
                .filter(city -> city.getAverageHumidity() < 50)
                .max(Comparator.comparingDouble(City::getAverageTemperature));
    }
}
