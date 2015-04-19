package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class Elevate extends Command {

	protected double speed;
	protected Elevator elevator;

	// protected so not affected by other commands, etc.
	protected Elevate(Elevator elevator, double speed) {
		// makes sure we can interrupt it
		setInterruptible(true);
		this.elevator = elevator;
		requires(elevator);

		this.speed = speed;

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
}
