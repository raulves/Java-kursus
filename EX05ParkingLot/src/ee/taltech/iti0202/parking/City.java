package ee.taltech.iti0202.parking;
import ee.taltech.iti0202.parking.car.Car;
import ee.taltech.iti0202.parking.parkinglot.ParkingLot;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class City {
    private static List<City> cities = new ArrayList<>();
    private String name;
    private List<ParkingLot> parkingLotsInCity;

    public City(String name) {
        this.name = name;
        this.parkingLotsInCity = new ArrayList<>();
        cities.add(this);
    }

    /**
     * Adds a parking lot.
     * A parking lot can exist only once.
     * @param parkingLot Parking lot to be added.
     * @return true if parking lot was added.
     */
    public boolean addParkingLot(ParkingLot parkingLot) {
        if (parkingLotsInCity.contains(parkingLot)) {

            return false;
        }
        for (City city : cities) {
            if (city.parkingLotsInCity.contains(parkingLot)) {
                return false;
            }
        }
        parkingLotsInCity.add(parkingLot);
        return true;
    }

    /**
     * Tries to send a car to a parking lot.
     * If the parking lot accepts this car
     * the car will be added to the queue of the parking lot.
     * The chosen parking lot is returned.
     * If several parking lots can take the car, use the one
     * with the smallest queue.
     * If several have the same size queue, use the one
     * which was added earlier.
     * Or empty in case the car cannot be parked anywhere
     * or the car has already been parked.
     * @param car Car to be sent to parking lot
     * @return Parking lot where the car will be sent into queue.
     *          empty() in case no parking lot is suitable.
     */
    public Optional<ParkingLot> parkCar(Car car) {

        // Kontrollime, kas auto on juba järjekorras/pargitud. Valime parklad, kuhu auto vastu võetakse.
        List<ParkingLot> acceptedParkingLots = new ArrayList<>();
        for (ParkingLot parkingLot : parkingLotsInCity) {
            if (parkingLot.getCarsInQueue().contains(car) || parkingLot.getParkedCars().contains(car)) {
                return Optional.empty();
            }
            if (acceptParkinglot(parkingLot, car)) {
                acceptedParkingLots.add(parkingLot);
            }

        }
        if (acceptedParkingLots.size() == 0) {
            return Optional.empty();
        }
        // Kui valikusse jäi ainult üks parkla, siis lisatakse auto sinna.
        if (acceptedParkingLots.size() == 1) {
            acceptedParkingLots.get(0).addToQueue(car);
            acceptedParkingLots.get(0).processQueue();
            return Optional.of(acceptedParkingLots.get(0));
        }
        // Kui valikusse jäi mitu parklat, siis vaadatakse, kus kõige väiksem järjekord.
        List<ParkingLot> shortestQueueParkingLot = shortestQueue(acceptedParkingLots);
        if (shortestQueueParkingLot.size() >= 1) {
            shortestQueueParkingLot.get(0).addToQueue(car);
            shortestQueueParkingLot.get(0).processQueue();
            return Optional.of(shortestQueueParkingLot.get(0));
        }


        return Optional.empty();
    }

    private List<ParkingLot> shortestQueue(List<ParkingLot> checkParkinglotQueue) {
        List<ParkingLot> parkinglots = checkParkinglotQueue;
        int minQueue = parkinglots.get(0).getCarsInQueue().size();
        for (ParkingLot parkingLot : parkinglots) {
            if (parkingLot.getCarsInQueue().size() < minQueue) {
                minQueue = parkingLot.getCarsInQueue().size();
            }
        }
        List<ParkingLot> shortestQueuePL = new ArrayList<>();

        for (ParkingLot parkinglot : parkinglots) {
            if (parkinglot.getCarsInQueue().size() == minQueue) {
                shortestQueuePL.add(parkinglot);
            }
        }

        return shortestQueuePL;
    }

    private boolean acceptParkinglot(ParkingLot parkingLot, Car car) {
        if (parkingLot.getParkingLotType().equals("small") && car.getSize() == 1) {
            return true;
        } else if (parkingLot.getParkingLotType().equals("priority") && parkingLot.getCarsInQueue().size() < 5) {
            return true;
        } else if (parkingLot.getParkingLotType().equals("multi") && parkingLot.getCarsInQueue().size() <= 10) {
            return true;
        }
        return false;
    }
    
    /**
     * Gets all parking lots in a city.
     * @return List of parking lots.
     */
    public List<ParkingLot> getParkingLots() {
        return parkingLotsInCity;
    }

    /**
     * Return a map where for every priority-size pair a count of cars is mapped.
     * Keys are in format XY
     * where X = {H, P, C} (highest, priority, common)
     * Y = {1, 2, 4} size
     * @return map with priority-size counts
     */
    public Map<String, Integer> getParkedCarCountBySizeAndPriority() {
        Map<String, Integer> parkedCarsBySizePriority = new HashMap<>();
        parkedCarsBySizePriority.put("H1", getParkedCarCount(Car.PriorityStatus.HIGHEST, 1));
        parkedCarsBySizePriority.put("H2", getParkedCarCount(Car.PriorityStatus.HIGHEST, 2));
        parkedCarsBySizePriority.put("H4", getParkedCarCount(Car.PriorityStatus.HIGHEST, 4));
        parkedCarsBySizePriority.put("P1", getParkedCarCount(Car.PriorityStatus.PRIORITY, 1));
        parkedCarsBySizePriority.put("P2", getParkedCarCount(Car.PriorityStatus.PRIORITY, 2));
        parkedCarsBySizePriority.put("P4", getParkedCarCount(Car.PriorityStatus.PRIORITY, 4));
        parkedCarsBySizePriority.put("C1", getParkedCarCount(Car.PriorityStatus.COMMON, 1));
        parkedCarsBySizePriority.put("C2", getParkedCarCount(Car.PriorityStatus.COMMON, 2));
        parkedCarsBySizePriority.put("C4", getParkedCarCount(Car.PriorityStatus.COMMON, 4));



        return parkedCarsBySizePriority;
    }

    /**
     * Gets car count in queue by priority status and size.
     * @param priorityStatus (highest, priority, common)
     * @param size (1, 2, 4)
     * @return Count of cars in queue.
     */
    public int getCarCountInQueue(Car.PriorityStatus priorityStatus, int size) {
        List<Car> carsInQueue = new ArrayList<>();
        for (ParkingLot parkingLot : parkingLotsInCity) {
            carsInQueue.addAll(parkingLot.getCarsInQueue());
        }
        List<Car> carInQueueByPrioritySize = carsInQueue.stream()
                .filter(car -> car.getPriorityStatus().equals(priorityStatus))
                .filter(car -> car.getSize() == size)
                .collect(toList());
        return carInQueueByPrioritySize.size();
    }

    /**
     * Gets parked car count by priority status and size.
     * @param priorityStatus (highest, priority, common)
     * @param size (1, 2, 4)
     * @return Count of parked cars.
     */
    public int getParkedCarCount(Car.PriorityStatus priorityStatus, int size) {
        List<Car> parkedCars = new ArrayList<>();
        for (ParkingLot parkingLot : parkingLotsInCity) {
            parkedCars.addAll(parkingLot.getParkedCars());
        }
        List<Car> parkedCarsByPrioritySize = parkedCars.stream()
                .filter(car -> car.getPriorityStatus().equals(priorityStatus))
                .filter(car -> car.getSize() == size)
                .collect(toList());
        return parkedCarsByPrioritySize.size();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}