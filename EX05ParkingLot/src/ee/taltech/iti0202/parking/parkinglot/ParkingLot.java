package ee.taltech.iti0202.parking.parkinglot;

import ee.taltech.iti0202.parking.car.Car;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Parking lot is a rectangular area with fixed with and height.
 * Well, rather 2 dimensions on the ground,
 * but as you represent in on the screen, then height can be seen as
 * the vertical axis.
 * The rectangle is filled with parking slots.
 * 3 x 4 parking lot has 12 slots.
 * The size of a slot is 2 units.
 * This means, that car with size 2 fits there perfectly.
 * Car with size 1 takes half the slot, so it could be
 * theoretically shared between 2 small cars.
 * Car with size 4 takes two consecutive slots.
 *
 * Each concrete parking lot type (subclass)
 * has its own rules about which cars it accepts
 * in its queue and how the queue is processed.
 * See the class description for more information.
 */
abstract public class ParkingLot {

    private final int width;
    private final int height;
    protected int totalLots;
    private Car[][] parkingSlot;  // Car objektid lähevad sisse.
    private Car[][][] parkingSlotMultiLevel;
    protected String parkingLotType;
    protected List<Car> carsInQueue;
    protected List<Car> parkedCars;

    /**
     * Initialize the parking slot with the given width and height.
     *
     * @param height Length of vertical side.
     * @param width Length of horizontal side.
     */
    public ParkingLot(int height, int width) {
        this.totalLots = height * width;
        this.width = width;
        this.height = height;
        this.parkingSlot = new Car[height][width];
        this.carsInQueue = new ArrayList<>();
        this.parkedCars = new ArrayList<>();

    }

    public ParkingLot(int height, int width, int levels) {
        this.totalLots = height * width * levels;
        this.width = width;
        this.height = height;
        this.parkingSlotMultiLevel = new Car[height][width][levels];
        this.carsInQueue = new ArrayList<>();
        this.parkedCars = new ArrayList<>();
    }


    /**
     * Adds a car to priority queue.
     * Car can be in a queue only once.
     * @param car Car to be added
     */
    public boolean addToQueue(Car car) {
        if (!carsInQueue.contains(car)) {
            carsInQueue.add(car);
            return true;
        }
        return false;
    }

    /**
     * Processes the queue.
     *
     * The cars are taken from the queue in specified order.
     * If the first car in the queue cannot be parked
     * the process will wait. Also, if the queue is empty, process waits.
     * Otherwise the process should be "running" all the time.
     * In reality you should call this method from other methods
     * which could initialize the process.
     *
     */
    abstract public void processQueue();



    /**
     * Returns a list of parked cars in the order they were received from the queue.
     * @return A list of parked cars.
     */
    public List<Car> getParkedCars() {
        return parkedCars;
    }

    /**
     * Returns string presentation of the parking lot.
     *
     * Each slot takes 2x2 chars.
     * Size 1 is represented by 1x2 (height, width) area
     * Empty slot is represented by dots (.):
     *
     * Empty table with width 3, height 2:
     * ......
     * ......
     * ......
     * ......
     *
     * One large priority car:
     * P3P3..
     * P3P3..
     * ......
     * ......
     *
     * + one small highest priority car:
     * P3P3H1
     * P3P3..
     * ......
     * ......
     *
     * + medium common car:
     * P3P3H1
     * P3P3..
     * C2....
     * C2....
     *
     * @return String representation of the parking lot
     */
    public String getTable() {
        String[][] parkingArea = new String[width * 2][height * 2];
        String result = "";
        for (String[] strings : parkingArea) {
            Arrays.fill(strings, ".");
            result += Arrays.toString(strings).replace(",", "").replace("[", "").replace("]", "");
            result += "\n";
        }


        return result.substring(0, result.length() - 1);
    }


    public Car[][] getParkingSlot() {
        return parkingSlot;
    }

    public String getParkingLotType() {
        return parkingLotType;
    }

    public List<Car> getCarsInQueue() {
        return carsInQueue;
    }
}

