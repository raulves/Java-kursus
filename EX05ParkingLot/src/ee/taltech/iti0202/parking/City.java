package ee.taltech.iti0202.parking;
import ee.taltech.iti0202.parking.car.Car;
import ee.taltech.iti0202.parking.parkinglot.ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class City {

    private String name;
    private static List<ParkingLot> parkingLotsInCity = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    /**
     * Adds a parking lot.
     * A parking lot can exist only once.
     * @param parkingLot Parking lot to be added.
     * @return true if parking lot was added.
     */
    public boolean addParkingLot(ParkingLot parkingLot) {
        if (!parkingLotsInCity.contains(parkingLot)) {
            parkingLotsInCity.add(parkingLot);
            System.out.println(true);
            return true;
        }
        System.out.println(false);
        return false;
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
        return Optional.empty();
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
        return null;
    }

    /**
     * Gets car count in queue by priority status and size.
     * @param priorityStatus (highest, priority, common)
     * @param size (1, 2, 4)
     * @return Count of cars in queue.
     */
    public int getCarCountInQueue(Car.PriorityStatus priorityStatus, int size) {
        return -1;
    }

    /**
     * Gets parked car count by priority status and size.
     * @param priorityStatus (highest, priority, common)
     * @param size (1, 2, 4)
     * @return Count of parked cars.
     */
    public int getParkedCarCount(Car.PriorityStatus priorityStatus, int size) {
        return -1;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}