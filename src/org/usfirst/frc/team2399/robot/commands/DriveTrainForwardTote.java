package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.*;
import org.usfirst.frc.team2399.robot.Robot;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class DriveTrainForwardTote extends Command {
	private DriveTrain driveTrain = Robot.driveTrain;
	private Gyro gyro;
	private double twist;
	
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


	// private double a;
	// private double v;
	// private double vPrev = 0;
	// private double x;
	// private double xPrev = 0;
	// private double t = 0;
	// private Accelerometer acceleromter;
	// private Timer timer;

	public DriveTrainForwardTote(int encoderCounts) {
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
		// acceleromter = new Accelerometer(RobotMap.accelerometer);
	}

	@Override
	protected void initialize() {
	}

	@Override
	// x = 0, y = 25% power, twist = kp * (sp-pv)
	// kp = a number that we need to figure out (keeps robot straight)
	// pv = gyro angle (the angle that you are actually at)
	// sp = your angle that you want to be at
	// sp-pv = E
	protected void execute() {
		driveTrain.driveRobotOriented(0, 0.25,
				(twist = 1 * (0 - gyro.getAngle())));
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
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
