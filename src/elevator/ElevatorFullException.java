
package elevator;

/**
 *
 * @author Benjamin Ramirez
 * @author Sakwa Alvitre
 * Lab 3 Part 3 
 */
public class ElevatorFullException extends Exception {
    
    ElevatorFullException(){
        super();
    }
    
    ElevatorFullException(Exception msg){
        super(msg);
    }
    
    
}
