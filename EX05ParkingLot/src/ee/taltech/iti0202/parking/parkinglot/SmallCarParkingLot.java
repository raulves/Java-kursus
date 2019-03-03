package ee.taltech.iti0202.parking.parkinglot;

import ee.taltech.iti0202.parking.car.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * This parking lot only accepts small cars (size 1).
 * Each parking slot only accepts one car.
 */
public class SmallCarParkingLot extends ParkingLot {
    /**
     * Initialize the parking slot with the given width and height.
     *
     * @param width
     * @param height
     */
    public SmallCarParkingLot(int width, int height) {
        super(width, height);
        this.parkingLotType = "small";


    }

    @Override
    public void processQueue() {
        List<Car> waitingList = List.copyOf(getCarsInQueue());
        List<Car.PriorityStatus> priorities = new ArrayList<>();
        priorities.add(Car.PriorityStatus.HIGHEST);
        priorities.add(Car.PriorityStatus.PRIORITY);
        priorities.add(Car.PriorityStatus.COMMON);

        while (getParkedCars().size() < totalLots && getCarsInQueue().size() > 0) {
            for (Car.PriorityStatus priority : priorities) {
                for (Car car : waitingList) {
                    if (priority.equals(car.getPriorityStatus())) {
                        car.setParkedWhere(this);
                        parkedCars.add(car);
                        carsInQueue.remove(car);
                    }
                }
            }
        }
    }
}