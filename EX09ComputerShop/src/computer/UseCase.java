package computer;

import catalog.Catalog;

import java.util.List;

public interface UseCase {

    List<Computer> getComputers(Catalog catalog);
}
