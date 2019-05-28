package computer;

import component.GraphicsCard;
import component.HardDrive;
import component.Memory;
import component.Motherboard;
import component.PowerSupplyUnit;
import component.Processor;

public class ComputerBuilder {
    private Processor processor;
    private Motherboard motherboard;
    private GraphicsCard graphicsCard;
    private HardDrive hardDrive;
    private Memory memory;
    private PowerSupplyUnit powerSupplyUnit;

    public ComputerBuilder setProcessor(Processor processor) {
        this.processor = processor;
        return this;
    }

    public ComputerBuilder setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
        return this;
    }

    public ComputerBuilder setGraphicsCard(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    public ComputerBuilder setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
        return this;
    }

    public ComputerBuilder setMemory(Memory memory) {
        this.memory = memory;
        return this;
    }

    public ComputerBuilder setPowerSupplyUnit(PowerSupplyUnit powerSupplyUnit) {
        this.powerSupplyUnit = powerSupplyUnit;
        return this;
    }

    public Computer createComputer() {
        return new Computer(processor, motherboard, graphicsCard, hardDrive, memory, powerSupplyUnit);
    }
}