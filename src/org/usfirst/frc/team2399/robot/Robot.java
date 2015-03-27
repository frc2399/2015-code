package org.usfirst.frc.team2399.robot;

import org.usfirst.frc.team2399.robot.commands.AutoTote;
//import org.usfirst.frc.team2399.robot.OI;
import org.usfirst.frc.team2399.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;
import org.usfirst.frc.team2399.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

// THIS CLASS HAS REPLACED COMMANDBASE/COMMANDS
public class Robot extends IterativeRobot {
	// established static variables

	public static OI oi;

	public static DriveTrain driveTrain;
	// public static Button reduceSpeedButt;

	public static Elevator elevatorFront;
	public static Elevator elevatorRear;
	public static Joystick joystick;
	public static Gyro gyro;
	public static Joystick twistStick;
	
	public static CANJaguar leftFront;
	
	public static CameraServer cam0;
//all of the above thingies don't need to be static
	// established contact switches


	private Command autoncommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	// if you want to take out an auton mode, comment out autoncommand = new

	public void robotInit() {

		// established new instances of drivetrain, elevator, OI and an
		// autonomus command
		gyro = new Gyro(RobotMap.GYRO_PORT);


		driveTrain = new DriveTrain(RobotMap.ENCODER_COUNTS_DRIVETRAIN, gyro);
		
		
		elevatorFront = new Elevator(RobotMap.ELEVATORFRONT_JAGUARID,
									RobotMap.FRONTCONTACT_SWITCH1ID,
									RobotMap.FRONTCONTACT_SWITCH2ID,
									RobotMap.FRONTCONTACT_SWITCH3ID,
									RobotMap.FRONTCONTACT_SWITCH4ID,
									RobotMap.ENCODER_COUNTS_FRONT_ELEVATOR,
									RobotMap.FRONT_ELEVATOR_UPPER_LIMIT,
									RobotMap.FRONT_ELEVATOR_LOWER_LIMIT);

		elevatorRear = new Elevator(RobotMap.ELEVATORREAR_JAGUARID, 
									RobotMap.REARCONTACT_SWITCH1ID, 
									RobotMap.REARCONTACT_SWITCH2ID,
									RobotMap.REARCONTACT_SWITCH3ID, 
									RobotMap.REARCONTACT_SWITCH4ID,
									RobotMap.ENCODER_COUNTS_REAR_ELEVATOR,
									RobotMap.REAR_ELEVATOR_UPPER_LIMIT,
									RobotMap.REAR_ELEVATOR_LOWER_LIMIT);
		//leftFront = new CANJaguar(RobotMap.LEFTFRONT_JAGUARID);


		oi = new OI();

		autoncommand = new AutoTote();
		
//		cam0 = CameraServer.getInstance();
//		cam0.setQuality(25);
//		cam0.setSize(100);
//		cam0.startAutomaticCapture();

		// smartdashboard values for drivetrain and elevator
//		SmartDashboard.putData("Drive Train", driveTrain);
//
//
//		SmartDashboard.putData("Front Elevator", elevatorFront);
//		SmartDashboard.putData("Rear Elevator", elevatorRear);
//		
				// instantiate the command used for the autonomous period


	}

	// established wait command for later use
	private void WaitCommmand(double d) {

	}

	// TODO figure out what this is so we can write a better comment
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	// schedule the autonomous command (example)
	public void autonomousInit() {
		if (autoncommand != null) {
			autoncommand.start();
		}

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		elevatorFront.putSwitchesToDashboard("Front");
		elevatorRear.putSwitchesToDashboard("Rear");
		elevatorFront.putPositionToDashboard("Front");
		elevatorRear.putPositionToDashboard("Rear");

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
