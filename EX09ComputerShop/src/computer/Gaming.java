package computer;

import catalog.Catalog;
import java.util.List;

public class Gaming implements UseCase {

    private final Integer USECASE_COEFFICIENT = 2;

    @Override
    public List<Computer> getComputers(Catalog catalog) {
        List<Computer> computers = catalog.generateComputers();

        for (Computer computer : computers) {
            Integer newPointsForVideo = computer.getGraphicsCard().getPerformancePoints() / 2 * USECASE_COEFFICIENT;
            computer.setPerformancePointsTotal(computer.getPerformancePointsTotal() + newPointsForVideo);
        }
        return computers;
    }
}
