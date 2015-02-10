package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.OI;
import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class JoystickDrive extends Command {
	// private instance of drivetrain and brings in drivetrain from Robot.Java
	private DriveTrain driveTrain = Robot.driveTrain;
	private Joystick driveStick = Robot.joystick;

	public JoystickDrive() {

		requires(Robot.driveTrain);

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	// sets drivetrain to get values from joysticks
	protected void execute() {
		double twist;
		double x;
		double y;

		driveTrain.driveFieldOriented(Robot.oi.getSideSpeed(),
				Robot.oi.getForwardSpeed(), Robot.oi.getTwistSpeed());

		//deadbands set individually to their values
		twist = deadband(driveStick.getTwist(), .25);
		x= deadband(driveStick.getX(), .05);
		y= deadband(driveStick.getY(), .05);

		// System.out.println("is running");

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

	//est constant deadbandpercent so calcs can be made for different motions individually
	public static double deadband(double input, double deadbandpercent) // static because the values
												// don't change
	{
		double deadbandconstant = deadbandpercent;

		if (Math.abs(input) < deadbandconstant) { // abs = absolute value
			return 0;
		}

		else {
			return (input / (Math.abs(input)) * (((Math.abs(input) - deadbandconstant)) / (1 - deadbandconstant)));
		}
	}
}
