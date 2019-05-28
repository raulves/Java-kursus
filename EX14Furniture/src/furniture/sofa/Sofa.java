package furniture.sofa;

import furniture.Furniture;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sofa extends Furniture {

    private static final double GLUE_RATE = 0.1;
    private static final int SCREWS_RATE = 100;
    private static final int FABRIC_AMOUNT_RATE = 2;
    private static final double SOFA_LEGS = 4;


    public Sofa(String modelName, Category category, List<Material> materials, double height, double width,
                double length, double price) {
        super(modelName, category, materials, height, width, length, price);

    }

    @Override
    public Map<Material, Double> calculateMaterialsAmount() {
        Map<Material, Double> materialsTotal = new HashMap<>();

        for (Material material : super.getMaterials()) {
            if (material.equals(Material.MDF)) {
                double baseMaterialAmountM2 = super.getWidth() * super.getLength()
                        + super.getHeight() * super.getLength();
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0)
                        + roundDouble(baseMaterialAmountM2));
            } else if (Arrays.asList(Material.STAINLESS_STEEL, Material.PLASTIC).contains(material)) {
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + SOFA_LEGS);
            } else if (material.equals(Material.SCREW)) {
                double screwsAmount = super.getHeight() * super.getLength() * SCREWS_RATE;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0)
                        + roundDouble(screwsAmount));
            } else if (material.equals(Material.FABRIC)) {
                double fabricAmount = (super.getHeight() * super.getWidth() * super.getLength()) / FABRIC_AMOUNT_RATE;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0)
                        + roundDouble(fabricAmount));
            } else if (material.equals(Material.GLUE)) {
                double glueAmount = super.getWidth() * super.getLength() * GLUE_RATE;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0)
                        + roundDouble(glueAmount));
            }
        }
        return materialsTotal;
    }

}
