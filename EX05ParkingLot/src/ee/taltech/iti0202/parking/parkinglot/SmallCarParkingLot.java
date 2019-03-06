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

        while (getCarsInQueue().size() > 0) {
            String table = getTable();
            if (table.contains("..")) {
                Car nextCar = carsInQueue.remove();
                nextCar.setParkedWhere(this);
                nextCar.setInQueue("NO");
                parkedCars.add(nextCar);
                carsInQueue.remove(nextCar);
            }

        }
    }
}