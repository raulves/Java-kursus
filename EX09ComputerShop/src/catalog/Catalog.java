package catalog;

import component.GraphicsCard;
import component.HardDrive;
import component.Memory;
import component.Motherboard;
import component.PowerSupplyUnit;
import component.Processor;
import computer.Computer;
import computer.ComputerBuilder;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Processor> processors;
    private List<GraphicsCard> graphicsCards;
    private List<HardDrive> hardDrives;
    private List<Memory> memories;
    private List<Motherboard> motherboards;
    private List<PowerSupplyUnit> powerSupplyUnits;

    public Catalog(List<Processor> processors, List<GraphicsCard> graphicsCards, List<HardDrive> hardDrives,
                   List<Memory> memories, List<Motherboard> motherboards, List<PowerSupplyUnit> powerSupplyUnits) {
        this.processors = processors;
        this.graphicsCards = graphicsCards;
        this.hardDrives = hardDrives;
        this.memories = memories;
        this.motherboards = motherboards;
        this.powerSupplyUnits = powerSupplyUnits;
    }

    public List<Computer> generateComputers() {
        List<Computer> computers = new ArrayList<>();

        for (Motherboard motherboard : motherboards) {
            Motherboard mb = motherboard;
            Processor cpu = null;
            GraphicsCard gpu = null;
            HardDrive hd = null;
            Memory ram = null;
            PowerSupplyUnit psu = null;

            for (Processor processor : processors) {
                if (motherboard.getProcessorSocket().equals(processor.getSocket())) {
                    cpu = processor;
                } else {
                    cpu = null;
                }
                for (GraphicsCard card : graphicsCards) {
                    if (motherboard.getSocket16x() > 0) {
                        gpu = card;
                    } else {
                        gpu = null;
                    }
                    for (HardDrive drive : hardDrives) {
                        if (motherboard.getHardDriveSocket().equals(drive.getSocket())) {
                            hd = drive;
                        } else {
                            hd = null;
                        }
                        for (Memory memory : memories) {
                            if (motherboard.getMemorySocket().equals(memory.getSocket())) {
                                ram = memory;
                            } else {
                                ram = null;
                            }
                            for (PowerSupplyUnit unit : powerSupplyUnits) {
                                if (cpu != null && gpu != null && hd != null && ram != null) {
                                    int consumption = cpu.getEnergy() + gpu.getEnergy() + hd.getEnergy() + ram.getEnergy();
                                    if (unit.getEnergy() >= consumption) {
                                        psu = unit;
                                    } else {
                                        psu = null;
                                    }
                                }

                                if (cpu != null && gpu != null && hd != null && ram != null && psu != null) {
                                    computers.add(new ComputerBuilder()
                                    .setMotherboard(mb)
                                    .setProcessor(cpu)
                                    .setGraphicsCard(gpu)
                                    .setHardDrive(hd)
                                    .setMemory(ram)
                                    .setPowerSupplyUnit(psu)
                                    .createComputer());
                                }
                            }
                        }
                    }
                }
            }
        }

        return computers;
    }
}
