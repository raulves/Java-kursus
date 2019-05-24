package furniture;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public abstract class Furniture {

    public abstract String getModelName();
    public abstract Furniture.Category getCategory();
    public abstract List<Material> getMaterials();
    public abstract double getHeight();
    public abstract double getLength();
    public abstract double getWidth();
    public abstract double getPrice();
    public abstract boolean isStorageSpace();
    public abstract Map<Material, Double> getMaterialsAmount();

    public abstract Map<Material, Double> calculateMaterialsAmount(List<Material> materials, double height, double width, double length);

    public Double roundDouble(Double value) {
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(df.format(value));
    }

    public enum Category {
        BED, CHAIR, DESK, SOFA, WARDROBE
    }

    public enum Material {
        VENEER, MDF, WOOD ,STAINLESS_STEEL, PLASTIC, FABRIC, SCREW, GLUE, GLASS
    }

    @Override
    public String toString() {
        return "Furniture{}";
    }
}
