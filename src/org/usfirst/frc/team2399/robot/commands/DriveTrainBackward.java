package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.RobotMap;
import org.usfirst.frc.team2399.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTrainBackward extends Command {
	
	public DriveTrain driveTrain = Robot.driveTrain;
	private CANJaguar LEFTFRONT_JAGUAR = RobotMap.LEFTFRONT_JAGUAR;
	private Gyro gyro;
	private double twist;
	
	public DriveTrainBackward(){
		requires(Robot.driveTrain);
	}
	

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	//see DriveTrainForward for comments
	protected void execute() {
		int driveTo = 12;
		double finishPoint = (driveTo - LEFTFRONT_JAGUAR.getPosition());
		if (finishPoint >0){
			driveTrain.driveRobotOriented(0, -0.25, (twist= 1*(0-gyro.getAngle())));
		}
		else if (LEFTFRONT_JAGUAR.getPosition() <= driveTo){
			driveTrain.driveRobotOriented(0, 0, 0);
		}
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
