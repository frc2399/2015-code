package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;
import org.usfirst.frc.team2399.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

// subsytems are parts of the robot that move
public class DriveTrain extends Subsystem {// extends DriveTrain
	
	// encoders, jags, and drive est; new Gyro at port 0
	//TODO will need to put correct encoder code in 
	
	private RobotDrive drive;
	private Gyro drivetrainGyro = new Gyro(0);

	private CANJaguar leftFront;
	private CANJaguar rightFront;
	private CANJaguar leftBack;
	private CANJaguar rightBack;
	
	
	//TODO figure out what this is
	/*public DriveTrain(DriveTrain driveTrainMotor) {
		this.driveTrainMotor = driveTrainMotor;
	}
*/
	// est jags/their motors as vales from RobotMap
	// est new drive and invert motors; sync motors (this was a bug fix)

	public DriveTrain() {

		// CHECK WITH WILL ABOUT THIS IT DID A THING THAT MIGHT BE RIGHT???
		leftFront= new CANJaguar(RobotMap.LEFTFRONT_JAGUARID);
		rightFront= new CANJaguar(RobotMap.RIGHTFRONT_JAGUARID);
		leftBack= new CANJaguar(RobotMap.LEFTBACK_JAGUARID);
		rightBack= new CANJaguar(RobotMap.RIGHTBACK_JAGUARID);
		
		drive = new RobotDrive(leftFront, leftBack,
				rightFront, rightBack);
		// check w/Will about these
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		drive.setCANJaguarSyncGroup((byte) 7);

		// drive.set
		// set up smartdash later
		// drivetrainEncoder = RobotMap.MOTOR_ENCODER;// what the drivetrain
		// encoder is

		// drivetrainGyro = RobotMap.gyro;

	}

	public void resetGyro() {
		drivetrainGyro.reset();
	}

	// field oriented drive is currently not working
	// prints out gyro values
	// INVERTED BECAUSE GYRO IS UPSIDE DOWN
	public void driveFieldOriented(double x, double y, double twist) {
		double gyroAngle = -drivetrainGyro.getAngle();
		drive.mecanumDrive_Cartesian(x, y, twist, gyroAngle);
		System.out.println(gyroAngle);
	}

	// robotoriented is gucci
	public void driveRobotOriented(double x, double y, double twist) {
		drive.mecanumDrive_Cartesian(x, y, twist, 0);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {

		setDefaultCommand(new JoystickDrive());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	//reset encoders to 0
	//don't need to start like in 2013 bc encoders now do that automatically
	//TODO REDO WITH CORRECT ENCODER CODE
//	public void resetEncoders(){
//		leftFrontEncoder.reset();
//		rightBackEncoder.reset();
//		leftBackEncoder.reset();
//		rightBackEncoder.reset();
//	}
//
//	
//	//getdistance
//	public double getleftFrontEncoder(){
//		SmartDashboard.putDouble("leftFrontEncoder", leftFrontEncoder.getDistance());
//		return leftFrontEncoder.getDistance();
//	}
//	
//	public double getrightFrontEncoder(){
//		SmartDashboard.putDouble("rightFrontEncoder", rightFrontEncoder.getDistance());
//		return rightFrontEncoder.getDistance();
//	}
//	
//	public double getleftBackEncoder(){
//		SmartDashboard.putDouble("leftBackEncoder", leftBackEncoder.getDistance());
//		return leftBackEncoder.getDistance();
//	}
//	
//	public double getrightBackEncoder(){
//		SmartDashboard.putDouble("rightBackEncoder", rightBackEncoder.getDistance());
//		return rightBackEncoder.getDistance();
		//return statement are like the end of a sentence
		//if code is unreachable, put it above the return statement
	}
	
	
	



