package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;
import org.usfirst.frc.team2399.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

//subsytems are parts of the robot that move
public class DriveTrain extends Subsystem {// extends DriveTrain
	//encoders, jags, and drive est; new Gyro at port 0
	private Encoder drivetrainEncoder;// encoder est

	private CANJaguar leftfront;
	private CANJaguar rightfront;
	private CANJaguar leftback;
	private CANJaguar rightback;

	private RobotDrive drive;

	private Gyro drivetrainGyro = new Gyro(0);

	//est jags/their motors as vales from RobotMap
	//est new drive and invert motors; sync motors (this was a bug fix)
	public DriveTrain() {
		leftfront = new CANJaguar(RobotMap.LEFTFRONT_JAGUARID);
		rightfront = new CANJaguar(RobotMap.RIGHTFRONT_JAGUARID);
		leftback = new CANJaguar(RobotMap.LEFTBACK_JAGUARID);
		rightback = new CANJaguar(RobotMap.RIGHTBACK_JAGUARID);

		drive = new RobotDrive(leftfront, leftback, rightfront, rightback);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		drive.setCANJaguarSyncGroup((byte) 7);

		// drive.set
		// set up smartdash later
		// drivetrainEncoder = RobotMap.MOTOR_ENCODER;// what the drivetrain
		// encoder is

		//drivetrainGyro = RobotMap.gyro;

	}

	public void resetGyro() {
		drivetrainGyro.reset();
	}
	//field oriented drive is currently not working
	//prints out gyro values
	//INVERTED BECAUSE GYRO IS UPSIDE DOWN
	public void driveFieldOriented(double x, double y, double twist) {
		double gyroAngle = -drivetrainGyro.getAngle();
		drive.mecanumDrive_Cartesian(x, y, twist, gyroAngle);
		System.out.println(gyroAngle);
	}
	//robotoriented is gucci
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

}
