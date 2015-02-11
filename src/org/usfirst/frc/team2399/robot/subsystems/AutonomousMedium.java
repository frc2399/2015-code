package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;
import org.usfirst.frc.team2399.robot.commands.ElevateNot;
import org.usfirst.frc.team2399.robot.commands.ElevateUp;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

//TODO check this code w/mentors so we dont accidentally kill the robot
public class AutonomousMedium extends Subsystem {
	private Encoder drivetrainEncoder;// encoder est

	private CANJaguar leftfront;
	private CANJaguar rightfront;
	private CANJaguar leftback;
	private CANJaguar rightback;

	private RobotDrive drive;

	private Gyro drivetrainGyro = new Gyro(0);

	private CANJaguar elevatorFrontMotor;
	private CANJaguar elevatorRearMotor;
	private CANJaguar elevatorRightMotor;
	private CANJaguar elevatorLeftMotor;
	private Encoder elevatorEncoder;

	public AutonomousMedium() {
		leftfront = new CANJaguar(RobotMap.LEFTFRONT_JAGUARID);
		rightfront = new CANJaguar(RobotMap.RIGHTFRONT_JAGUARID);
		leftback = new CANJaguar(RobotMap.LEFTBACK_JAGUARID);
		rightback = new CANJaguar(RobotMap.RIGHTBACK_JAGUARID);

		drive = new RobotDrive(leftfront, leftback, rightfront, rightback);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		drive.setCANJaguarSyncGroup((byte) 7);

		elevatorFrontMotor = new CANJaguar(RobotMap.ELEVATORFRONT_JAGUARID);
		elevatorRearMotor = new CANJaguar(RobotMap.ELEVATORREAR_JAGUARID);
		elevatorRightMotor = new CANJaguar(RobotMap.ELEVATORRIGHT_JAGUARID);
		elevatorLeftMotor = new CANJaguar(RobotMap.ELEVATORLEFT_JAGUARID);
	}

	public void resetGyro() {
		drivetrainGyro.reset();
	}

	public void setSpeed(double elevatorUpSpeed) {
		elevatorFrontMotor.set(elevatorUpSpeed);
		elevatorRearMotor.set(elevatorUpSpeed);
		elevatorRightMotor.set(elevatorUpSpeed);
		elevatorLeftMotor.set(elevatorUpSpeed);
	}

	public void initDefaultCommand() {

		setDefaultCommand(new ElevateNot());
	}

	public void driveFieldOriented(double x, double y, double twist) {
		double gyroAngle = -drivetrainGyro.getAngle();
		Timer timer = new Timer();
		System.out.println(gyroAngle);
		
		//drive forward two seconds
		drive.mecanumDrive_Cartesian(0, 0.2, 0, gyroAngle);
		try {
			timer.wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		drive.stopMotor();
		
		//elevator up at .5 speed and stop
		elevatorFrontMotor.set(.5);
		try{
			timer.wait(1500);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//drive backward -.2 speed and stop
		drive.mecanumDrive_Cartesian(0, -.2, 0, gyroAngle);
		try{
			timer.wait(4000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//elevator down at -.5 speed and stop
		elevatorFrontMotor.set(-.5);
		try{
			timer.wait(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//drive backward at -.2 speed and stop
		drive.mecanumDrive_Cartesian(0, -.2, 0, gyroAngle);
		try{
			timer.wait(1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
