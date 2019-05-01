package ee.taltech.iti0202.api.destinations;

import java.util.List;
import java.util.OptionalDouble;

public class City {
    private String name;
    private double lon;
    private double lat;
    private List<Double> temperatures;
    private List<Double> humidity;
    private List<Integer> weatherCodes;

    City(String name, double lon, double lat, List<Double> temperatures, List<Double> humidity, List<Integer> weatherCodes) {
        this.name = name;
        this.lon = lon;
        this.lat = lat;
        this.temperatures = temperatures;
        this.humidity = humidity;
        this.weatherCodes = weatherCodes;
    }

    public String getName() {
        return name;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public List<Double> getTemperatures() {
        return temperatures;
    }

    public List<Double> getHumidity() {
        return humidity;
    }

    public List<Integer> getWeatherCodes() {
        return weatherCodes;
    }

    public double getAverageTemperature() {
        double sum = temperatures.stream().mapToDouble(n -> n).sum();
        return sum / temperatures.size();
    }

    public double getAverageHumidity() {
        double sum = humidity.stream().mapToDouble(n -> n).sum();
        return sum / humidity.size();
    }

}
