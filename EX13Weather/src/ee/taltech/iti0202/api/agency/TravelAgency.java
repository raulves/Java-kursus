package ee.taltech.iti0202.api.agency;

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

    /*
    class Weather {
        private List<Data> list = new ArrayList<>();


        @Override
        public String toString() {
            return "Weather{" +
                    "list=" + list +
                    '}';
        }
    }

    class Data {
        private Map<String, Double> main = new HashMap<>();
        private List<Map<String, Object>> weather = new ArrayList<>();

        @Override
        public String toString() {
            return "Data{" +
                    "main=" + main +
                    ", weather=" + weather +
                    '}';
        }
    }

     */



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
     * After getting data about a city, SAVE IT for the duration of the cycle. OpenWeather API updates
     * data every 10 minutes.
     * Create a City object using the CityBuilder here.
     * @param client a client who wants to go somewhere.
     * @return Optional city if the client was happy with it.
    */
    public Optional<City> findSuitableCitiesForClient(Client client) {
        /*
        Gson gson = new Gson();
        Weather weather = gson.fromJson(dataController.getCity(cityNames.get(0)), Weather.class);
        System.out.println(weather.list);
        System.out.println(weather.list.get(0).main.get("temp"));
        Map result = gson.fromJson(dataController.getCity(cityNames.get(0)), Map.class);
        System.out.println(result.get("city"));
        */


        /*
        if (client.getCitiesThatWantsToVisit() != null) {
            cityNames.clear();
            cityNames.addAll(client.getCitiesThatWantsToVisit());

        }

         */

        for (String city : cityNames) {
            String weatherData = dataController.getCity(city);
            System.out.println(weatherData);
            weatherDataAllCities.add(weatherData);

            // Keys [cod, message, cnt, list, city]
            JsonObject jsonObject = new JsonParser().parse(weatherData).getAsJsonObject();

            JsonArray array = jsonObject.getAsJsonArray("list");
            City newCity = new CityBuilder()
                    .setName(getName(jsonObject))
                    .setLon(getLongitude(jsonObject))
                    .setLat(getLatitude(jsonObject))
                    .setTemperatures(getTemperatures(array))
                    .setHumidity(getHumidity(array))
                    .setWeatherCodes(getWeatherCodes(array))
                    .createCity();
            cityObjects.add(newCity);

        }
        for (City cityObject : cityObjects) {
            if (cityObject.getName().equals(client.getStartingCity())) {
                cityObjects.remove(cityObject);
            }
        }



        return client.chooseBestCity(cityObjects);
    }

    private String getName(JsonObject jsonObject) {
        return jsonObject.getAsJsonObject("city").get("name").getAsString();
    }

    private double getLongitude(JsonObject jsonObject) {
        return jsonObject.getAsJsonObject("city").getAsJsonObject("coord").get("lon").getAsDouble();
    }

    private double getLatitude(JsonObject jsonObject) {
        return jsonObject.getAsJsonObject("city").getAsJsonObject("coord").get("lat").getAsDouble();
    }

    private List<Double> getTemperatures(JsonArray array) {
        List<Double> temperatures = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            temperatures.add(array.get(i).getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsDouble());
        }
        return temperatures;
    }

    private List<Double> getHumidity(JsonArray array) {
        List<Double> humidity = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            humidity.add(array.get(i).getAsJsonObject().get("main").getAsJsonObject().get("humidity").getAsDouble());
        }
        return humidity;
    }

    private List<Integer> getWeatherCodes(JsonArray array) {
        List<Integer> weatherCodes = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            weatherCodes.add(array.get(i).getAsJsonObject().get("weather").getAsJsonArray().get(0)
                    .getAsJsonObject().get("id").getAsInt());
        }
        return weatherCodes;
    }

}
