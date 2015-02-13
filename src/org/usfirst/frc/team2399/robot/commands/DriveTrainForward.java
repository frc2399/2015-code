package org.usfirst.frc.team2399.robot.commands;
import org.usfirst.frc.team2399.robot.subsystems.*;
import org.usfirst.frc.team2399.robot.Robot;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTrainForward extends Command{
	private DriveTrain driveTrain = Robot.driveTrain;
	private Gyro gyro;
	private double twist;
	public DriveTrainForward(){
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
	}

	@Override
	//x = 0, y = 25% power, twist = kp * (sp-pv)
	//kp = a number that we need to figure out (keeps robot straight)
	//pv = gyro angle (the angle that you are actually at)
	//sp = your angle that you want to be at
	//sp-pv = E
	protected void execute() {
		driveTrain.driveRobotOriented(0, 0.25, (twist = 1*(0-gyro.getAngle())));
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
