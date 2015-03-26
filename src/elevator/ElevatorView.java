package elevator;

/**
 *
 * @author Benjamin Ramirez
 * @author Sakwa Alvitre
 * Lab 8 Part 3 
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ElevatorView { // the GUI
    
    protected JFrame frame;
    public static final int WIDTH = 350;
    public static final int HEIGHT = 200;
    JLabel floorNumLabel = new JLabel(""); //contains current floor num
    JLabel numPassengers = new JLabel(""); //num of passengers
    JLabel direction = new JLabel(""); //for direction of elevator
    
    public ElevatorView() {
        frame = new JFrame("Elevator Simulation");
        frame.setSize(WIDTH, HEIGHT);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        //setting the layout of the JFrame.
        frame.getContentPane().setLayout(new BorderLayout());
        
        //making the top panel for "Elevator Status"
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        JLabel topLabel = new JLabel("Elevator Status");
        topLabel.setFont(topLabel.getFont().deriveFont(20.0f));
        topPanel.add(topLabel);
        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        
        //making StatePanel
        JPanel statePanel = new JPanel();
        statePanel.setLayout(new GridLayout(0,2));
        //making current floor texts
        JLabel floorLabel = new JLabel("Current Floor:"); //text
        statePanel.add(floorLabel);
        statePanel.add(floorNumLabel); //the global for floonum
        //making Number of passenger texts
        JLabel passengersText = new JLabel("Number of Passengers:");//text
        statePanel.add(passengersText);
        statePanel.add(numPassengers);// global for number of passengers
        //making Direction text
        JLabel directionText = new JLabel("Direction:");//text
        statePanel.add(directionText);
        statePanel.add(direction);//the global for direction
        //adding the StatePanel to the frame
        frame.getContentPane().add(statePanel,BorderLayout.CENTER);
        
        frame.setVisible(true);  
    }
}
