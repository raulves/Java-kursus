package furniture.chair;

import furniture.Furniture;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chair extends Furniture {

    private static final double SCREWS_AMOUNT = 16;
    private static final double CHAIR_LEGS = 4;

    public Chair(String modelName, Furniture.Category category, List<Furniture.Material> materials,
                 double height, double width, double length, double price) {
        super(modelName, category, materials, height, width, length, price);
    }

    @Override
    public Map<Material, Double> calculateMaterialsAmount() {
        Map<Material, Double> materialsTotal = new HashMap<>();

        for (Material material : super.getMaterials()) {
            if (Arrays.asList(Material.VENEER, Material.WOOD).contains(material)) {
                double baseMaterialAmountM2 = super.getWidth() * super.getLength();
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0)
                        + roundDouble(baseMaterialAmountM2));
            } else if (Arrays.asList(Material.STAINLESS_STEEL, Material.PLASTIC).contains(material)) {
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + CHAIR_LEGS);
            } else if (material.equals(Material.SCREW)) {
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0)
                        + roundDouble(SCREWS_AMOUNT));
            }
        }
        return materialsTotal;
    }
}
