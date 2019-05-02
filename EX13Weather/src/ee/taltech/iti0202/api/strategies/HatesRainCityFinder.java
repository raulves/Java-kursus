package ee.taltech.iti0202.api.strategies;

import ee.taltech.iti0202.api.destinations.City;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class HatesRainCityFinder implements CityFinderStrategy {

    @Override
    public Optional<City> findBestCity(List<City> candidateCities) {

        // Humidity
        List<City> acceptableCities = new ArrayList<>();

        for (City city : candidateCities) {
            List<Double> humidities = city.getHumidity();

            int count = 0;
            for (int i = 0; i < 5; i++) {
                List<Double> humidityPerDay = new ArrayList<>();
                for (int j = 0; j < 8; j++) {
                    humidityPerDay.add(humidities.get(j));
                }
                if (getAverageTemperature(humidityPerDay) > 80) {
                    count++;
                }

                for (int k = 0; k < 8; k++) {
                    humidities.remove(0);
                }
            }
            if (count == 0) {
                acceptableCities.add(city);
            }

        }

        // Rain

        List<City> bestCities = new ArrayList<>();


        for (City acceptableCity : acceptableCities) {
            List<Integer> weatherCodes = acceptableCity.getWeatherCodes();
            int count = 0;
            for (int i = 0; i < 5; i++) {
                List<Integer> weatherPerDay = new ArrayList<>();
                for (int j = 0; j < 8; j++) {
                    weatherPerDay.add(weatherCodes.get(j));
                }
                if (isRainyDay(weatherPerDay)) {
                    count++;
                }
                for (int k = 0; k < 8; k++) {
                    weatherCodes.remove(0);
                }
            }
            if (count <= 1) {
                bestCities.add(acceptableCity);
            }

        }


        if (bestCities.size() > 0) {
            return Optional.of(bestCities.get(0));
        }

        return Optional.empty();
    }

    private double getAverageTemperature(List<Double> temperatures) {
        double sum = temperatures.stream().mapToDouble(n -> n).sum();
        return sum / temperatures.size();
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
