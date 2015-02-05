package org.usfirst.frc.team2399.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int ELEVATOR_JAGUARID=1; //est elevator jaguar (all caps is recommended) and sets it = to 1; in reality, =1 is unlikely
	public static final int ELEVATOR_ENCODERPORT_A=0; 
	public static final int ELEVATOR_ENCODERPORT_B=1; 
	public static final int SWITCHPORT=2; //assigned to ports
	
	public static final CANJaguar ELEVATOR_JAGUAR= new CANJaguar(ELEVATOR_JAGUARID); //assigns which jaguar
	public static final Encoder ELEVATOR_ENCODER=new Encoder(ELEVATOR_ENCODERPORT_A,ELEVATOR_ENCODERPORT_B);//assigns encoder to ports
	public static final DigitalInput ELEVATOR_SWITCH=new DigitalInput(SWITCHPORT);//assigns switch to ports
	
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
//wants you to declare constants for ports and speed controllers
//void is for methods that have no return
//static= only one
//final= cannot change