package component;

public class ComputerComponent {

    public enum ProcessorSocket {
        LGA_2011V3, LGA_2066, LGA_1151, LGA_1151V2, TR4, AM4, AM3, FM2
    }

    public enum HardDriveSocket {
        HDD ,SSD, M2, MSATA, SATA_DOM, PCI_EXPRESS, PATA
    }

    public enum MemorySocket {
        DDR1, DDR2, DDR3, DDR4, SDRAM
    }
}
