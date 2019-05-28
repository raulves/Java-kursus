package furniture.wardrobe;

import furniture.Furniture;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wardrobe extends Furniture {

    private static final double DRAWERS_RATE = 0.5;
    private static final int SCREWS_RATE = 50;
    private static final double GLUE_RATE = 0.1;

    private int drawers;

    public Wardrobe(String modelName, Category category, List<Material> materials, double height,
                    double width, double length, double price, int drawers) {
        super(modelName, category, materials, height, width, length, price);
        setDrawers(drawers);

    }

    @Override
    public Map<Material, Double> calculateMaterialsAmount() {
        Map<Material, Double> materialsTotal = new HashMap<>();

        for (Material material : super.getMaterials()) {
            if (Arrays.asList(Material.VENEER, Material.MDF, Material.WOOD).contains(material)) {
                double baseMaterialAmountM2 = (super.getWidth() * super.getLength()
                        + super.getHeight() * super.getLength()) + getDrawers() * DRAWERS_RATE;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0)
                        + roundDouble(baseMaterialAmountM2));
            } else if (material.equals(Material.SCREW)) {
                double screwsAmount = super.getWidth() * super.getHeight() * super.getLength() * SCREWS_RATE;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0)
                        + roundDouble(screwsAmount));
            } else if (material.equals(Material.GLUE)) {
                double glueAmount = super.getHeight() * super.getWidth() * super.getLength() * GLUE_RATE;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0)
                        + roundDouble(glueAmount));
            }
        }
        return materialsTotal;
    }

    public int getDrawers() {
        return drawers;
    }

    public void setDrawers(int drawers) {
        this.drawers = drawers;
    }
}
