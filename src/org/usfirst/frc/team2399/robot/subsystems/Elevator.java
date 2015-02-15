package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;
import org.usfirst.frc.team2399.robot.commands.ElevateNot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
// sets this instance of elevatorMotor to the public instance of elevatorMotor
// this code is much simpler and it's very nice
// All limit switch code has been removed, because limit switches stop Jags
// automatically when pressed.
public class Elevator extends Subsystem {
	// private instances of drive, elevatormotor/encoder
	private RobotDrive drive;
	private CANJaguar elevatorMotor;
	private Encoder elevatorEncoder;
	private DigitalInput leftOuterSwitch;
	private DigitalInput leftInnerSwitch;
	private DigitalInput rightInnerSwitch;
	private DigitalInput rightOuterSwitch;

	// sets elevator to one from Robot Map
	// this was moved from RobotMap to here to fix an error- working fine now!
	// this refers to the current instance of the class
	public Elevator(int elevatorMotorNum, int leftOuterSwitchNum,
			int leftInnerSwitchNum, int rightInnerSwitchNum,
			int rightOuterSwitchNum) {
		this.elevatorMotor = new CANJaguar(elevatorMotorNum);
		leftOuterSwitch = new DigitalInput(leftOuterSwitchNum);
		leftInnerSwitch = new DigitalInput(leftInnerSwitchNum);
		rightInnerSwitch = new DigitalInput(rightInnerSwitchNum);
		rightOuterSwitch = new DigitalInput(rightOuterSwitchNum);
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

		setDefaultCommand(new ElevateNot(this));
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void putSwitchesToDashboard(String prefix) {
		SmartDashboard.putBoolean(prefix + " Left Outer Switch Pressed",
				leftOuterSwitch.get());
		SmartDashboard.putBoolean(prefix + " Left Inner Switch Pressed",
				leftInnerSwitch.get());
		SmartDashboard.putBoolean(prefix + " Right Inner Switch Pressed",
				rightInnerSwitch.get());
		SmartDashboard.putBoolean(prefix + " Right Outer Switch Pressed",
				rightOuterSwitch.get());

	}
	
	public boolean isTouchingTote()
	{
		return leftOuterSwitch.get() && rightOuterSwitch.get() && !leftInnerSwitch.get() && !rightInnerSwitch.get();
	}
}
