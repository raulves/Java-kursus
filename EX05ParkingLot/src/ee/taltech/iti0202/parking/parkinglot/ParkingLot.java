package ee.taltech.iti0202.parking.parkinglot;

import ee.taltech.iti0202.parking.City;
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
    protected String parkingLotType;
    protected PriorityQueue<Car> carsInQueue;  // PriorityQueue  ja .peek meetod on seal!!!
    protected List<Car> parkedCars;


    /**
     * Initialize the parking slot with the given width and height.
     *
     * @param height Length of vertical side.
     * @param width Length of horizontal side.
     */
    public ParkingLot(int height, int width) {
        this.width = width;
        this.height = height;
        this.carsInQueue = new PriorityQueue<>();
        this.parkedCars = new ArrayList<>();

    }

    public ParkingLot(int height, int width, int levels) {
        this.width = width;
        this.height = height;
        this.carsInQueue = new PriorityQueue<>();
        this.parkedCars = new ArrayList<>();
    }


    /**
     * Adds a car to priority queue.
     * Car can be in a queue only once.
     * @param car Car to be added
     */
    public boolean addToQueue(Car car) {
        if (car.getParkedWhere() == null && car.getInQueue().equals("NO")) {
            car.setInQueue("YES");
            carsInQueue.add(car);
            processQueue();
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

    protected void processHelper() {
        while (carsInQueue.size() > 0) {
            Car car = carsInQueue.peek();
            boolean result = processCar(car);
            if (!result) {
                break;
            } else {
                car.setParkedWhere(this);
                car.setInQueue("NO");
                parkedCars.add(car);
                carsInQueue.remove(car);
            }


        }
    }
    // Siin peaksin küsima, kas uus auto mahub parklasse. Pean tegema kotnrolli igas suunas, kas auto mahub.
    protected boolean processCar(Car car) {
        Car[][] carsInP = carsInArray();
        for (Car[] cars : carsInP) {
            for (Car car1 : cars) {
                if (car1 == null) return true;
            }
        }
        return false;
    }

    // Siin paigutan autod parklasse
    protected Car[][] carsInArray() {
        List<Car> parkedCars = new ArrayList<>(getParkedCars());
        Car[][] carsIn = new Car[height * 2][width];

        for (int i = 0; i < carsIn.length; i += 2) {
            for (int j = 0; j < carsIn[i].length; j++) {
                if (parkedCars.size() > 0) {
                    carsIn[i][j] = parkedCars.get(0);
                    carsIn[i + 1][j] = parkedCars.get(0);
                    parkedCars.remove(parkedCars.get(0));
                }

            }
        }
        return carsIn;
    }



    /**
     * Returns a list of parked cars in the order they were received from the queue.
     * @return A list of parked cars.
     */
    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public void removeParkedCar(Car car) {
        parkedCars.remove(car);
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
        String result = "";

        if (this.getParkingLotType().equals("small")) {
            Car[][] parkedCars = carsInArray();
            String[][] parkedTable = new String[height * 2][width];

            for (int i = 0; i < parkedCars.length; i++) {
                for (int j = 0; j < parkedCars[i].length; j++) {
                    if (parkedCars[i][j] == null) {
                        parkedTable[i][j] = "..";

                    } else {
                        parkedTable[i][j] = parkedCars[i][j].getPriorityStatus().toString().substring(0, 1) + parkedCars[i][j].getSize();
                    }
                }
            }





            for (String[] strings : parkedTable) {
                result += Arrays.toString(strings).replace(",", "").replace("[", "").replace("]", "").replace(" ", "");
                result += "\n";
            }

        } else {
            return result;
        }


        return result.substring(0, result.length() - 1);
    }



    public String getParkingLotType() {
        return parkingLotType;
    }

    public List<Car> getCarsInQueue() {
        List<Car> carsWaitingQueue = new ArrayList<>(carsInQueue);
        return carsWaitingQueue;
    }
}
