package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTrainBackward extends Command {
	
	public DriveTrain driveTrain = Robot.driveTrain;
	
	
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

	
	
	public DriveTrainBackward(int encoderCounts) {
		requires(Robot.driveTrain);
		
		leftFront.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		rightFront.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		leftBack.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		rightBack.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		
		leftFront.enableControl();
		rightFront.enableControl();
		leftBack.enableControl();
		rightBack.enableControl();
		
		//TODO set actual values (they probably won't be 12)
		leftFront.setPosition(-12);
		rightFront.setPosition(-12);
		leftBack.setPosition(-12);
		rightBack.setPosition(-12);
		
		
	}

	//TODO what does override mean?
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		driveTrain.driveRobotOriented(0, -0.25, 0);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
