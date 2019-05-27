package computer;

import catalog.Catalog;

import java.math.BigDecimal;
import java.util.List;

public class Workstation implements UseCase {

    private final BigDecimal USECASE_COEFFICIENT = new BigDecimal("1.3");

    @Override
    public List<Computer> getComputers(Catalog catalog) {
        List<Computer> computers = catalog.generateComputers();

        // Protsessorile lisan koefitsiendi
        for (Computer computer : computers) {
            BigDecimal newPoints = computer.getProcessor().getPerformancePoints().multiply(USECASE_COEFFICIENT);
            computer.getProcessor().setPerformancePoints(newPoints);
        }
        return catalog.generateComputers();
    }
}
