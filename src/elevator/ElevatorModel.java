/**
 *
 * @author Benjamin Ramirez
 * @author Sakwa Alvitre
 * Lab 3 Part 3 
 */

package elevator;

public class ElevatorModel {
    protected static final int CAPACITY = 10;
    protected static final int NUM_FLOORS = 7;
    protected int current_floor;
    protected boolean moving_up;
    protected int[] passenger_targets;
    private final Building building;
    
    public ElevatorModel(Building building){ //constructor with building
        current_floor = 0;
        moving_up = true;
        passenger_targets = new int[NUM_FLOORS];
        this.building = building;
    }

    public void move() {

        if (moving_up) {
            current_floor++;
        } else {
            current_floor--;
        }
        
        if (current_floor == 0) {
            moving_up = true;
        } else if (current_floor == NUM_FLOORS - 1) {
            moving_up = false;
        }
        
        if (passenger_targets[current_floor] != 0) {
            stop();
        }

    }

    public void stop() {
        passenger_targets[current_floor] = 0;
        System.out.println("\r\nStopping on floor " + (current_floor + 1));
        System.out.println(this);
    }

    public void boardPassenger(int floor) throws ElevatorFullException {
        //adds a passenger wanting to go to the target floor
        int passengers = passengers();

        try {
            if (passengers < CAPACITY) {
                
            floor--;
            passenger_targets[floor]++;
            }
            else {
                throw new ElevatorFullException();
            }
        } catch (ElevatorFullException e) {
            System.out.println("Sorry the elevator is full");
        }
    }

    public void registerRequest(int floor_num, boolean going_up) {
        //to be implemented
    }

    //get functions
    public int currentFLoor() {
        return this.current_floor;
    }
   
    public boolean getDirection(){
        return this.moving_up;
    }

    public int passengers() {
        int passengers = 0;
        for (int i = 0; i < passenger_targets.length; i++) {
            if (passenger_targets[i] > 0) {
                passengers += passenger_targets[i];
            }
        }
        return passengers;
    }

    public String toString() {
        int passengers = passengers();
        return "Current Passengers: " + passengers + "\r\nCurrent Floor: " + (current_floor + 1) + "\r\nDirection: " + (moving_up ? "Up" : "Down");
    }
}