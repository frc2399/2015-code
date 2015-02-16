package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.*;
import org.usfirst.frc.team2399.robot.Robot;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

//PINK IS CURRENTLY FORWARD

public class DriveTrainFowardAutoZone extends Command {
	private DriveTrain driveTrain = Robot.driveTrain;
	private Gyro gyro;
	private double twist;

	private double lf, lb, rb, rf;

	// private double a;
	// private double v;
	// private double vPrev = 0;
	// private double x;
	// private double xPrev = 0;
	// private double t = 0;
	// private Accelerometer acceleromter;
	// private Timer timer;

	public DriveTrainForwardAutoZone(int encoderCounts) {
		requires(Robot.driveTrain);

		// acceleromter = new Accelerometer(RobotMap.accelerometer);
	}

	@Override
	protected void initialize() {
		lf = leftFront.getPosition();
		lb = leftBack.getPosition();
		rb = rightBack.getPosition();
		rf = rightFront.getPosition();
	}

	@Override
	// x = 0, y = 25% power, twist = kp * (sp-pv)
	// kp = a number that we need to figure out (keeps robot straight)
	// pv = gyro angle (the angle that you are actually at)
	// sp = your angle that you want to be at
	// sp-pv = E
	protected void execute()
	{
		if ((math.abs(leftFront.getPosition() - lf) < 4)
				&& (math.abs(leftBack.getPosition() - lb) < 4)
				&& (math.abs(rightBack.getPosition() - rb) < 4)
				&& (math.abs(rightFront.getPosition() - rf) < 4)) {
			driveTrain.driveRobotOriented(0, 0.25,
					(twist = 1 * (0 - gyro.getAngle())));
		} 
		else 
		{
			driveTrain.driveRobotOriented(0, 0, 0);
		}
		
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
