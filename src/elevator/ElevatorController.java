
/**
 *
 * @author Benjamin Ramirez
 * @author Sakwa Alvitre
 * Lab 8 Part 3 
 */
package elevator;

public class ElevatorController {
    public ElevatorView view;
    public ElevatorModel model;
    protected int NUM_FLOORS = 7;
    
    public ElevatorController(Building building) {
        this.model = new ElevatorModel(building);
        this.view = new ElevatorView();
        this.update();
    }
    
    public void update() {
        setCurrentFloorDisplay();
        setNumPassengersDisplay();
        setDirectionDisplay();
    }
    
    public void setCurrentFloorDisplay() {
        this.view.floorNumLabel.setText(Integer.toString(this.model.currentFLoor()));
    }
    
    public void setNumPassengersDisplay() {
        this.view.numPassengers.setText(Integer.toString(this.model.passengers()));
    }
    
    public void setDirectionDisplay() {
        if (this.model.getDirection()){
            this.view.direction.setText("UP");
        }
        else{
            this.view.direction.setText("DOWN");
        }
    }
}