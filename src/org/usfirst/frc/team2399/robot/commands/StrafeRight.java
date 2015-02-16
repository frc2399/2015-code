package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StrafeRight extends Command {
	private DriveTrain driveTrain = Robot.driveTrain;
	
	public double getLeftFrontPosition(){
		return (leftFront.getPosition());
	}
	public double getLeftFrontSpeed(){
		return (leftFront.getSpeed());
	}
	public double getRightFrontPosition(){
		return (rightFront.getPosition());
	}
	public double getRightFrontSpeed(){
		return(rightFront.getSpeed());
	}
	public double getLeftBackPosition(){
		return(leftBack.getPosition());
	}
	public double getLeftBackSpeed(){
		return(leftBack.getSpeed());
	}
	public double getRightBackPosition(){
		return(rightBack.getPosition());
	}
	public double getRightBackSpeed(){
		return(rightBack.getSpeed());
	}

	public StrafeRight(int encoderCounts) {
		requires(Robot.driveTrain);
		
		leftFront.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		rightFront.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		leftBack.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		rightBack.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		
		leftFront.enableControl();
		rightFront.enableControl();
		leftBack.enableControl();
		rightBack.enableControl();
		
		leftFront.setPosition(12);
		rightFront.setPosition(12);
		leftBack.setPosition(12);
		rightBack.setPosition(12);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		driveTrain.driveRobotOriented(.25, 0, 0);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
