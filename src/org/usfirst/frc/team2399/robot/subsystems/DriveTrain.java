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
public class DriveTrain extends Subsystem {// extends DriveTrain
	private Encoder drivetrainEncoder;// encoder est

	private CANJaguar leftfront;// Jags est
	private CANJaguar rightfront;
	private CANJaguar leftback;
	private CANJaguar rightback;

	private RobotDrive drive;// drive est as static

	private Gyro drivetrainGyro = new Gyro(0);

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

	public void driveFieldOriented(double x, double y, double twist) {
		double gyroAngle = 0;//drivetrainGyro.getAngle();
		drive.mecanumDrive_Cartesian(x, y, twist, gyroAngle);
	}

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
