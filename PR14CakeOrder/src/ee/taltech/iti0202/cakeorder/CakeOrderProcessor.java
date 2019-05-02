package ee.taltech.iti0202.cakeorder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import java.util.List;

public class CakeOrderProcessor {
    private final List<String> milkProducts = List.of("milk", "cream-cheese", "yoghurt");
    private static int orderCounts = 0;
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

        if (type.equals(CakeOrderProcessorType.MAKE_DAIRY_FREE)) {
            orderCounts++;
            jsonObject.addProperty("order_id", orderCounts);
            for (JsonElement cake : array) {
                JsonArray ingredients = cake.getAsJsonObject().get("ingredients").getAsJsonArray();
                double milkIngredientsTotal = 1.0;
                for (int i = 0; i < ingredients.size(); i++) {
                    if (milkProducts.contains(ingredients.get(i).getAsString())) {
                        ingredients.set(i, new JsonPrimitive("plant-" + ingredients.get(i).getAsString()));
                        milkIngredientsTotal += 0.1;
                    }
                }
                double newPrice = Math.round((cake.getAsJsonObject().get("price").getAsDouble() * milkIngredientsTotal));

                cake.getAsJsonObject().add("price", new JsonPrimitive(newPrice));
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
                "      \"price\": 14.00,\n" +
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

        /*
        JsonObject jsonObject = new JsonParser().parse(input).getAsJsonObject();
        JsonArray array = jsonObject.getAsJsonArray("cakes");
        System.out.println(array.get(0).getAsJsonObject().get("ingredients").getAsJsonArray());

        Gson gson = new Gson();
        JsonObject jsonObject2 = gson.fromJson(input, JsonObject.class);
        double newPrice = 17.89;
        JsonElement je = new JsonPrimitive(newPrice);
        System.out.println(jsonObject2.getAsJsonArray("cakes").get(0));

        jsonObject2.getAsJsonArray("cakes").get(0).getAsJsonObject().add("price", je);
        jsonObject.getAsJsonArray("cakes").get(0).getAsJsonObject().add("price", je);
        System.out.println(jsonObject2.getAsJsonArray("cakes").get(0));
        System.out.println("-------------------");

        List<String> milkProducts = List.of("milk", "cream-cheese", "yoghurt");
        for (JsonElement cake : array) {
            JsonArray ingredients = cake.getAsJsonObject().get("ingredients").getAsJsonArray();

            for (int i = 0; i < ingredients.size(); i++) {
                if (milkProducts.contains(ingredients.get(i).getAsString())) {
                    System.out.println(ingredients.get(i).getAsString());
                    ingredients.set(i, new JsonPrimitive("plant-" + ingredients.get(i).getAsString()));

                    System.out.println("MILK");
                } else {
                    System.out.println("NO Milk");
                }

            }
            System.out.println(ingredients);
        }
        System.out.println(array.toString());
        System.out.println(14.0 * 1.1);
        */
    }

}
