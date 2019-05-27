package component;

public class PowerSupplyUnit extends ComputerComponent {

    private String name;
    private Integer energy;
    private Integer price;

    public PowerSupplyUnit(String name, Integer energy, Integer price) {
        this.name = name;
        this.energy = energy;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getEnergy() {
        return energy;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "PowerSupplyUnit{" +
                "name='" + name + '\'' +
                ", energy=" + energy +
                ", price=" + price +
                '}';
    }
}
