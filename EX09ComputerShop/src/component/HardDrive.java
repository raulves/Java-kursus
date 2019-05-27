package component;

public class HardDrive extends ComputerComponent {

    private String name;
    private HardDriveSocket socket;
    private Integer energy;
    private Integer performancePoints;
    private Integer price;

    public HardDrive(String name, HardDriveSocket socket, Integer energy, Integer performancePoints, Integer price) {
        this.name = name;
        this.socket = socket;
        this.energy = energy;
        this.performancePoints = performancePoints;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public HardDriveSocket getSocket() {
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
        return "HardDrive{" +
                "name='" + name + '\'' +
                ", socket=" + socket +
                ", energy=" + energy +
                ", performancePoints=" + performancePoints +
                ", price=" + price +
                '}';
    }
}
