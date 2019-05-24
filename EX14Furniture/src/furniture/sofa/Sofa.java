package furniture.sofa;

import furniture.Furniture;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sofa extends Furniture {



    public Sofa(String modelName, Category category, List<Material> materials, double height, double width,
                double length, double price) {
        super(modelName, category, materials, height, width, length, price);

    }

    @Override
    public Map<Material, Double> calculateMaterialsAmount() {
        Map<Material, Double> materialsTotal = new HashMap<>();

        for (Material material : super.getMaterials()) {
            if (material.equals(Material.MDF)) {
                double baseMaterialAmountM2 = super.getWidth() * super.getLength() + super.getHeight() * super.getLength();
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(baseMaterialAmountM2));
            } else if (Arrays.asList(Material.STAINLESS_STEEL, Material.PLASTIC).contains(material)) {
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + 4.0);
            } else if (material.equals(Material.SCREW)) {
                double screwsAmount = super.getHeight() * super.getLength() * 100;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(screwsAmount));
            } else if (material.equals(Material.FABRIC)) {
                double fabricAmount = (super.getHeight() * super.getWidth() * super.getLength()) / 2;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(fabricAmount));
            } else if (material.equals(Material.GLUE)) {
                double glueAmount = super.getWidth() * super.getLength() * 0.1;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(glueAmount));
            }
        }
        return materialsTotal;
    }

}
