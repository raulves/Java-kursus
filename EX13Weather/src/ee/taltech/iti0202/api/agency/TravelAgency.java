package ee.taltech.iti0202.api.agency;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ee.taltech.iti0202.api.destinations.City;
import ee.taltech.iti0202.api.destinations.CityBuilder;
import ee.taltech.iti0202.api.provider.OnlineDataController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelAgency {

    private OnlineDataController dataController;
    private List<String> cityNames;
    private List<String> weatherDataAllCities = new ArrayList<>();
    private List<City> cityObjects = new ArrayList<>();
    
        public TravelAgency(List<String> cityNames, OnlineDataController dataController) {
            this.cityNames = cityNames;
            this.dataController = dataController;
        }

    /**
     * If the agency doesn't have a destination city yet, adds it to the list.
     * 
     * @param city city name.
    */
    public void addCity(String city) {
        if(!cityNames.contains(city)) {
            cityNames.add(city);
        }
    }
    
    /**
    * Return all the cities that the agency has.
    * 
    * @return list of cities
    */
    public List<String> getCityList() {
        return cityNames;
    }


    /**
     * This method tries to find a suitable city for the client to visit.
     * 
     * It uses OnlineDataController, to get data for the cities.
     * After getting data about a city, SAVE IT for the duration of the cycle. OpenWeather API updates data every 10 minutes.
     * Create a City object using the CityBuilder here.
     * @param client a client who wants to go somewhere.
     * @return Optional city if the client was happy with it.
    */
    public Optional<City> findSuitableCitiesForClient(Client client) {

        for (String city : cityNames) {
            String weatherData = dataController.getCity(city);
            weatherDataAllCities.add(weatherData);

            // Keys [cod, message, cnt, list, city]
            JsonObject jsonObject = new JsonParser().parse(weatherData).getAsJsonObject();
            String cityName = jsonObject.getAsJsonObject("city").get("name").getAsString();
            double lon = jsonObject.getAsJsonObject("city").getAsJsonObject("coord").get("lon").getAsDouble();
            double lat = jsonObject.getAsJsonObject("city").getAsJsonObject("coord").get("lat").getAsDouble();
            List<Double> temperatures = new ArrayList<>();
            JsonArray arr = jsonObject.getAsJsonArray("list");

            for (int i = 0; i < arr.size(); i++) {
                temperatures.add(arr.get(i).getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsDouble());
            }

            List<Double> humidity = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                humidity.add(arr.get(i).getAsJsonObject().get("main").getAsJsonObject().get("humidity").getAsDouble());
            }

            List<Integer> weatherCodes = new ArrayList<>();
            for (int i = 0; i < arr.size(); i++) {
                weatherCodes.add(arr.get(i).getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("id").getAsInt());
            }

            City newCity = new CityBuilder().setName(cityName)
                    .setLon(lon)
                    .setLat(lat)
                    .setTemperatures(temperatures)
                    .setHumidity(humidity)
                    .setWeatherCodes(weatherCodes)
                    .createCity();
            cityObjects.add(newCity);


        }

        return Optional.empty();
    }

}
