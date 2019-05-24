package furniture.desk;

import furniture.Furniture;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Desk extends Furniture {


    public Desk(String modelName, Category category, List<Material> materials, double height, double width, double length, double price) {
        super(modelName, category, materials, height, width, length, price);
    }

    @Override
    public Map<Material, Double> calculateMaterialsAmount() {
        Map<Material, Double> materialsTotal = new HashMap<>();

        for (Material material : super.getMaterials()) {
            if (Arrays.asList(Material.VENEER, Material.WOOD, Material.GLASS).contains(material)) {
                double baseMaterialAmountM2 = super.getWidth() * super.getLength();
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(baseMaterialAmountM2));
            } else if (Arrays.asList(Material.STAINLESS_STEEL, Material.PLASTIC).contains(material)) {
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + 4.0);
            } else if (material.equals(Material.SCREW)) {
                double screwsAmount = 16;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(screwsAmount));
            }
        }
        return materialsTotal;
    }
}