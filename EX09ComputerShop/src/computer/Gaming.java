package computer;

import catalog.Catalog;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Gaming implements UseCase {

    private final BigDecimal USECASE_COEFFICIENT = new BigDecimal("1.5");

    @Override
    public List<Computer> getComputers(Catalog catalog) {
        List<Computer> computers = catalog.generateComputers();

        for (Computer computer : computers) {
            BigDecimal newPointsForVideo = computer.getGraphicsCard().getPerformancePoints()
                    .divide(new BigDecimal("2"), 2, RoundingMode.CEILING).multiply(USECASE_COEFFICIENT);
            computer.setPerformancePointsTotal(computer.getPerformancePointsTotal().add(newPointsForVideo));
        }
        return computers;
    }
}
