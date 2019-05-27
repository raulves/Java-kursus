package component;

public class Motherboard extends ComputerComponent {

    private String name;
    private MemorySocket memorySocket;
    private ProcessorSocket processorSocket;
    private HardDriveSocket hardDriveSocket;
    private Integer performancePoints;
    private Integer socket16x;
    private Integer price;

    public Motherboard(String name, MemorySocket memorySocket, ProcessorSocket processorSocket,
                       HardDriveSocket hardDriveSocket, Integer performancePoints, Integer socket16x, Integer price) {
        this.name = name;
        this.memorySocket = memorySocket;
        this.processorSocket = processorSocket;
        this.hardDriveSocket = hardDriveSocket;
        this.performancePoints = performancePoints;
        this.socket16x = socket16x;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public MemorySocket getMemorySocket() {
        return memorySocket;
    }

    public ProcessorSocket getProcessorSocket() {
        return processorSocket;
    }

    public HardDriveSocket getHardDriveSocket() {
        return hardDriveSocket;
    }

    public Integer getPerformancePoints() {
        return performancePoints;
    }


    public Integer getSocket16x() {
        return socket16x;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Motherboard{" +
                "name='" + name + '\'' +
                ", memorySocket=" + memorySocket +
                ", processorSocket=" + processorSocket +
                ", hardDriveSocket=" + hardDriveSocket +
                ", performancePoints=" + performancePoints +
                ", socket16x=" + socket16x +
                ", price=" + price +
                '}';
    }
}
