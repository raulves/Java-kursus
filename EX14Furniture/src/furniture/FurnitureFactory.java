package furniture;

import furniture.bed.Bed;
import furniture.chair.Chair;
import furniture.desk.Desk;
import furniture.sofa.Sofa;
import furniture.wardrobe.Wardrobe;

import java.util.List;

public class FurnitureFactory {

    public static Furniture createBed(String modelName, Furniture.Category category,
                                         List<Furniture.Material> materials, double height, double width,
                                         double length, double price, boolean storageSpace) {
        return new Bed(modelName, category, materials, height, width, length, price, storageSpace);
    }

    public static Furniture createChair(String modelName, Furniture.Category category, List<Furniture.Material> materials,
                                        double height, double width, double length, double price) {
        return new Chair(modelName, category, materials, height, width, length, price);
    }

    public static Furniture createDesk(String modelName, Furniture.Category category, List<Furniture.Material> materials,
                                       double height, double width, double length, double price) {
        return new Desk(modelName, category, materials, height, width, length, price);
    }

    public static Furniture createWardrobe(String modelName, Furniture.Category category, List<Furniture.Material> materials,
                                           double height, double width, double length, double price, int drawers) {
        return new Wardrobe(modelName, category, materials, height, width, length, price, drawers);
    }

    public static Furniture createSofa(String modelName, Furniture.Category category, List<Furniture.Material> materials,
                                       double height, double width, double length, double price) {
        return new Sofa(modelName, category, materials, height, width, length, price);
    }
}
