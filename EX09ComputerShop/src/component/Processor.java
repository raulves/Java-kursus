package component;

public class Processor extends ComputerComponent {

    private String name;
    private ProcessorSocket socket;
    private Integer energy;
    private Integer performancePoints;
    private Integer price;

    public Processor(String name, ProcessorSocket socket, Integer energy, Integer performancePoints, Integer price) {
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
        return "Processor{" +
                "name='" + name + '\'' +
                ", socket=" + socket +
                ", energy=" + energy +
                ", performancePoints=" + performancePoints +
                ", price=" + price +
                '}';
    }
}
