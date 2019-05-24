package furniture;

import com.google.gson.annotations.SerializedName;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public abstract class Furniture {

    @SerializedName("Model name")
    private String modelName;
    private Furniture.Category category;
    private List<Material> materials;
    private double height;
    private double width;
    private double length;
    private double price;


    public Furniture(String modelName, Category category, List<Material> materials, double height, double width, double length, double price) {
        this.modelName = modelName;
        this.category = category;
        this.materials = materials;
        this.height = height;
        this.width = width;
        this.length = length;
        this.price = price;
    }

    public abstract Map<Material, Double> calculateMaterialsAmount();

    protected Double roundDouble(Double value) {
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(df.format(value));
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "modelName='" + modelName + '\'' +
                ", category=" + category +
                ", materials=" + materials +
                ", height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", price=" + price +
                '}';
    }

    public enum Category {
        BED, CHAIR, DESK, SOFA, WARDROBE
    }

    public enum Material {
        VENEER, MDF, WOOD ,STAINLESS_STEEL, PLASTIC, FABRIC, SCREW, GLUE, GLASS
    }

    public String getModelName() {
        return modelName;
    }

    public Category getCategory() {
        return category;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getPrice() {
        return price;
    }
}
