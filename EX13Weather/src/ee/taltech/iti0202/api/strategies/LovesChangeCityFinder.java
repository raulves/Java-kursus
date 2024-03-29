package ee.taltech.iti0202.api.strategies;

import ee.taltech.iti0202.api.destinations.City;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LovesChangeCityFinder implements CityFinderStrategy {
    private final int addScore = 20;
    @Override
    public Optional<City> findBestCity(List<City> candidateCities) {

        Map<City, Integer> citiesWithWeatherScore = new HashMap<>();


        for (City city : candidateCities) {
            int weatherScore = 0;

            List<Integer> weatherCodes = city.getWeatherCodes();
            for (int i = 0; i < weatherCodes.size(); i++) {
                if (i + 1 < weatherCodes.size()) {
                    if (weatherCodes.get(i) - weatherCodes.get(i + 1) == 0) {
                        weatherScore -= 10;
                    } else if (weatherCodes.get(i) / 100 == weatherCodes.get(i + 1)) {
                        weatherScore += addScore;
                    } else {
                        weatherScore += 100;
                    }
                }
            }
            citiesWithWeatherScore.put(city, weatherScore);


        }
        int maxScore = Collections.max(citiesWithWeatherScore.values());
        for (City city : citiesWithWeatherScore.keySet()) {
            if (citiesWithWeatherScore.get(city) == maxScore) {
                return Optional.of(city);
            }
        }
        return Optional.empty();
    }
}
