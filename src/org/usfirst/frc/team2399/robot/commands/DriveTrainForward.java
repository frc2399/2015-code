package org.usfirst.frc.team2399.robot.commands;
import org.usfirst.frc.team2399.robot.subsystems.*;
import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class DriveTrainForward extends Command{
	private DriveTrain driveTrain = Robot.driveTrain;
	private Gyro gyro;
	private double twist;
	private CANJaguar LEFTFRONT_JAGUAR = RobotMap.LEFTFRONT_JAGUAR;
    private DigitalInput contactSwitchOne = Robot.contactSwitchOne;
    private DigitalInupt contactSwitchFour = Robot.contactSwitchFour;
	//private double a;
//	private double v;
//	private double vPrev = 0;
//	private double x;
//	private double xPrev = 0;
//	private double t = 0;
//	private Accelerometer acceleromter;
//	private Timer timer;
	
	
	public DriveTrainForward(){
		requires(Robot.driveTrain);
		//requires(RobotMap.LEFTFRONT_JAGUAR);
		//acceleromter = new Accelerometer(RobotMap.accelerometer);
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
		int driveTo = 12; //TODO: get the actual numbers
		//driveTo is the number of rotations required to get to the tote plus two
		//two more rotations in case of under/over shooting and human error
		double finishPoint = (LEFTFRONT_JAGUAR.getPosition() + driveTo);
		if (finishPoint > 0){
			driveTrain.driveRobotOriented(0, 0.25, (twist = 1*(0-gyro.getAngle())));
		} else if (contactSwitchOne.get() == true && contactSwitchFour.get() == true){
			/*
			 * the else if is going to drive forward until the contact switches 1 and 4 have been triggered
			 * when they have been triggered, they SHOULD cause the robot to break out of this if statement
			 * and into the next thing in the command group
			 * if it doesn't do the thing then we need to find the command that makes it move onto the next 
			 * command
			 * THE CODE IS MAD RIGHT NOW
			 * that is because the contact switch code doesn't exist in this branch
			 * when this branch is merged into SubsystemCreation2015 the code should be happy
			 */
			driveTrain.driveRobotOriented(0, 0, 0);
		} else if (LEFTFRONT_JAGUAR.getPosition() >= driveTo){
			/*
			 * this pretty much says if the position of the robot is greater then or euqal to the
			 * point where it should have gone then stop driving and go on to the next command 
			 * in the command group
			 * a bit of a fail-safe in case the contact switches don't trigger
			 * also would probably be useful in DriveAutoZone to make sure the robot doesn't 
			 * drive out of auto zone
			 * AGAIN
			 * break SHOULD make the robot move onto the next command in the command group
			 * if it doesn't, we need to find what DOES
			 * because this setup right now is really pretty and I like it
			 */
			driveTrain.driveRobotOriented(0, 0, 0);
		}
		
		
		
		/*
		 * complete psuedocode here:
		 * use encoders somehow like this?
		 * reset encoder
		 * if encoder is displaying a value less then whatever distance we want {
		 * go forward;
		 * } else {
		 * break;
		 * }
		 * sort of like the 2014 autoposition execute loop
		 * but with encoders instead of ultrasonic
		 */
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
