package ee.taltech.iti0202.api.strategies;

import ee.taltech.iti0202.api.destinations.City;

import java.util.*;

public class HatesRainCityFinder implements CityFinderStrategy {

    @Override
    public Optional<City> findBestCity(List<City> candidateCities) {

        // Rain
        List<City> noRainCities = new ArrayList<>();
        for (City acceptableCity : candidateCities) {
            List<Integer> weatherCodes = acceptableCity.getWeatherCodes();
            int count = 0;
            for (int i = 0; i < 5; i++) {
                List<Integer> weatherPerDay = new ArrayList<>();
                for (int j = 0; j < 8; j++) {
                    weatherPerDay.add(weatherCodes.get(0));
                    weatherCodes.remove(0);
                }
                if (isRainyDay(weatherPerDay)) {
                    count++;
                }
            }

            if (count <= 1) {
                noRainCities.add(acceptableCity);
            }

        }

        // Humidity
        List<City> lowHumidityCities = new ArrayList<>();

        for (City city : noRainCities) {
            List<Double> humidities = new ArrayList<>(List.copyOf(city.getHumidity()));
            System.out.println(humidities);
            int count = 0;
            for (int i = 0; i < 5; i++) {
                List<Double> humidityPerDay = new ArrayList<>();
                for (int j = 0; j < 8; j++) {
                    humidityPerDay.add(humidities.get(0));
                    humidities.remove(0);
                }
                if (getAverageHumidityPerDay(humidityPerDay) > 80) {
                    count++;
                }

            }

            if (count == 0) {
                lowHumidityCities.add(city);
            }

        }

        if (lowHumidityCities.size() == 1) {
            return Optional.ofNullable(lowHumidityCities.get(0));
        }
        if (lowHumidityCities.size() > 1) {

            for (City city : lowHumidityCities) {
                System.out.println(city);
                System.out.println(city.getHumidity());
            }
            return lowHumidityCities.stream().min(Comparator.comparing(city -> city.getAverageHumidity()));
        }






        return Optional.empty();
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
