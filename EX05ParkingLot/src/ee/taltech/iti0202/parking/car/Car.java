package ee.taltech.iti0202.parking.car;

import ee.taltech.iti0202.parking.parkinglot.ParkingLot;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a car with priority and size.
 * The size can be one of 1, 2, 4 (the code doesn't have to validate it).
 * This class implements Comparable interface.
 * This allows objects to be sorted in priority queue (or for sorting in general).
 * Cars with highest priority will be taken first, then with the "priority" priority
 * and then all the common cars.
 * If there are cars with the same priority, prefer cars with lower size.
 * So highest-1 (priority status-size) comes before highest-2 which comes before priority-1.
 */
public class Car implements Comparable<Car> {

    private PriorityStatus status;
    private int size;
    private ParkingLot parkedWhere;
    private String inQueue;



    public String getInQueue() {
        return inQueue;
    }

    public void setInQueue(String inQueue) {
        this.inQueue = inQueue;
    }

    public enum PriorityStatus {
        HIGHEST, PRIORITY, COMMON
    }

    @Override
    public int compareTo(Car o) {
        Map<PriorityStatus, Integer> priorityRate = new HashMap<>();
        priorityRate.put(PriorityStatus.HIGHEST, 3);
        priorityRate.put(PriorityStatus.PRIORITY, 2);
        priorityRate.put(PriorityStatus.COMMON, 1);

        if (this.getPriorityStatus() == o.getPriorityStatus()) {
            return this.getSize() - o.getSize();
        }
        if (priorityRate.get(this.getPriorityStatus()) > priorityRate.get(o.getPriorityStatus())) {
            return -1;
        } else {
            return 1;
        }
    }

    public Car(PriorityStatus status, int size) {
        this.status = status;
        this.size = size;
        this.parkedWhere = null;
        this.inQueue = "NO";
    }

    /**
     * Gets the priority of the car.
     * @return PriorityStatus
     */
    public PriorityStatus getPriorityStatus() {
        return status;
    }

    /**
     * Gets the size of the car.
     * @return Size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Finish parking. This car has finished parking.
     * The car should be removed from parking lot
     * (its slots will be empty).
     * Returns false, if the car is not parked currently.
     * Otherwise returns true.
     * @return True if the car was parking, false otherwise.
     */
    public boolean unpark() {

        if (parkedWhere == null) {
            return false;
        }


        parkedWhere.removeParkedCar(this);
        setParkedWhere(null);

       return true;
    }

    public void setParkedWhere(ParkingLot parkingLot) {
        parkedWhere = parkingLot;
    }

    public ParkingLot getParkedWhere() {
        return parkedWhere;
    }

    @Override
    public String toString() {
        return "Car{"
                + "status="
                + status
                + ", size="
                + size
                + ", parkedWhere="
                + parkedWhere
                + '}';
    }
}

