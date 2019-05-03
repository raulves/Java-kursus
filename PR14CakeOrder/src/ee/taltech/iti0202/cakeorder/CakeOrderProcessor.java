package ee.taltech.iti0202.cakeorder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CakeOrderProcessor {
    private final List<String> milkProducts = List.of("milk", "cream-cheese", "yoghurt");
    private int orderCounts = 0;
    public enum CakeOrderProcessorType {
        MAKE_DAIRY_FREE,
        COUNT_TOTAL_SUM,
        REMOVE_BEST_BEFORE_DAY_OVER

    }

    private CakeOrderProcessorType type;

    public CakeOrderProcessor(CakeOrderProcessorType type) {
        this.type = type;
    }

    public String process(String jsonInput) {
        JsonObject jsonObject = new JsonParser().parse(jsonInput).getAsJsonObject();
        JsonArray array = jsonObject.getAsJsonArray("cakes");
        orderCounts++;
        jsonObject.addProperty("order_id", orderCounts);

        if (array.size() == 0) {
            jsonObject.addProperty("total", 0);
            return jsonObject.toString();
        }

        if (type.equals(CakeOrderProcessorType.MAKE_DAIRY_FREE)) {

            for (JsonElement cake : array) {
                String cakeName = cake.getAsJsonObject().get("name").getAsString();
                String[] splitTheCakeName = cakeName.split("\\W+");
                String cakeID = "";
                for (String s : splitTheCakeName) {
                    cakeID += s.substring(0, 1).toUpperCase();
                }
                cakeID += splitTheCakeName.length;
                cake.getAsJsonObject().addProperty("cake_id", cakeID);
                JsonArray ingredients = cake.getAsJsonObject().get("ingredients").getAsJsonArray();
                double milkIngredientsTotal = 1.00;
                for (int i = 0; i < ingredients.size(); i++) {
                    if (milkProducts.contains(ingredients.get(i).getAsString())) {
                        ingredients.set(i, new JsonPrimitive("plant-" + ingredients.get(i).getAsString()));
                        milkIngredientsTotal += 0.1;
                    }
                }
                double newPrice = cake.getAsJsonObject().get("price").getAsDouble() * milkIngredientsTotal;
                DecimalFormat df = new DecimalFormat("#.#");
                df.setRoundingMode(RoundingMode.DOWN);

                cake.getAsJsonObject().add("price", new JsonPrimitive(df.format(newPrice)));
            }
        }

        if (type.equals(CakeOrderProcessorType.COUNT_TOTAL_SUM)) {

            double totalOrderAmount = 0.00;
            for (JsonElement cake : array) {
                double cakePrice = cake.getAsJsonObject().get("price").getAsDouble();
                double cakeWeigth = cake.getAsJsonObject().get("kg").getAsDouble();
                totalOrderAmount += cakePrice * cakeWeigth;
            }
            jsonObject.addProperty("total", totalOrderAmount);
        }

        if (type.equals(CakeOrderProcessorType.REMOVE_BEST_BEFORE_DAY_OVER)) {

            List<JsonElement> elementsToRemove = new ArrayList<>();

            // Eemaldama hakkan arrayst, mis eespool deklareeritud.
            for (JsonElement cake : array) {
                String inputDate = cake.getAsJsonObject().get("BBD").getAsString();
                DateTimeFormatter dtfin = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(inputDate, dtfin);
                DateTimeFormatter dtfout = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate date = LocalDate.now();

                if (localDate.isEqual(date) || localDate.isBefore(date)) {
                    elementsToRemove.add(cake);
                }

            }
            for (JsonElement jsonElement : elementsToRemove) {
                array.remove(jsonElement);
            }
        }
        return jsonObject.toString();
    }


    public static void main(String[] args) {
        CakeOrderProcessor cp = new CakeOrderProcessor(CakeOrderProcessorType.MAKE_DAIRY_FREE);
        String input = "{\n" +
                "  \"cakes\": [\n" +
                "    {\n" +
                "      \"name\": \"Sacher\",\n" +
                "      \"BBD\": \"2019-04-29\",\n" +
                "      \"price\": 14.39,\n" +
                "      \"kg\": 2.00,\n" +
                "      \"ingredients\": [\"flour\", \"chocolate\", \"milk\", \"sugar\", \"eggs\"]\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"New York Cheesecake\",\n" +
                "      \"BBD\": \"2019-04-30\",\n" +
                "      \"price\": 10.00,\n" +
                "      \"kg\": 1.50,\n" +
                "      \"ingredients\": [\"flour\", \"cream-cheese\", \"milk\", \"sugar\", \"eggs\"]\n" +
                "\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        System.out.println(cp.process(input));

    }

}
