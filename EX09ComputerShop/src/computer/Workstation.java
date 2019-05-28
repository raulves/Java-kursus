package computer;

import catalog.Catalog;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Workstation implements UseCase {

    private final BigDecimal USECASE_COEFFICIENT = new BigDecimal("1.5");

    @Override
    public List<Computer> getComputers(Catalog catalog) {
        List<Computer> computers = catalog.generateComputers();

        // Protsessorile lisan koefitsiendi
        for (Computer computer : computers) {
            BigDecimal newPointsForProcessor = computer.getProcessor().getPerformancePoints()
                    .divide(new BigDecimal("2"), 2, RoundingMode.CEILING).multiply(USECASE_COEFFICIENT);
            computer.setPerformancePointsTotal(computer.getPerformancePointsTotal().add(newPointsForProcessor));
        }
        return catalog.generateComputers();
    }
}
