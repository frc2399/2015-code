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
	// all caps and underscores is recommended
	// elevator jags have been assigned to their ID's
	public static final int ELEVATORFRONT_JAGUARID = 1;
	public static final int ELEVATORREAR_JAGUARID = 5;
	
	public static final CANJaguar ELEVATORFRONT_JAGUAR = new CANJaguar(
			ELEVATORFRONT_JAGUARID);
	public static final CANJaguar ELEVATORREAR_JAGUAR = new CANJaguar(
			ELEVATORREAR_JAGUARID);
	
	// TODO change ContactSwitch ID's
	public static final int CONTACT_SWITCH1ID = 3;
	public static final int CONTACT_SWITCH2ID = 4;
	public static final int CONTACT_SWITCH3ID = 5;
	public static final int CONTACT_SWITCH4ID = 6;

	
	// DriveTrain motor Jaguar ID's
	public static final int LEFTFRONT_JAGUARID = 4;
	public static final int RIGHTFRONT_JAGUARID = 6;
	public static final int LEFTBACK_JAGUARID = 2;
	public static final int RIGHTBACK_JAGUARID = 8;

	public static final CANJaguar LEFTFRONT_JAGUAR = new CANJaguar(
			LEFTFRONT_JAGUARID);
	public static final CANJaguar RIGHTFRONT_JAGUAR = new CANJaguar(
			RIGHTFRONT_JAGUARID);
	public static final CANJaguar LEFTBACK_JAGUAR = new CANJaguar(
			LEFTBACK_JAGUARID);
	public static final CANJaguar RIGHTBACK_JAGUAR = new CANJaguar(
			RIGHTBACK_JAGUARID);

	// Gyro established
	public static final int GYRO_PORT = 0;
	public static final Gyro gyro = new Gyro(GYRO_PORT);

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