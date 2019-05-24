import catalog.Catalog;
import furniture.Furniture;
import furniture.FurnitureFactory;
import warehouse.Warehouse;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        // Desks
        Furniture redDesk = FurnitureFactory.createDesk("Red Desk", Furniture.Category.DESK,
                Arrays.asList(Furniture.Material.WOOD, Furniture.Material.STAINLESS_STEEL, Furniture.Material.SCREW),
                1.2, 0.8, 1.5, 150);
        Furniture officeDesk = FurnitureFactory.createDesk("Office desk", Furniture.Category.DESK,
                Arrays.asList(Furniture.Material.VENEER, Furniture.Material.PLASTIC, Furniture.Material.SCREW),
                1.2, 0.8, 2, 500);
        Furniture homeDesk = FurnitureFactory.createDesk("Home desk", Furniture.Category.DESK,
                Arrays.asList(Furniture.Material.VENEER, Furniture.Material.PLASTIC, Furniture.Material.SCREW),
                1.2, 0.6, 1.8, 400);
        Furniture lightDesk = FurnitureFactory.createDesk("Light desk", Furniture.Category.DESK,
                Arrays.asList(Furniture.Material.GLASS, Furniture.Material.PLASTIC, Furniture.Material.SCREW),
                1.2, 0.6, 1, 600);

        // Beds
        Furniture comfortBed = FurnitureFactory.createBed("Comfort bed", Furniture.Category.BED,
                Arrays.asList(Furniture.Material.WOOD, Furniture.Material.PLASTIC, Furniture.Material.SCREW),
                0.4, 1.8, 2.2, 2450, false);
        Furniture modernBed = FurnitureFactory.createBed("Modern bed", Furniture.Category.BED,
                Arrays.asList(Furniture.Material.MDF, Furniture.Material.STAINLESS_STEEL, Furniture.Material.SCREW),
                0.5, 1.5, 2.0, 1500, true);
        Furniture vintageBed = FurnitureFactory.createBed("Vintage bed", Furniture.Category.BED,
                Arrays.asList(Furniture.Material.VENEER, Furniture.Material.STAINLESS_STEEL, Furniture.Material.SCREW),
                0.3, 1.8, 1.9, 2450, false);
        Furniture kidsBed = FurnitureFactory.createBed("Kids bed", Furniture.Category.BED,
                Arrays.asList(Furniture.Material.MDF, Furniture.Material.PLASTIC, Furniture.Material.SCREW),
                0.3, 1, 1.8, 1000, true);

        // Sofas
        Furniture lazySofa = FurnitureFactory.createSofa("Lazy sofa", Furniture.Category.SOFA,
                Arrays.asList(Furniture.Material.MDF, Furniture.Material.PLASTIC, Furniture.Material.SCREW,
                        Furniture.Material.FABRIC, Furniture.Material.GLUE), 0.4, 1, 2,
                1450);
        Furniture officeSofa = FurnitureFactory.createSofa("Office sofa", Furniture.Category.SOFA,
                Arrays.asList(Furniture.Material.MDF, Furniture.Material.STAINLESS_STEEL, Furniture.Material.SCREW,
                        Furniture.Material.FABRIC, Furniture.Material.GLUE), 0.5, 1.2, 1.5,
                1000);
        Furniture homeSofa = FurnitureFactory.createSofa("Home sofa", Furniture.Category.SOFA,
                Arrays.asList(Furniture.Material.MDF, Furniture.Material.PLASTIC, Furniture.Material.SCREW,
                        Furniture.Material.FABRIC, Furniture.Material.GLUE), 0.4, 1, 2,
                1359);
        Furniture outdoorSofa = FurnitureFactory.createSofa("Outdoor sofa", Furniture.Category.SOFA,
                Arrays.asList(Furniture.Material.MDF, Furniture.Material.STAINLESS_STEEL, Furniture.Material.SCREW,
                        Furniture.Material.FABRIC, Furniture.Material.GLUE), 0.4, 1.5, 3.1,
                2099);

        // Chairs
        Furniture outdoorChair = FurnitureFactory.createChair("Outdoor chair", Furniture.Category.CHAIR,
                Arrays.asList(Furniture.Material.VENEER, Furniture.Material.PLASTIC, Furniture.Material.SCREW),
                0.5, 0.5, 0.5, 150);
        Furniture officeChair = FurnitureFactory.createChair("Office chair", Furniture.Category.CHAIR,
                Arrays.asList(Furniture.Material.WOOD, Furniture.Material.PLASTIC, Furniture.Material.SCREW),
                0.5, 0.5, 0.5, 99);
        Furniture kitchenChair = FurnitureFactory.createChair("Kitchen chair", Furniture.Category.CHAIR,
                Arrays.asList(Furniture.Material.WOOD, Furniture.Material.STAINLESS_STEEL, Furniture.Material.SCREW),
                0.7, 0.5, 0.5, 189);
        Furniture bossChair = FurnitureFactory.createChair("Boss chair", Furniture.Category.CHAIR,
                Arrays.asList(Furniture.Material.VENEER, Furniture.Material.STAINLESS_STEEL, Furniture.Material.SCREW),
                0.5, 0.5, 0.5, 250);

        // Wardrobes
        Furniture bedroomWardrobe = FurnitureFactory.createWardrobe("Bedroom wardrobe", Furniture.Category.WARDROBE,
                Arrays.asList(Furniture.Material.MDF, Furniture.Material.SCREW, Furniture.Material.GLUE), 1.8,
                0.6, 2.5, 2750, 6);
        Furniture officeWardrobe = FurnitureFactory.createWardrobe("Office wardrobe", Furniture.Category.WARDROBE,
                Arrays.asList(Furniture.Material.VENEER, Furniture.Material.SCREW, Furniture.Material.GLUE), 1.8,
                0.6, 3.5, 4500, 10);


        // Catalog
        Catalog catalog = new Catalog();
        catalog.add(redDesk);
        catalog.add(officeDesk);
        catalog.add(homeDesk);
        catalog.add(lightDesk);
        catalog.add(comfortBed);
        catalog.add(modernBed);
        catalog.add(vintageBed);
        catalog.add(kidsBed);
        catalog.add(lazySofa);
        catalog.add(officeSofa);
        catalog.add(homeSofa);
        catalog.add(outdoorSofa);
        catalog.add(outdoorChair);
        catalog.add(officeChair);
        catalog.add(kitchenChair);
        catalog.add(bossChair);
        catalog.add(bedroomWardrobe);
        catalog.add(officeWardrobe);

        System.out.println("There's a catalog.");
        System.out.println(catalog.getCatalogInJsonFormat());
        System.out.println("\n");

        // Warehouse
        Warehouse warehouse = new Warehouse();
        // Adding material to warehouse
        warehouse.addMaterial(Furniture.Material.WOOD, 100);
        warehouse.addMaterial(Furniture.Material.MDF, 100);
        warehouse.addMaterial(Furniture.Material.VENEER, 100);
        warehouse.addMaterial(Furniture.Material.STAINLESS_STEEL, 100);
        warehouse.addMaterial(Furniture.Material.PLASTIC, 100);
        warehouse.addMaterial(Furniture.Material.FABRIC, 100);
        warehouse.addMaterial(Furniture.Material.SCREW, 10000);
        warehouse.addMaterial(Furniture.Material.GLUE, 100);

        System.out.println("Materials in warehouse");
        System.out.println(warehouse.getMaterials());
        System.out.println("\n");
        System.out.println("Materials amount by type");
        System.out.println(warehouse.getMaterialByType(Furniture.Material.FABRIC));
        System.out.println("\n");

        // Adding furniture to warehouse
        warehouse.add(redDesk, 3);
        warehouse.add(comfortBed, 5);
        warehouse.add(kidsBed, 10);
        warehouse.add(vintageBed, 1);
        warehouse.add(officeDesk, 25);
        warehouse.add(homeDesk, 2);
        warehouse.add(lazySofa, 2);
        warehouse.add(officeSofa, 5);
        warehouse.add(homeSofa, 1);
        warehouse.add(outdoorSofa, 9);
        warehouse.add(outdoorChair, 25);
        warehouse.add(officeChair, 15);
        catalog.add(kitchenChair);
        warehouse.add(bossChair, 4);
        warehouse.add(bedroomWardrobe, 1);
        warehouse.add(officeWardrobe, 2);

        System.out.println("All furniture in warehouse");
        System.out.println(warehouse.getFurnitures());
        System.out.println("\n");

        System.out.println("Get furniture by type");
        System.out.println(warehouse.getFurnitureByType(Furniture.Category.BED));
        System.out.println("\n");

        System.out.println("Get furniture by model name");
        System.out.println(warehouse.getFurnitureByModelName("Outdoor sofa"));
        System.out.println("\n");

        System.out.println("Get all furniture counted by model name");
        System.out.println(warehouse.getFurnitureByModel());

        System.out.println("\n");
        System.out.println("Furniture by amount and category in warehouse");
        System.out.println(warehouse.getFurnitureAmount());
        System.out.println("\n");

        System.out.println("What materials and how much to build 1 Outdoor sofa");
        System.out.println(outdoorSofa.getMaterialsAmount());
        System.out.println("\n");

        System.out.println("Can we build 4 Outdoor sofas?");
        System.out.println(warehouse.canManufacture(outdoorSofa, 4));
        System.out.println("\n");

        System.out.println("Can we build 30 Outdoor sofas?");
        System.out.println(warehouse.canManufacture(outdoorSofa, 30));
        System.out.println("\n");

        System.out.println("How many Comfort beds we can make with materials in warehouse?");
        System.out.println(warehouse.getPossibleManufacturingAmount(comfortBed));
        System.out.println("\n");

        warehouse.removeFurniture("Office desk", 150);

        // Map<String, String> map = Map.of("key1","value1", "key2", "value2");
        // System.out.println(map);
    }
}
