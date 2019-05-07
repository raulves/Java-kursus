package ee.taltech.iti0202.api.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OnlineDataController {
    /**
         * Tries to get forecast data for the cityName. If there is no data or cityName doesn't exist,
     * return an empty string.
         * @param cityName Name of the city
         * @return String in the form of a json-string
    */
    public String getCity(String cityName) {
        String urlString = "http://api.openweathermap.org/data/2.5/forecast?q=" + cityName
                + "&mode=json&units=metric&APPID=348899d16adaf3863e6995828e490828";
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = null;
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();
        } catch (IOException e) {
            return "";
        }

        return content.toString();
    }

}
