package component;

import java.math.BigDecimal;

public class GraphicsCard extends ComputerComponent {

    private String name;
    private Integer energy;
    private BigDecimal performancePoints;
    private Integer price;

    public GraphicsCard(String name, Integer energy, BigDecimal performancePoints, Integer price) {
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

    public BigDecimal getPerformancePoints() {
        return performancePoints;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPerformancePoints(BigDecimal points) {
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
