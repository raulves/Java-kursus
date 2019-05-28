package furniture.bed;

import furniture.Furniture;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bed extends Furniture {

    private boolean storageSpace;
    private static final double BED_LEGS = 4;
    private static final int SCREWS_AMOUNT_RATE = 10;


    public Bed(String modelName, Category category, List<Material> materials, double height, double width,
               double length, double price, boolean storageSpace) {
        super(modelName, category, materials, height, width, length, price);
        this.storageSpace = storageSpace;

    }

    @Override
    public Map<Material, Double> calculateMaterialsAmount() {

        Map<Material, Double> materialsTotal = new HashMap<>();

        for (Material material : super.getMaterials()) {
            if (Arrays.asList(Material.VENEER, Material.MDF, Material.WOOD).contains(material)) {
                double baseMaterialAmountM2 = super.getWidth() * super.getLength()
                        + super.getHeight() * super.getLength();
                if (storageSpace) {
                    baseMaterialAmountM2 += super.getHeight() * super.getLength() * super.getWidth();
                }
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0)
                        + roundDouble(baseMaterialAmountM2));
            } else if (Arrays.asList(Material.STAINLESS_STEEL, Material.PLASTIC).contains(material)) {
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + BED_LEGS);
            } else if (material.equals(Material.SCREW)) {
                double screwsAmount = super.getWidth() * super.getLength() * SCREWS_AMOUNT_RATE;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0)
                        + roundDouble(screwsAmount));
            }
        }
        return materialsTotal;
    }

    public boolean isStorageSpace() {
        return storageSpace;
    }
}
