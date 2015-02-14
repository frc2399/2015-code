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
	// private instance of drive train and brings in drive train from Robot.Java
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

		// dead-bands set individually to their values
		twist = deadband(Robot.oi.getTwistSpeed(), .25, .25);
		x = deadband(Robot.oi.getSideSpeed(), .05, 1);
		y = deadband(Robot.oi.getForwardSpeed(), .05, 1);

		driveTrain.driveFieldOriented(x, y, twist);

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

	// establishes constant deadbandpercent so different calculations can be made for different motions individually.
	// established deadbandscale so twist motor power can be scaled (makes turns less jerky)
	// TODO ask drivers if they want the scaling on a switch/button (later)
	// scaling for drive as well that can be turned on and off

	public static double deadband(double input, double deadbandpercent,
			double deadbandscale) {
		double deadbandconstant = deadbandpercent;

		if (Math.abs(input) < deadbandconstant) { // abs = absolute value
			return 0;
		}

		else {
			return (deadbandscale * (input / (Math.abs(input)) * (((Math
					.abs(input) - deadbandconstant)) / (1 - deadbandconstant))));
		}
	}
}
