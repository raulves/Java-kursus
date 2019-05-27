package main;

import catalog.Catalog;
import component.*;
import computer.Default;
import computer.Gaming;
import computer.Workstation;
import order.Order;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Motherboard mb1 = new Motherboard("ASUS ROG STRIX Z370-F GAMING", ComputerComponent.MemorySocket.DDR4,
                ComputerComponent.ProcessorSocket.LGA_1151, ComputerComponent.HardDriveSocket.HDD,
                new BigDecimal("100"), 2, 215);

        Motherboard mb2 = new Motherboard("ASUS ROG STRIX Z370-F GAMING", ComputerComponent.MemorySocket.DDR4,
                ComputerComponent.ProcessorSocket.LGA_1151, ComputerComponent.HardDriveSocket.HDD,
                new BigDecimal("100"), 2, 215);

        Processor p1 = new Processor("Intel® Core™ i7-8700K (12M Cache, up to 4.70 GHz)", ComputerComponent.ProcessorSocket.LGA_1151,
                95, new BigDecimal("100"), 440);

        GraphicsCard gc1 = new GraphicsCard("ASUS ROG Strix GeForce® GTX 1070 Ti 8GB Advanced edition",
                180, new BigDecimal("100"), 617);

        HardDrive hd1 = new HardDrive("Toshiba P300 2TB 7200 RPM", ComputerComponent.HardDriveSocket.HDD,
                7, new BigDecimal("50"), 60);

        HardDrive hd2 = new HardDrive("Toshiba P300 2TB 7200 RPM", ComputerComponent.HardDriveSocket.HDD,
                7, new BigDecimal("50"), 60);

        Memory m1 = new Memory("G.SKILL TridentZ RGB 2400MHz", ComputerComponent.MemorySocket.DDR4,
                20, new BigDecimal("50"), 109);

        PowerSupplyUnit psu1 = new PowerSupplyUnit("Seasonic M12II EVO Edition 520W", 520, 62);

        List<Motherboard> motherboards = List.of(mb1, mb2);
        List<Processor> processors = List.of(p1);
        List<GraphicsCard> graphicsCards = List.of(gc1);
        List<HardDrive> hardDrives = List.of(hd1, hd2);
        List<Memory> memories = List.of(m1);
        List<PowerSupplyUnit> powerSupplyUnits = List.of(psu1);

        Catalog catalog = new Catalog(processors, graphicsCards, hardDrives, memories, motherboards, powerSupplyUnits);
        System.out.println(catalog.generateComputers());

        Order basicComputer = new Order(new Gaming(), catalog);

        System.out.println(basicComputer.getBestComputer());

        Order overBudget = new Order(new Workstation(), 1000, catalog);
        System.out.println(overBudget.getBestComputer());


    }
}
