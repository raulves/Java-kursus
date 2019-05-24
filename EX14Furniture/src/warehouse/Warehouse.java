package warehouse;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import furniture.Furniture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Warehouse {

    class WarehouseJsonList {
        @SerializedName("Furniture")
        List<Furniture> furnitureList = new ArrayList<>();

    }

    // Kõik olemasolev materjal
    Map<Furniture.Material, Double> materials = new HashMap<>();

    // Kui mitu voodit, lauda jne on laos.
    Map<String, Integer> furnitureAmount = new HashMap<>();

    // Mudeli nime järgi tooted.
    Map<String, Integer> furnitureByModelTotal = new HashMap<>();

    // Kõik mööbliesemed
    List<Furniture> furnitures = new ArrayList<>();

    public Map<String, Integer> getFurnitureByModel() {
        return furnitureByModelTotal;
    }

    // Lisada ka Mapi
    public void add(Furniture furniture) {
        furnitureAmount.put(furniture.getClass().getSimpleName(), furnitureAmount.getOrDefault(furniture.getClass().getSimpleName(), 0) + 1);
        furnitureByModelTotal.put(furniture.getModelName(), furnitureByModelTotal.getOrDefault(furniture.getModelName(), 0) + 1);
        furnitures.add(furniture);
    }

    public void addMaterial(Furniture.Material material, double amount) {
        materials.put(material, materials.getOrDefault(material, 0.0) + amount);
    }

    // Kindla kategooriaga mööbliesemed
    public String getFurnitureByType(Furniture.Category category) {
        Gson gson = new Gson();
        WarehouseJsonList jsonList = new WarehouseJsonList();


        List<Furniture> sortedByType = furnitures.stream()
                .filter(furniture -> furniture.getCategory().equals(category))
                .collect(Collectors.toList());

        jsonList.furnitureList.addAll(sortedByType);
        String jsonInput = gson.toJson(jsonList);

        return jsonInput;
    }

    // Kindla mudeli/tüübiga mööbliesemed
    public String getFurnitureByModelName(String modelName) {
        Gson gson = new Gson();
        List<Furniture> sortedByType = furnitures.stream()
                .filter(furniture -> furniture.getModelName().equals(modelName))
                .collect(Collectors.toList());
        return gson.toJson(sortedByType);
    }

    public String getFurnitures() {
        Gson gson = new Gson();
        return gson.toJson(furnitures);
    }

    public String getMaterials() {
        Gson gson = new Gson();
        return gson.toJson(materials);
    }

    public String getFurnitureAmount() {
        Gson gson = new Gson();
        return gson.toJson(furnitureAmount);
    }

    // Kindlat tüüpi materjal
    public String getMaterialByType(Furniture.Material material) {
        Map<Furniture.Material, Double> collect = materials.entrySet().stream()
                .filter(x -> x.getKey().equals(material))
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
        Gson gson = new Gson();
        return gson.toJson(collect);
    }

    // Kui mitu kindla tüübiga mööblieset oleks meil võimalik valmistada hetkel laos olevast materjalist
    public String getPossibleManufacturingAmount(Furniture furniture) {
        List<Integer> minAmount = new ArrayList<>();
        for (Furniture.Material material : furniture.getMaterialsAmount().keySet()) {
            double materialNeededForOneFurniture = furniture.getMaterialsAmount().get(material);
            double materialAmountInWarehouse = materials.getOrDefault(material, 0.0);
            double amount = materialAmountInWarehouse / materialNeededForOneFurniture;
            int amountInt = (int) amount;
            minAmount.add(amountInt);
        }
        if (minAmount.size() > 0) {
            int canProduce = Collections.min(minAmount);
            if (canProduce > 0) {
                return "There's enough material to manufacture exactly " + canProduce + " " + furniture.getModelName() + ".";
            }
            return "There's not enough material in warehouse to manufacture " + furniture.getModelName() + ".";
        }


        return "There's not enough material in warehouse to manufacture " + furniture.getModelName() + ".";
    }

    // Kas n tüki kindla mööblieseme valmistamiseks on meil vajalik materjal laos olemas.
    // Kui ei, siis peab süsteem andma meile teada täpse materjali hulga, mida esemete valmistamiseks on juurde vaja.
    public String canManufacture(Furniture furniture, int amount) {
        Map<Furniture.Material, Double> materialsNeededToOrder = new HashMap<>();

        for (Furniture.Material material : furniture.getMaterialsAmount().keySet()) {
            double materialNeededForOneFurniture = furniture.getMaterialsAmount().get(material);
            double totalMaterialNeededToFillTheOrder = materialNeededForOneFurniture * amount;
            // Material in warehouse.
            double materialAmountInWarehouse = materials.getOrDefault(material, 0.0);
            if (materialAmountInWarehouse >= totalMaterialNeededToFillTheOrder) {
                continue;
            } else {
                double materialAmountToBeOrdered = Math.abs(materialAmountInWarehouse - totalMaterialNeededToFillTheOrder);
                materialsNeededToOrder.put(material, materialsNeededToOrder.getOrDefault(material, 0.0) + materialAmountToBeOrdered);
            }
        }
        if (materialsNeededToOrder.size() > 0) {
            String result = "There's not enough material to manufacture " + amount + " " + furniture.getModelName() + ".\n";
            String order = "Materials needed: ";
            for (Furniture.Material material : materialsNeededToOrder.keySet()) {
                order += material + ":" + materialsNeededToOrder.get(material) + ", ";
            }
            return result + order.substring(0, order.length() - 2);

        }
        return "There's enough materials to manufacture " + amount + " " + furniture.getModelName() + ".";
    }

}
