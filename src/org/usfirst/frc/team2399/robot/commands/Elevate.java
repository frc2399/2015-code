package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.OI;
import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.RobotMap;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 */
//THIS HAS NEW STUFF. YOU SHOULD LOOK AT THE THING
//pulls new values from Robot.java/ests private instances and sets speeds
//PLEASE NOTE: LIMIT SWITCHES HAVE BEEN REMOVED BC JAGS CAN DO IT FOR US
public abstract class Elevate extends Command {
	//est variables for use 
	private double speed;
	private Elevator elevatorFront = Robot.elevatorFront;
	private Elevator elevatorRear = Robot.elevatorRear;
	private CANJaguar ELEVATORFRONT_JAGUAR =RobotMap.ELEVATORFRONT_JAGUAR; 


	//protected so not affected by other commands, etc.
	protected Elevate(double speed) {
		//makes sure we can interrupt it
		setInterruptible(true);

		requires(Robot.elevatorFront);
		requires(Robot.elevatorRear);
	 
		
		
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
		int upTo = 3;//TODO: Figure out the exact number 
		double finishPoint = (upTo - ELEVATORFRONT_JAGUAR.getPosition()); //saying how far we have to go yet to lift the tote
		if(finishPoint > 0) {
			ELEVATORFRONT_JAGUAR.set(speed);//says that if how far we have to go is more then 0
			//then get the value of the variable speed
			//from elevatorUp or elevatorDown and set the motor speed to that value
			}
		else if(ELEVATORFRONT_JAGUAR.getPosition() >= upTo) { 
			ELEVATORFRONT_JAGUAR.set(0);
			// if we have gone more then three rotations set the motors to 0
		}
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
