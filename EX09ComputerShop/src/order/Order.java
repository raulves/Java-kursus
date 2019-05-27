package order;

import catalog.Catalog;
import computer.Computer;
import computer.UseCase;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Order {

    private UseCase useCase;
    private Integer budget;
    private Catalog catalog;

    public Order(UseCase useCase, Catalog catalog) {
        this.useCase = useCase;
        this.catalog = catalog;
    }

    public  Order(UseCase useCase, Integer budget, Catalog catalog) {
        this.useCase = useCase;
        this.budget = budget;
        this.catalog = catalog;
    }

    // Saan arvutid läbi interface
    public List<Computer> getSuitableComputers() {
        return useCase.getComputers(catalog);
    }

    public Optional<Computer> getBestComputer() {

        if (budget != null) {
            return getSuitableComputers().stream()
                    .filter(x -> x.getCost() <= budget)
                    .max(Comparator.comparingInt(Computer::getPerformancePointsTotal));

        }
        return getSuitableComputers().stream()
                .max(Comparator.comparingInt(Computer::getPerformancePointsTotal));
    }
}
