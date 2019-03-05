package ee.taltech.iti0202.parking.parkinglot;

import ee.taltech.iti0202.parking.car.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Accepts all cars if the queue size is less than 5.
 * Small car (size 1) with the highest priority can park alone.
 * Otherwise small cars (size 1) can share a slot if they have the same priority.
 * If there are cars with highest priority in the queue, then cars with common priority (if parked)
 * will be sent to the queue to make room for highest priority cars (life is unfair).
 *
 */
public class PriorityParkingLot extends ParkingLot {
    /**
     * Initialize the parking slot with the given width and height.
     *
     * @param height Length of verical side.
     * @param width  Length of horizontal side.
     */
    public PriorityParkingLot(int height, int width) {
        super(height, width);
        this.parkingLotType = "priority";
    }

    @Override
    public void processQueue() {
        List<Car> waitingList = List.copyOf(getCarsInQueue());
        List<Car.PriorityStatus> priorities = new ArrayList<>();
        priorities.add(Car.PriorityStatus.HIGHEST);
        priorities.add(Car.PriorityStatus.PRIORITY);
        priorities.add(Car.PriorityStatus.COMMON);

        List<Integer> sizes = new ArrayList<>();
        sizes.add(1);
        sizes.add(2);
        sizes.add(4);

        while (availableLots < totalLots && getCarsInQueue().size() > 0) {
            for (Car.PriorityStatus priority : priorities) {
                for (Integer size : sizes) {
                    for (Car car : waitingList) {
                        if (priority.equals(car.getPriorityStatus()) && size == car.getSize()) {
                            car.setParkedWhere(this);
                            parkedCars.add(car);
                            carsInQueue.remove(car);
                            if (car.getPriorityStatus().equals(Car.PriorityStatus.HIGHEST) && car.getSize() == 1) {
                                availableLots++;
                            } else if (car.getSize() == 1) {
                                availableLots += 0.5;
                            } else {
                                availableLots++;
                            }
                        }
                    }
                }
            }
        }

    }
}