package component;

import java.math.BigDecimal;

public class Processor extends ComputerComponent {

    private String name;
    private ProcessorSocket socket;
    private Integer energy;
    private BigDecimal performancePoints;
    private Integer price;

    public Processor(String name, ProcessorSocket socket, Integer energy, BigDecimal performancePoints, Integer price) {
        this.name = name;
        this.socket = socket;
        this.energy = energy;
        this.performancePoints = performancePoints;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public ProcessorSocket getSocket() {
        return socket;
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
        return "Processor{" +
                "name='" + name + '\'' +
                ", socket=" + socket +
                ", energy=" + energy +
                ", performancePoints=" + performancePoints +
                ", price=" + price +
                '}';
    }
}
