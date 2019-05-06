package ee.taltech.iti0202.cakeorder;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CakeOrderProcessor {
    private final double addedPercent = 0.1;

    class AllCakes {
        private List<Cake> cakes = new ArrayList<>();
        @SerializedName("order_id")
        private int orderId;
        @SerializedName("total")
        private double orderTotal;

        @Override
        public String toString() {
            return "AllCakes{"
                    + "cakes="
                    + cakes
                    + '}';
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public void setOrderTotal(double orderTotal) {
            this.orderTotal = orderTotal;
        }
    }

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
        Gson gson = new Gson();
        AllCakes allCakes = gson.fromJson(jsonInput, AllCakes.class);

        orderCounts++;
        allCakes.setOrderId(orderCounts);
        for (Cake cake : allCakes.cakes) {
            cake.setCakeId(addCakeId(cake.getName()));
        }




        if (type.equals(CakeOrderProcessorType.MAKE_DAIRY_FREE)) {

            for (Cake cake : allCakes.cakes) {
                List<String> ingredientsCopy = List.copyOf(cake.getIngredients());
                double countMilkProducts = 1.0;
                for (String ingredient : ingredientsCopy) {
                    if (milkProducts.contains(ingredient)) {
                        countMilkProducts += addedPercent;
                        String plantMilk = "plant-" + ingredient;
                        cake.getIngredients().add(plantMilk);
                        cake.getIngredients().remove(ingredient);
                    }
                }
                double newPrice = cake.getPrice() * countMilkProducts;
                DecimalFormat df = new DecimalFormat("#.#");
                df.setRoundingMode(RoundingMode.DOWN);
                cake.setPrice(Double.parseDouble(df.format(newPrice)));

            }

        }

        if (type.equals(CakeOrderProcessorType.COUNT_TOTAL_SUM)) {
            double totalOrder = 0.0;
            for (Cake cake : allCakes.cakes) {
                totalOrder += cake.getKg() * cake.getPrice();
            }
            allCakes.setOrderTotal(totalOrder);
        }

        if (type.equals(CakeOrderProcessorType.REMOVE_BEST_BEFORE_DAY_OVER)) {
            List<Cake> cakesCopy = List.copyOf(allCakes.cakes);
            for (Cake cake : cakesCopy) {
                String inputDate = cake.getBestBeforeDate();
                DateTimeFormatter dtfin = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(inputDate, dtfin);
                DateTimeFormatter dtfout = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate today = LocalDate.now();

                if (localDate.isEqual(today) || localDate.isBefore(today)) {
                    allCakes.cakes.remove(cake);
                }
            }


        }
        return gson.toJson(allCakes);
    }

    /*
    public static void main(String[] args) {
        CakeOrderProcessor cp = new CakeOrderProcessor(CakeOrderProcessorType.REMOVE_BEST_BEFORE_DAY_OVER);
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


    }
    */

    private String addCakeId(String cakeName) {
        String[] splitTheCakeName = cakeName.split(" ");
        String cakeID = "";
        for (String s : splitTheCakeName) {
            cakeID += s.substring(0, 1).toUpperCase();
        }
        cakeID += splitTheCakeName.length;

        return cakeID;
    }

}
