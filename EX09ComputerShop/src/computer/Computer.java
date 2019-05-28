package computer;

import component.GraphicsCard;
import component.HardDrive;
import component.Memory;
import component.Motherboard;
import component.PowerSupplyUnit;
import component.Processor;

import java.math.BigDecimal;

public class Computer {

    private Processor processor;
    private Motherboard motherboard;
    private GraphicsCard graphicsCard;
    private HardDrive hardDrive;
    private Memory memory;
    private PowerSupplyUnit powerSupplyUnit;
    private BigDecimal performancePointsTotal;

    public Computer(Processor processor, Motherboard motherboard, GraphicsCard graphicsCard, HardDrive hardDrive,
                    Memory memory, PowerSupplyUnit powerSupplyUnit) {
        this.processor = processor;
        this.motherboard = motherboard;
        this.graphicsCard = graphicsCard;
        this.hardDrive = hardDrive;
        this.memory = memory;
        this.powerSupplyUnit = powerSupplyUnit;
        this.performancePointsTotal = getComputerPerformancePoints();
    }

    public BigDecimal getPerformancePointsTotal() {
        return performancePointsTotal;
    }

    public void setPerformancePointsTotal(BigDecimal points) {
        this.performancePointsTotal = points;
    }

    public BigDecimal getComputerPerformancePoints() {
        return processor.getPerformancePoints().add(motherboard.getPerformancePoints())
                .add(graphicsCard.getPerformancePoints()).add(hardDrive.getPerformancePoints())
                .add(memory.getPerformancePoints());
    }


    public Integer getCost() {
        return processor.getPrice() + motherboard.getPrice() + graphicsCard.getPrice() + hardDrive.getPrice()
                + memory.getPrice() + powerSupplyUnit.getPrice();
    }

    public Processor getProcessor() {
        return processor;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public GraphicsCard getGraphicsCard() {
        return graphicsCard;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public Memory getMemory() {
        return memory;
    }

    public PowerSupplyUnit getPowerSupplyUnit() {
        return powerSupplyUnit;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor=" + processor +
                ", motherboard=" + motherboard +
                ", graphicsCard=" + graphicsCard +
                ", hardDrive=" + hardDrive +
                ", memory=" + memory +
                ", powerSupplyUnit=" + powerSupplyUnit +
                ", performancePointsTotal=" + performancePointsTotal +
                '}';
    }
}
