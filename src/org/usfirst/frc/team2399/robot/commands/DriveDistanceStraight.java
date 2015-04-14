package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.*;
import org.usfirst.frc.team2399.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;

public class DriveDistanceStraight extends Command {
	private DriveTrain driveTrain = Robot.driveTrain;
	private double twist;
	private double lf, lb, rb, rf;
	private double distance, speed;

	// private double a;
	// private double v;
	// private double vPrev = 0;
	// private double x;
	// private double xPrev = 0;
	// private double t = 0;
	// private Accelerometer acceleromter;
	// private Timer timer;

	public DriveDistanceStraight(double distance, double speed, double twist, double timeout) {
		requires(Robot.driveTrain);
		setTimeout(timeout);
		this.distance = distance;  //the instance of distance being passed 
		//through as a parameter is equal to the private variable distance
		this.twist = twist;
		this.speed = speed;
		// acceleromter = new Accelerometer(RobotMap.accelerometer);
	}

	@Override
	protected void initialize() {
		lf = driveTrain.getLeftFrontPosition();
		lb = driveTrain.getLeftBackPosition();
		rf = driveTrain.getRightFrontPosition();
		rb = driveTrain.getRightBackPosition();
	}

	@Override
	// x = 0, y = 25% power, twist = kp * (sp-pv)
	// kp = a number that we need to figure out (keeps robot straight)
	// pv = gyro angle (the angle that you are actually at)
	// sp = your angle that you want to be at
	// sp-pv = E
	protected void execute() {
	
			driveTrain.driveRobotOriented(0, speed, twist);
	
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (Math.abs(driveTrain.getLeftFrontPosition()-lf)>distance) &&
				(Math.abs(driveTrain.getLeftBackPosition()-lb)>distance) &&
				(Math.abs(driveTrain.getRightBackPosition()-rb)>distance) &&
				(Math.abs(driveTrain.getRightFrontPosition()-rf)>distance);
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		driveTrain.driveRobotOriented(0, 0, 0);

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		driveTrain.driveRobotOriented(0, 0, 0);

	}

}
