package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
// things to do: subsystems and commands for subsystems; elevator should be
// done; do drive train; make a mecanum drive obj so you can use the library
// method for if limit switch is pressed, driving motor
// speed; config encoders, possibly jaguars
// by tomorrow night: do the same process for drivetrain system (4 CANJaguars
// for encoders)

public class Elevator extends Subsystem {
	private CANJaguar elevatorMotor;// private sets them so that they're only
									// visible in this class
	private Encoder elevatorEncoder;
	private DigitalInput elevatorSwitch;

	public Elevator() {// () bc value needs to be put in
		elevatorMotor = RobotMap.ELEVATOR_JAGUAR;// sets elevator motor= to the
													// one created in RobotMap
		elevatorEncoder = RobotMap.ELEVATOR_ENCODER;
		elevatorSwitch = RobotMap.ELEVATOR_SWITCH;
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

}
