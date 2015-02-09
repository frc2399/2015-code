package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.OI;
import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 */

//PLEASE NOTE: LIMIT SWITCHES HAVE BEEN REMOVED BC JAGS CAN DO IT FOR US
public abstract class Elevate extends Command {
	//est variables for use 
	private double speed;
	private Elevator elevator = Robot.elevator;

	//protected so not affected by other commands, etc.
	protected Elevate(double speed) {
		//makes sure we can interrupt it
		setInterruptible(true);

		requires(Robot.elevator);// requires these things from CommandBase
		this.speed = speed;//TODO ask why we need to set it like this, I can't remember rn

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	//set the speed to "speed"
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
	
	protected boolean isFinished(){
		return true;
	}
}
