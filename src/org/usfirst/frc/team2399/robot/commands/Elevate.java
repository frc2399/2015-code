package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.OI;
import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 */
// pulls new values from Robot.java/ests private instances and sets speeds
// PLEASE NOTE: LIMIT SWITCHES HAVE BEEN REMOVED BC JAGS CAN DO IT FOR US
public abstract class Elevate extends Command {
	
	
	
	// est variables for use


	// protected so not affected by other commands, etc.
	protected Elevate(Elevator elevator, double speed, int elevatorMotorNum,
			int encoderCounts, int leftOuterSwitchNum,
			int leftInnerSwitchNum, 
			int rightInnerSwitchNum,
			int rightOuterSwitchNum, 
			int encoderCounts, 
			double upperLimit,
			double lowerLimit) {
		// makes sure we can interrupt it
		setInterruptible(true);
		this.elevator = elevator;
		requires(elevator);
		
		private double upperLimit;
		private double lowerLimit;
		
		private DigitalInput leftOuterSwitch;
		private DigitalInput leftInnerSwitch;
		private DigitalInput rightInnerSwitch;
		private DigitalInput rightOuterSwitch;
		
		elevatorMotor = new CANJaguar(elevatorMotorNum);
		positionValid = false;
		enabled = false;

		this.speed = speed;
		
		this.encoderCounts = encoderCounts;
		
		positionOffset = 0;
		
		if (upperLimit > lowerLimit) {
			this.upperLimit = upperLimit;
			this.lowerLimit = lowerLimit;
		} else {
			this.upperLimit = lowerLimit;
			this.lowerLimit = upperLimit;
		}
		

		positionOffset = 0;
		
		leftOuterSwitch = new DigitalInput(leftOuterSwitchNum);
		leftInnerSwitch = new DigitalInput(leftInnerSwitchNum);
		rightInnerSwitch = new DigitalInput(rightInnerSwitchNum);
		rightOuterSwitch = new DigitalInput(rightOuterSwitchNum);
		
		private void checkLowerLimit();{
			// up is forward (+)
			// down is reverse (-)
			// this means that we are touching the bottom (reverse) limit switch
			
			
			enabled = false;
			if (elevatorMotor.getReverseLimitOK() == false && positionValid == false) {
				
				positionOffset = elevatorMotor.getPosition();
				
				positionValid = true;
			}
			
			enabled = true;
		}
		
		private void zeroJagEncoderCount()
		{
			elevatorMotor.set(0);
			elevatorMotor.setPositionMode(CANJaguar.kQuadEncoder, encoderCounts, 0, 0, 0);
			elevatorMotor.enableControl(0.0);

			elevatorMotor.set(0.0);
			elevatorMotor.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
			elevatorMotor.enableControl();
			elevatorMotor.set(0);
		}
		
		// elevator motor is set to the up speed
		// elevator depend on the motor thats been passed to it- now works for all
		// of the motors
		public void setSpeed(double elevatorSpeed) {
			
			checkLowerLimit();
			if (positionValid == true) {
				if (elevatorSpeed > 0) {
					if (getPosition() > upperLimit) {
						elevatorSpeed = 0;
					}
				}
				if (elevatorSpeed < 0) {
					if (getPosition() < lowerLimit)
						elevatorSpeed = 0;
				}

			}
			elevatorMotor.set(elevatorSpeed);
		}

		// Put methods for controlling this subsystem
		// here. Call these from Commands.

	

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	// set the speed to "speed"
	protected void execute() {
		elevator.setSpeed(speed);
	}

	// Make this return true when this Command no longer needs to run execute()

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

	protected boolean isFinished() {
		return true;
	}
	

	public double getPosition()
	{
		return elevatorMotor.getPosition() - positionOffset;
	}
	public boolean isTouchingTote() {
		return leftOuterSwitch.get() && rightOuterSwitch.get()
				&& !leftInnerSwitch.get() && !rightInnerSwitch.get();
	}
}


