
package elevator;

/**
 *
 * @author Benjamin Ramirez
 * @author Sakwa Alvitre
 * Lab 3 Part 3 
 */
public class Building {

    protected ElevatorController elevator;
    final public static int NUM_FLOORS = 7;
    protected Floor[] floors = new Floor[NUM_FLOORS];

    public Building() {
        elevator = new ElevatorController(this);
    }

    public ElevatorModel elevator() {
        return this.elevator.model;
    }

    public Floor floor(int floorNumber) {
        return this.floors[floorNumber];
    }

}
