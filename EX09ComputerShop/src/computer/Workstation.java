package computer;

import catalog.Catalog;
import java.util.List;

public class Workstation implements UseCase {

    private final Integer USECASE_COEFFICIENT = 2;

    @Override
    public List<Computer> getComputers(Catalog catalog) {
        List<Computer> computers = catalog.generateComputers();

        // Protsessorile lisan koefitsiendi
        for (Computer computer : computers) {
            Integer newPointsForProcessor = computer.getProcessor().getPerformancePoints() / 2 * USECASE_COEFFICIENT;
            computer.setPerformancePointsTotal(computer.getPerformancePointsTotal() + newPointsForProcessor);
        }
        return catalog.generateComputers();
    }
}
