package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

public class AutonomousEasy {
	private Encoder drivetrainEncoder;// encoder est

	private CANJaguar leftfront;
	private CANJaguar rightfront;
	private CANJaguar leftback;
	private CANJaguar rightback;

	private RobotDrive drive;

	private Gyro drivetrainGyro = new Gyro(0);

	
	public AutonomousEasy() {
		leftfront = new CANJaguar(RobotMap.LEFTFRONT_JAGUARID);
		rightfront = new CANJaguar(RobotMap.RIGHTFRONT_JAGUARID);
		leftback = new CANJaguar(RobotMap.LEFTBACK_JAGUARID);
		rightback = new CANJaguar(RobotMap.RIGHTBACK_JAGUARID);
		
		drive = new RobotDrive(leftfront, leftback, rightfront, rightback);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		drive.setCANJaguarSyncGroup((byte) 7);
		
	}
	
	public void resetGyro() {
		drivetrainGyro.reset();
	}
	
	//doubles are for SPEEDS
	public void driveFieldOriented(double x, double y, double twist) {
		double gyroAngle = -drivetrainGyro.getAngle();
		Timer timeLord = new Timer();
		System.out.println(gyroAngle);
		
		drive.mecanumDrive_Cartesian(0, 0.25, 0, gyroAngle);
		try {
			timeLord.wait(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		drive.stopMotor();
	}

}
