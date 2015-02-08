package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.OI;
import org.usfirst.frc.team2399.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class JoystickDrive extends Command {// extension of JoystickDrive

	public JoystickDrive() {

		requires(CommandBase.driveTrain);// requires driveTrain from CommandBase

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {//THERE ARE ERRORS HERE

		if (OI.shouldStrafe()) {
			DriveTrain.drive.mecanumDrive_Cartesian(y, x, twist,
					Gyro.getAngle());// if it's strafing, get the angles
		} else {
			DriveTrain.drive.mecanumDrive_Cartesian(OI.getSideSpeed(),
					OI.getForwardSpeed(), OI.getTwistSpeed(), 0);//otherwise get speeds
		}
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
}