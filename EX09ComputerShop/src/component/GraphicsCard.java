package component;

public class GraphicsCard extends ComputerComponent {

    private String name;
    private Integer energy;
    private Integer performancePoints;
    private Integer price;

    public GraphicsCard(String name, Integer energy, Integer performancePoints, Integer price) {
        this.name = name;
        this.energy = energy;
        this.performancePoints = performancePoints;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getEnergy() {
        return energy;
    }

    public Integer getPerformancePoints() {
        return performancePoints;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPerformancePoints(Integer points) {
        this.performancePoints = points;
    }

    @Override
    public String toString() {
        return "GraphicsCard{" +
                "name='" + name + '\'' +
                ", energy=" + energy +
                ", performancePoints=" + performancePoints +
                ", price=" + price +
                '}';
    }
}
