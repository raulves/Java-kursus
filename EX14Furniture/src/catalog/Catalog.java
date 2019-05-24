package catalog;

import com.google.gson.Gson;
import furniture.Furniture;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Furniture> furnitures = new ArrayList<>();

    public void add(Furniture furniture) {
        if (!furnitures.contains(furniture)) {
            furnitures.add(furniture);
        }
    }

    public String getCatalogInJsonFormat() {
        Gson gson = new Gson();
        return gson.toJson(furnitures);
    }
}
