package ee.taltech.iti0202.api.strategies;

import ee.taltech.iti0202.api.destinations.City;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HatesRainCityFinder implements CityFinderStrategy {

    private final int measurementsPerDay = 8;
    @Override
    public Optional<City> findBestCity(List<City> candidateCities) {

        // Rain
        List<City> noRainCities = new ArrayList<>();
        Map<City, Integer> rainyDaysPerFiveDays = new HashMap<>();
        for (City acceptableCity : candidateCities) {
            List<Integer> weatherCodes = new ArrayList<>(List.copyOf(acceptableCity.getWeatherCodes()));
            int count = 0;
            for (int i = 0; i < 5; i++) {
                List<Integer> weatherPerDay = new ArrayList<>();
                for (int j = 0; j < measurementsPerDay; j++) {
                    weatherPerDay.add(weatherCodes.get(0));
                    weatherCodes.remove(0);
                }
                if (isRainyDay(weatherPerDay)) {
                    count++;
                }
            }
            rainyDaysPerFiveDays.put(acceptableCity, count);
        }
        int lessRainDays = Collections.min(rainyDaysPerFiveDays.values());
        for (City city : rainyDaysPerFiveDays.keySet()) {
            if (rainyDaysPerFiveDays.get(city) == lessRainDays) {
                noRainCities.add(city);
            }
        }
        return noRainCities.stream().min(Comparator.comparingDouble(city -> city.getAverageHumidity()));
    }

    private double getAverageHumidityPerDay(List<Double> humidity) {
        double sum = humidity.stream().mapToDouble(n -> n).sum();
        return sum / humidity.size();
    }

    private boolean isRainyDay(List<Integer> weatherCodes) {
        for (Integer weatherCode : weatherCodes) {
            if (weatherCode / 100 == 5) {
                return true;
            }
        }
        return false;
    }


}
