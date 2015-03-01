package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTrainBackward extends Command {
	private DriveTrain driveTrain = Robot.driveTrain;
	private Gyro gyro;
	private double twist;
	private double lf, lb, rb, rf;

	public DriveTrainBackward() {
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
		lf = driveTrain.getLeftFrontPosition();
		lb = driveTrain.getLeftBackPosition();
		rf = driveTrain.getRightFrontPosition();
		rb = driveTrain.getRightBackPosition();
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		driveTrain.driveRobotOriented(0, -0.25, 0);

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		// TODO check to make sure math remains the same for DriveTrainBackward
		// as in DriveTrainForward
		return (Math.abs(driveTrain.getLeftFrontPosition() - lf) < 4)
				&& (Math.abs(driveTrain.getLeftBackPosition() - lb) < 4)
				&& (Math.abs(driveTrain.getRightBackPosition() - rb) < 4)
				&& (Math.abs(driveTrain.getRightFrontPosition() - rf) < 4);

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
