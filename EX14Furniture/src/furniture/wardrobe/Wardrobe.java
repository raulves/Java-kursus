package furniture.wardrobe;

import com.google.gson.annotations.SerializedName;
import furniture.Furniture;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wardrobe extends Furniture {

    @SerializedName("Model name")
    private String modelName;
    private Furniture.Category category;
    private List<Material> materials;
    private double height;
    private double width;
    private double length;
    private double price;
    private int drawers;
    @SerializedName("Materials needed")
    private Map<Material, Double> materialsAmount;

    public Wardrobe(String modelName, Category category, List<Material> materials, double height,
                    double width, double length, double price, int drawers) {
        this.modelName = modelName;
        this.category = category;
        this.materials = materials;
        this.height = height;
        this.width = width;
        this.length = length;
        this.price = price;
        this.drawers = drawers;
        this.materialsAmount = calculateMaterialsAmount(materials, height, width, length);
    }

    @Override
    public String toString() {
        return "Wardrobe{" +
                "modelName='" + modelName + '\'' +
                ", category=" + category +
                ", materials=" + materials +
                ", height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", price=" + price +
                ", drawers=" + drawers +
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
            if (Arrays.asList(Material.VENEER, Material.MDF, Material.WOOD).contains(material)) {
                double baseMaterialAmountM2 = (width * length + height * length) + getDrawers() * 0.5;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(baseMaterialAmountM2));
            } else if (material.equals(Material.SCREW)) {
                double screwsAmount = width * height * length * 50;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(screwsAmount));
            } else if (material.equals(Material.GLUE)) {
                double glueAmount = height * width * length * 0.1;
                materialsTotal.put(material, materialsTotal.getOrDefault(material, 0.0) + roundDouble(glueAmount));
            }
        }
        return materialsTotal;
    }

    public int getDrawers() {
        return drawers;
    }
}
