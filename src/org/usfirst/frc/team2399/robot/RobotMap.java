package org.usfirst.frc.team2399.robot;

import org.usfirst.frc.team2399.robot.commands.GyroReset;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int ELEVATOR_JAGUARID = 9; // est elevator jaguar (all
													// caps is recommended) and
													// sets it = to 1; in
													// reality, =1 is unlikely
	public static final int ELEVATOR_ENCODERPORT_A = 0;
	public static final int ELEVATOR_ENCODERPORT_B = 1;
	public static final int SWITCHPORT = 2; // assigned to ports

	public static final CANJaguar ELEVATOR_JAGUAR = new CANJaguar(ELEVATOR_JAGUARID); // assigns which jaguar
	public static final Encoder ELEVATOR_ENCODER = new Encoder(
			ELEVATOR_ENCODERPORT_A, ELEVATOR_ENCODERPORT_B);// assigns encoder
															// to ports
	public static final DigitalInput ELEVATOR_SWITCH = new DigitalInput(
			SWITCHPORT);// assigns limit switch to ports

	public static final int LEFTFRONT_JAGUARID = 2;// ports have been assigned
	public static final int RIGHTFRONT_JAGUARID= 6;
	public static final int	LEFTBACK_JAGUARID= 4;
	public static final int RIGHTBACK_JAGUARID= 3;
											
	public static final int MOTOR_ENCODERPORT_A = 3;
	public static final int MOTOR_ENCODERPORT_B = 4;


	public static final Encoder MOTOR_ENCODER = new Encoder(
			MOTOR_ENCODERPORT_A, MOTOR_ENCODERPORT_B);
	
	
	public static final int GYRO_PORT= 0;
	public static final Gyro gyro = null;//new Gyro(GYRO_PORT);

	
	

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