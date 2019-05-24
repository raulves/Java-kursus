package furniture.wardrobe;

import furniture.Furniture;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wardrobe extends Furniture {

    private int drawers;

    public Wardrobe(String modelName, Category category, List<Material> materials, double height,
                    double width, double length, double price, int drawers) {
        super(modelName, category, materials, height, width, length, price);
        this.drawers = drawers;

    }

    @Override
    public Map<Material, Double> calculateMaterialsAmount() {
        Map<Material, Double> materialsTotal = new HashMap<>();

        for (Material material : super.getMaterials()) {
            if (Arrays.asList(Material.VENEER, Material.MDF, Material.WOOD).contains(material)) {
                double baseMaterialAmountM2 = (super.getWidth() * super.getLength() + super.getHeight() * super.getLength()) + getDrawers() * 0.5;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(baseMaterialAmountM2));
            } else if (material.equals(Material.SCREW)) {
                double screwsAmount = super.getWidth() * super.getHeight() * super.getLength() * 50;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(screwsAmount));
            } else if (material.equals(Material.GLUE)) {
                double glueAmount = super.getHeight() * super.getWidth() * super.getLength() * 0.1;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(glueAmount));
            }
        }
        return materialsTotal;
    }

    public int getDrawers() {
        return drawers;
    }
}
