package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;
import org.usfirst.frc.team2399.robot.commands.ElevateNot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
// THIS HAS NEW STUFF. YOU SHOULD LOOK AT THE THING
// sets this instance of elevatorMotor to the public instance of elevatorMotor
// this code is much simpler and it's very nice
// ALL LIMIT SWITCH THINGS HAVE BEEN REMOVED BC JAGS DO IT FOR US
public class Elevator extends Subsystem {
	// private instances of drive, elevatormotor/encoder
	private RobotDrive drive;
	private CANJaguar elevatorMotor;
	private Encoder elevatorEncoder;
	Encoder frontEncoder = new Encoder(RobotMap.ELEVATORFRONT_ENCODERPORT_A,
			RobotMap.ELEVATORFRONT_ENCODERPORT_B);
	Encoder rearEncoder = new Encoder(RobotMap.ELEVATORREAR_ENCODERPORT_A,
			RobotMap.ELEVATORREAR_ENCODERPORT_B);
	Encoder leftEncoder = new Encoder(RobotMap.ELEVATORLEFT_ENCODERPORT_A,
			RobotMap.ELEVATORLEFT_ENCODERPORT_B);
	Encoder rightEncoder = new Encoder(RobotMap.ELEVATORRIGHT_ENCODERPORT_A,
			RobotMap.ELEVATORRIGHT_ENCODERPORT_B);

	// sets elevator to one from Robot Map
	// this was moved from RobotMap to here to fix an error- working fine now!
	// this refers to the current instance of the class
	public Elevator(CANJaguar elevatorMotor) {
		this.elevatorMotor = elevatorMotor;
	}

	// elevator motor is set to the up speed
	// elevator depend on the motor thats been passed to it- now works for all
	// of the motors
	public void setSpeed(double elevatorUpSpeed) {
		elevatorMotor.set(elevatorUpSpeed);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	// default command is no movement
	public void initDefaultCommand() {

		setDefaultCommand(new ElevateNot());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

}
