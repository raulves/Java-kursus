package component;

public class Memory extends ComputerComponent {

    private String name;
    private MemorySocket socket;
    private Integer energy;
    private Integer performancePoints;
    private Integer price;

    public Memory(String name, MemorySocket socket, Integer energy, Integer performancePoints, Integer price) {
        this.name = name;
        this.socket = socket;
        this.energy = energy;
        this.performancePoints = performancePoints;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public MemorySocket getSocket() {
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

    @Override
    public String toString() {
        return "Memory{" +
                "name='" + name + '\'' +
                ", socket=" + socket +
                ", energy=" + energy +
                ", performancePoints=" + performancePoints +
                ", price=" + price +
                '}';
    }
}
