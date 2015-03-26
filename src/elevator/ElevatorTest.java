/**
 *
 * @author Benjamin Ramirez
 * @author Sakwa Alvitre
 * Lab 8 Part 3 
 */

package elevator;

public class ElevatorTest {
    public static void main(String[] argv) throws ElevatorFullException {
        Building building = new Building();
        for(int i=0; i<building.NUM_FLOORS; i++) {
            building.floors[i] = new Floor(building, i);
        }
        building.elevator().boardPassenger(4);
        building.elevator.update();
        goToSleep();
        building.elevator().boardPassenger(2);
        building.elevator.update();
        goToSleep();
        building.elevator().boardPassenger(3);
        building.elevator.update();
        goToSleep();
        for (int i = 0; i < 10; i++) {
            building.elevator().move();
            building.elevator.update();
            goToSleep();
        }
    }
    
    public static void goToSleep() {
        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}