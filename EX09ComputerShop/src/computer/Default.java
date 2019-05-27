package computer;

import catalog.Catalog;

import java.util.List;

public class Default implements UseCase {

    @Override
    public List<Computer> getComputers(Catalog catalog) {
        return catalog.generateComputers();
    }
}
