package ee.taltech.iti0202.api;

import ee.taltech.iti0202.api.agency.Client;
import ee.taltech.iti0202.api.agency.TravelAgency;
import ee.taltech.iti0202.api.provider.OnlineDataController;
import ee.taltech.iti0202.api.strategies.HatesRainCityFinder;
import ee.taltech.iti0202.api.strategies.WarmWeatherCityFinder;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> cityNames = new ArrayList<>();
        cityNames.add("Tallinn");
        cityNames.add("Perth");
        // cityNames.add("Sydney");
        cityNames.add("Aswan");
        Client client = new Client("Raul", "Pärnu", new HatesRainCityFinder());
        OnlineDataController oc = new OnlineDataController();
        TravelAgency ta = new TravelAgency(cityNames, oc);
        System.out.println(ta.findSuitableCitiesForClient(client));


    }
}
