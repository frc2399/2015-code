package org.usfirst.frc.team2399.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {
	// all caps and underscores is recommended
	
	
	//Elevator motor Jaguar ID's
	public static final int ELEVATORFRONT_JAGUARID = 5;
	public static final int ELEVATORREAR_JAGUARID = 1;
	public static final int REDUCEHALFSPEED_JAGUARID = 2;
	

	public static final int AUTO_STRAFE_SELECT_INPUT = 2; //TO DO INPUT NUMBERS
	public static final int AUTO_TOTE_SELECT_INPUT = 0; 
	public static final int AUTO_BIN_SELECT_INPUT = 1; 
	public static final int AUTO_DRIVE_AUTOZONE_SELECT_INPUT = 3; 
	
		
	// DriveTrain motor Jaguar ID's
	public static final int LEFTFRONT_JAGUARID = 4;
	public static final int RIGHTFRONT_JAGUARID = 6;
	public static final int LEFTBACK_JAGUARID = 2;
	public static final int RIGHTBACK_JAGUARID = 7;

	
	public static final int GYRO_PORT = 0;
	
	public static final int ENCODER_COUNTS_FRONT_ELEVATOR = 250;
	public static final int ENCODER_COUNTS_REAR_ELEVATOR = 250;
	
	
	public static final double FRONT_ELEVATOR_UPPER_LIMIT = 13.251;
	public static final double FRONT_ELEVATOR_LOWER_LIMIT = 0;
	
	public static final double REAR_ELEVATOR_UPPER_LIMIT = 13.083;
	public static final double REAR_ELEVATOR_LOWER_LIMIT = 0;
	
	
	public static final int ENCODER_COUNTS_DRIVETRAIN = 250;

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	// wants you to declare constants for ports and speed controllers
	// void is for methods that have no return
	// static= only one
	// final= cannot change
	// for limit switches telling things- see code we created when experimenting
	// with limit switches
}