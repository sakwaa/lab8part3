/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

/**
 *
 * @author Benjamin Ramirez
 */
public class Floor {

    protected int floor_num;
    protected int passengers_up;
    protected int passengers_down;
    private boolean goingUp = true;
    private final Building building;

    public Floor(Building building, int floor) {
        this.building = building;
        this.floor_num = floor;
        this.passengers_up = 0;
        this.passengers_down = 0;
    }

    public void unloadPassengers(ElevatorModel elev, boolean going_up) {
        int passengers = going_up ? passengers_up : passengers_down;
        for (; passengers > 0; passengers--) {
            try {
                elev.boardPassenger(1);
                throw new ElevatorFullException();
            } catch (ElevatorFullException e) {
                System.out.println(e.getMessage());
                elev.registerRequest(floor_num, going_up);
                break;
            }
        }

        if (going_up) {
            passengers_up = passengers;
        } else {
            passengers_down = passengers;
        }
    }

    /**
     * Testing function
     */
    public void addPassenger(boolean going_up) {
        if (going_up) {
            goingUp = true;
            passengers_up++;
        } else {
            goingUp = false;
            passengers_down++;
        }
    }
    
    public int passengersWaiting() {
        return (this.passengers_up + this.passengers_down);
    }
    
}
