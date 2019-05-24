package furniture.sofa;

import com.google.gson.annotations.SerializedName;
import furniture.Furniture;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sofa extends Furniture {

    @SerializedName("Model name")
    private String modelName;
    private Furniture.Category category;
    private List<Material> materials;
    private double height;
    private double width;
    private double length;
    private double price;
    @SerializedName("Materials needed")
    private Map<Material, Double> materialsAmount;

    public Sofa(String modelName, Category category, List<Material> materials, double height, double width,
                double length, double price) {
        this.modelName = modelName;
        this.category = category;
        this.materials = materials;
        this.height = height;
        this.width = width;
        this.length = length;
        this.price = price;
        this.materialsAmount = calculateMaterialsAmount(materials, height, width, length);
    }

    @Override
    public String toString() {
        return "Sofa{" +
                "modelName='" + modelName + '\'' +
                ", category=" + category +
                ", materials=" + materials +
                ", height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", price=" + price +
                '}';
    }

    @Override
    public String getModelName() {
        return modelName;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public List<Material> getMaterials() {
        return materials;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isStorageSpace() {
        return false;
    }

    @Override
    public Map<Material, Double> getMaterialsAmount() {
        return materialsAmount;
    }

    @Override
    public Map<Material, Double> calculateMaterialsAmount(List<Material> materials, double height, double width, double length) {
        Map<Material, Double> materialsTotal = new HashMap<>();

        for (Material material : materials) {
            if (material.equals(Material.MDF)) {
                double baseMaterialAmountM2 = width * length + height * length;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(baseMaterialAmountM2));
            } else if (Arrays.asList(Material.STAINLESS_STEEL, Material.PLASTIC).contains(material)) {
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + 4.0);
            } else if (material.equals(Material.SCREW)) {
                double screwsAmount = height * length * 100;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(screwsAmount));
            } else if (material.equals(Material.FABRIC)) {
                double fabricAmount = (height * width * length) / 2;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(fabricAmount));
            } else if (material.equals(Material.GLUE)) {
                double glueAmount = width * length * 0.1;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(glueAmount));
            }
        }
        return materialsTotal;
    }
}
