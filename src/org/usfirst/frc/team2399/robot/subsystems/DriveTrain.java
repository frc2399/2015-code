package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;
import org.usfirst.frc.team2399.robot.commands.*;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

// subsytems are parts of the robot that move
public class DriveTrain extends Subsystem {// extends DriveTrain

	// encoders, jags, and drive est; new Gyro at port 0
	// TODO will need to put correct encoder code in
	
	public boolean robotDrive = false;
	public boolean fieldDrive = false;

	private RobotDrive drive;
	private Gyro drivetrainGyro;

	private CANJaguar leftFront;
	private CANJaguar rightFront;
	private CANJaguar leftBack;
	private CANJaguar rightBack;
	// established jags/their motors as vales from RobotMap
	// established new drive and invert motors; sync motors (this was a bug fix)
	

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
	public double getGyroAngle(){
		return(drivetrainGyro.getAngle());
	}

	public DriveTrain(int encoderCounts, Gyro g) {

		leftFront = new CANJaguar(RobotMap.LEFTFRONT_JAGUARID);
		rightFront = new CANJaguar(RobotMap.RIGHTFRONT_JAGUARID);
		leftBack = new CANJaguar(RobotMap.LEFTBACK_JAGUARID);
		rightBack = new CANJaguar(RobotMap.RIGHTBACK_JAGUARID);

		drive = new RobotDrive(leftFront, leftBack, rightFront, rightBack);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		drive.setCANJaguarSyncGroup((byte) 7);
		
		// four lines below enable the encoders to work on the jags
		leftFront.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		rightFront.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		leftBack.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		rightBack.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		
		//four lines below put the jags into encoder control
		leftFront.enableControl();
		rightFront.enableControl();
		leftBack.enableControl();
		rightBack.enableControl();
		
		drivetrainGyro = g;

	}

	public void resetGyro() {
		drivetrainGyro.reset();
	}

	// prints out gyro values
	// Gyro is rightside up
	public void driveFieldOriented(double x, double y, double twist) {
		double gyroAngle = drivetrainGyro.getAngle();
		drive.mecanumDrive_Cartesian(x, y, twist, gyroAngle);
	}
	public Gyro getGyro(){
		return drivetrainGyro;
	}

	public void driveRobotOriented(double x, double y, double twist) {
		drive.mecanumDrive_Cartesian(x, y, twist, 0);
	}
	// Put methods for controlling this subsystem here.
	// Call these from Commands.

	public void initDefaultCommand() {

		setDefaultCommand(new JoystickDrive());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
