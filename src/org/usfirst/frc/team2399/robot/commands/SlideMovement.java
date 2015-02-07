package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.OI;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 */
public abstract class SlideMovement extends Command {

	JoystickButton slideUpButt;
	JoystickButton slideDownButt;

	public SlideMovement(JoystickButton slideUpButt,
			JoystickButton slideDownButt) {

		this.slideDownButt = slideDownButt;
		this.slideUpButt = slideUpButt;

		requires(CommandBase.elevator);
		requires(CommandBase.oi);

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	private void requires(OI oi) {
		// TODO Auto-generated method stub

	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		if (slideUpButt.get() == true) {
			Elevator.set(.1);
		} 
		else {
			Elevator.set(0);
		}
		
		if (slideDownButt.get()== true){
			Elevator.set(-.1);
		}
		else{
			Elevator.set(0);
		}
			

	}

	
	

	{
		// jag 9
		// elevatorMotor

	}

	// Make this return true when this Command no longer needs to run execute()

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
