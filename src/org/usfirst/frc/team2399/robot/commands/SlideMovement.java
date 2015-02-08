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
public abstract class SlideMovement extends Command {

	JoystickButton slideUpButt;//joystick buttons
	JoystickButton slideDownButt;

	public SlideMovement(JoystickButton slideUpButt,
			JoystickButton slideDownButt) {//public class applying to the buttons

		this.slideDownButt = slideDownButt;//what those buttons mean
		this.slideUpButt = slideUpButt;

		requires(Robot.elevator);//requires these things from CommandBase
		requires(Robot.oi);

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

//		if (slideUpButt.get() == true) {//if up is pressed, elevator moves up
//			Elevator.set(.1);
//		} 
//		else {
//			Elevator.set(0);//otherwise stopped
//		}
//		
//		if (slideDownButt.get()== true){//if down is pressed, elevator moves down
//			Elevator.set(-.1);
//		}
//		else{
//			Elevator.set(0);//otherwise is stopped
//		}
			

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
