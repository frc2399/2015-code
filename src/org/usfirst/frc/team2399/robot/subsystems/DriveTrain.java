package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {//extends DriveTrain
	private Encoder drivetrainEncoder;//encoder est
	
	private CANJaguar leftfront;//Jags est
	private CANJaguar rightfront;
	private CANJaguar leftback;
	private CANJaguar rightback;
	
	private RobotDrive drive;//drive est as static
	
	private Gyro drivetrainGyro;
	
	
	
	public DriveTrain(){
		leftfront = new CANJaguar(RobotMap.driveLeftFront);//Jags take values from RobotMap
		rightfront = new CANJaguar(RobotMap.driveRightFront);//est new CANJags
		leftback = new CANJaguar(RobotMap.driveLeftBack);
		rightback= new CANJaguar(RobotMap.driveRightBack);
		
		drive= new RobotDrive(leftfront, leftback, rightfront, rightback);//says what Drive is
		
		//set up smartdash later
		drivetrainEncoder=RobotMap.MOTOR_ENCODER;//what the drivetrain encoder is
		
	}
	
	public void driveStrafe(double x, double y, double twist) {
		double gyroAngle= 0;
		drive.mecanumDrive_Cartesian(x, y, twist, gyroAngle);
	}
	
	public void drive(double x, double y, double twist){
		drive.mecanumDrive_Cartesian(x, y, twist, 0);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public static double getGyroAngle() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void resetGyro() {
		// TODO Auto-generated method stub
		
	}

	public static void set(int i) {
		// TODO Auto-generated method stub
		
	}

	public static void mechanumDrive_Cartesian(double y, double x, int i,
			double angle) {
		// TODO Auto-generated method stub
		
	}

	public static void Strafe(double sideSpeed, int i, double twistSpeed,
			double gyroAngle) {
		// TODO Auto-generated method stub
		
	}
    

}

