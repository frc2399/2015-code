package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.OI;
import org.usfirst.frc.team2399.robot.RobotMap;
import org.usfirst.frc.team2399.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
// subsytems are parts of the robot that move
public class DriveTrain extends Subsystem {// extends DriveTrain

	// encoders, jags, and drive est; new Gyro at port 0
	// TODO will need to put correct encoder code in

	private RobotDrive drive;
	private Gyro drivetrainGyro = new Gyro(0);

	private CANJaguar leftFront;
	private CANJaguar rightFront;
	private CANJaguar leftBack;
	private CANJaguar rightBack;
	// established jags/their motors as vales from RobotMap
	// established new drive and invert motors; sync motors (this was a bug fix)

	public DriveTrain() {

		leftFront = new CANJaguar(RobotMap.LEFTFRONT_JAGUARID);
		rightFront = new CANJaguar(RobotMap.RIGHTFRONT_JAGUARID);
		leftBack = new CANJaguar(RobotMap.LEFTBACK_JAGUARID);
		rightBack = new CANJaguar(RobotMap.RIGHTBACK_JAGUARID);

		drive = new RobotDrive(leftFront, leftBack, rightFront, rightBack);

		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);

		drive.setCANJaguarSyncGroup((byte) 7);

		// drivetrainEncoder = RobotMap.MOTOR_ENCODER;
		// what the drivetrain encoder is

		// drivetrainGyro = RobotMap.gyro;

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
