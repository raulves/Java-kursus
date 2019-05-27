package computer;

import catalog.Catalog;

import java.math.BigDecimal;
import java.util.List;

public class Gaming implements UseCase {

    private final BigDecimal USECASE_COEFFICIENT = new BigDecimal("1.3");

    @Override
    public List<Computer> getComputers(Catalog catalog) {
        List<Computer> computers = catalog.generateComputers();

        for (Computer computer : computers) {
            BigDecimal newPoints = computer.getGraphicsCard().getPerformancePoints().multiply(USECASE_COEFFICIENT);
            computer.getGraphicsCard().setPerformancePoints(newPoints);
        }
        return catalog.generateComputers();
    }
}
