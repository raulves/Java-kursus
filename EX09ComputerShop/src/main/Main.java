package main;

import catalog.Catalog;
import component.ComputerComponent;
import component.GraphicsCard;
import component.HardDrive;
import component.Memory;
import component.Motherboard;
import component.PowerSupplyUnit;
import component.Processor;
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

        Motherboard mb2 = new Motherboard("BIOSTAR X470GT8", ComputerComponent.MemorySocket.DDR4,
                ComputerComponent.ProcessorSocket.AM4, ComputerComponent.HardDriveSocket.SATA,
                new BigDecimal("90"), 1, 175);

        Motherboard mb3 = new Motherboard("Gigabyte GA-A320M-H 1.1", ComputerComponent.MemorySocket.DDR4,
                ComputerComponent.ProcessorSocket.AM4, ComputerComponent.HardDriveSocket.SATA,
                new BigDecimal("70"), 1, 48);

        Processor p1 = new Processor("Intel® Core™ i7-8700K (12M Cache, up to 4.70 GHz)", ComputerComponent.ProcessorSocket.LGA_1151,
                95, new BigDecimal("100"), 440);

        Processor p2 = new Processor("Intel® Core™ i5-8400 Processor (9M Cache, up to 4.00 GHz)", ComputerComponent.ProcessorSocket.LGA_1151,
                65, new BigDecimal("90"), 216);

        Processor p3 = new Processor("AMD Ryzen™ 5 2600X Processor (16M Cache, up to 4.20 GHz)", ComputerComponent.ProcessorSocket.AM4,
                95, new BigDecimal("80"), 210);

        Processor p4 = new Processor("AMD Athlon 240GE", ComputerComponent.ProcessorSocket.AM4,
                35, new BigDecimal("50"), 72);

        Processor p5 = new Processor("AMD FX-4320", ComputerComponent.ProcessorSocket.AM3,
                95, new BigDecimal("30"), 50);

        Processor p6 = new Processor("Intel® Pentium® Processor G4500 (3M Cache, 3.50 GHz)", ComputerComponent.ProcessorSocket.LGA_1151,
                47, new BigDecimal("40"), 95);

        GraphicsCard gc1 = new GraphicsCard("ASUS ROG Strix GeForce® GTX 1070 Ti 8GB Advanced edition",
                180, new BigDecimal("100"), 617);

        GraphicsCard gc2 = new GraphicsCard("MSI GT 710", 100, new BigDecimal("40"), 49);

        GraphicsCard gc3 = new GraphicsCard("MSI Radeon RX 550", 400, new BigDecimal("80"), 132);

        HardDrive hd1 = new HardDrive("Toshiba P300 2TB 7200 RPM", ComputerComponent.HardDriveSocket.HDD,
                7, new BigDecimal("40"), 60);

        HardDrive hd2 = new HardDrive("SEAGATE Seagate IronWolf", ComputerComponent.HardDriveSocket.SATA,
                5, new BigDecimal("50"), 84);

        Memory m1 = new Memory("G.SKILL TridentZ RGB 2400MHz", ComputerComponent.MemorySocket.DDR4,
                20, new BigDecimal("50"), 109);

        Memory m2 = new Memory("CORSAIR 16GB RAMKit 2x8GB", ComputerComponent.MemorySocket.DDR4,
                30, new BigDecimal("50"), 271);

        PowerSupplyUnit psu1 = new PowerSupplyUnit("Seasonic M12II EVO Edition 520W", 520, 62);

        PowerSupplyUnit psu2 = new PowerSupplyUnit("Fortron FSP350-60EGN", 350, 59);

        PowerSupplyUnit psu3 = new PowerSupplyUnit("BitFenix Whisper", 450, 80);

        PowerSupplyUnit psu4 = new PowerSupplyUnit("Cooler Master", 750, 89);

        List<Motherboard> motherboards = List.of(mb1, mb2, mb3);
        List<Processor> processors = List.of(p1, p2, p3, p4, p5, p6);
        List<GraphicsCard> graphicsCards = List.of(gc1, gc2, gc3);
        List<HardDrive> hardDrives = List.of(hd1, hd2);
        List<Memory> memories = List.of(m1, m2);
        List<PowerSupplyUnit> powerSupplyUnits = List.of(psu1, psu2, psu3, psu4);

        Catalog catalog = new Catalog(processors, graphicsCards, hardDrives, memories, motherboards, powerSupplyUnits);
        System.out.println("Generated computers in catalog");
        System.out.println(catalog.generateComputers());
        System.out.println("\n");

        Order basicComputer = new Order(new Default(), 450, catalog);
        System.out.println("Get basic computer");
        System.out.println(basicComputer.getBestComputer());
        System.out.println("\n");

        Order gamingComputer = new Order(new Gaming(), catalog);
        System.out.println("Get gaming computer");
        System.out.println(gamingComputer.getBestComputer());
        System.out.println("\n");

        Order workComputer = new Order(new Workstation(), catalog);
        System.out.println("Get work computer");
        System.out.println(workComputer.getBestComputer());
        System.out.println("\n");

        Order gamingComputerWithBudget = new Order(new Gaming(), 1000, catalog);
        System.out.println("Get gaming computer with budget");
        System.out.println(gamingComputerWithBudget.getBestComputer());
        System.out.println("\n");

        Order workComputerWithBudget = new Order(new Workstation(), 500, catalog);
        System.out.println("Get work computer with budget");
        System.out.println(workComputerWithBudget.getBestComputer());
        System.out.println("\n");


    }
}
