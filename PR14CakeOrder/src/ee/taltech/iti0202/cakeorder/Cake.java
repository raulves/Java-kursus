package ee.taltech.iti0202.cakeorder;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cake {

    private String name;
    @SerializedName("BBD")
    private String bestBeforeDate;
    private double price;
    private double kg;
    private List<String> ingredients;
    @SerializedName("cake_id")
    private String cakeId;

    public Cake(String name, String bestBeforeDate, double price, double kg, List<String> ingredients) {
        this.name = name;
        this.bestBeforeDate = bestBeforeDate;
        this.price = price;
        this.kg = kg;
        this.ingredients = ingredients;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBestBeforeDate() {
        return bestBeforeDate;
    }

    public void setBestBeforeDate(String bestBeforeDate) {
        this.bestBeforeDate = bestBeforeDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getCakeId() {
        return cakeId;
    }

    public void setCakeId(String cakeId) {
        this.cakeId = cakeId;
    }

    @Override
    public String toString() {
        return name;
    }

}
