package ee.taltech.iti0202.api.strategies;

import ee.taltech.iti0202.api.destinations.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HatesRainCityFinder implements CityFinderStrategy {
    @Override
    public Optional<City> findBestCity(List<City> candidateCities) {
        List<City> acceptableCities = candidateCities.stream().filter(city -> city.getAverageHumidity() <= 80).collect(Collectors.toList());

        List<City> bestCities = new ArrayList<>();


        for (City acceptableCity : acceptableCities) {
            int count = 0;
            for (Integer code : acceptableCity.getWeatherCodes()) {
                if (code / 100 == 5) {
                    count++;
                }
            }
            if (count <= 1) {
                bestCities.add(acceptableCity);
            }
        }

        return Optional.ofNullable(bestCities.get(0));
    }




}
