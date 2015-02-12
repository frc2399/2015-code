package org.usfirst.frc.team2399.robot.commands;
import org.usfirst.frc.team2399.robot.subsystems.*;
import org.usfirst.frc.team2399.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTrainForward extends Command{
	private DriveTrain driveTrain = Robot.driveTrain;
	public DriveTrainForward(){
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		driveTrain.driveRobotOriented(0, 0.25, 0);
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
