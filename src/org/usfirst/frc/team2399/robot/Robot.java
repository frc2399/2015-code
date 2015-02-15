package org.usfirst.frc.team2399.robot;

import org.usfirst.frc.team2399.robot.commands.DriveAutoZone;
//import org.usfirst.frc.team2399.robot.OI;
import org.usfirst.frc.team2399.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
//	public static Button reduceSpeedButt;

	public static Elevator elevatorFront;
	public static Elevator elevatorRear;

	public static Joystick joystick;

	// established contact switches

	public static DigitalInput frontContactSwitchOne = new DigitalInput(
			RobotMap.FRONTCONTACT_SWITCH1ID);
	public static DigitalInput frontContactSwitchTwo = new DigitalInput(
			RobotMap.FRONTCONTACT_SWITCH2ID);
	public static DigitalInput frontContactSwitchThree = new DigitalInput(
			RobotMap.FRONTCONTACT_SWITCH3ID);
	public static DigitalInput frontContactSwitchFour = new DigitalInput(
			RobotMap.FRONTCONTACT_SWITCH4ID);
	
	public static DigitalInput rearContactSwitchOne = new DigitalInput(
			RobotMap.REARCONTACT_SWITCH1ID);
	public static DigitalInput rearContactSwitchTwo = new DigitalInput(
			RobotMap.REARCONTACT_SWITCH2ID);
	public static DigitalInput rearContactSwitchThree = new DigitalInput(
			RobotMap.REARCONTACT_SWITCH3ID);
	public static DigitalInput rearContactSwitchFour = new DigitalInput(
			RobotMap.REARCONTACT_SWITCH4ID);


	private Command autoncommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	// if you want to take out an auton mode, comment out autoncommand = new

	public void robotInit() {

		// established new instances of drivetrain, elevator, OI and an
		// autonomus command

		driveTrain = new DriveTrain();

		elevatorFront = new Elevator(RobotMap.ELEVATORFRONT_JAGUARID);
		elevatorRear = new Elevator(RobotMap.ELEVATORREAR_JAGUARID);

		oi = new OI();

		autoncommand = new DriveAutoZone();

		// smartdashboard values for drivetrain and elevator
		SmartDashboard.putData("Drive Train", driveTrain);

		SmartDashboard.putData("Front Elevator", elevatorFront);
		SmartDashboard.putData("Rear Elevator", elevatorRear);

		// instantiate the command used for the autonomous period

	}

	// established wait command for later use
	private void WaitCommmand(double d) {

	}

	// When Contact switches are pushed for at least 0.005 seconds, they will
	// show up as Pressed on SmartDashboard.
	
//	public void reduceSpeedButt() {
//		if (reduceSpeedButt.get() == true){
//			WaitCommmand(0.005);
//			x = .5 * x;
//			y = .5 * y;
//			twist = .5 * twist;
//			driveTrain.driveFieldOriented(x, y, twist);
//		}
//	}

	
	
	public void frontContactSwitchOne() {
		if (frontContactSwitchOne.get() == true) {
			WaitCommmand(0.005);
			SmartDashboard.putBoolean("Front Contact Switch One Pressed",
					frontContactSwitchOne.get());
		}
	}

	public void frontContactSwitchTwo() {
		if (frontContactSwitchTwo.get() == true) {
			WaitCommmand(0.005);
			SmartDashboard.putBoolean("Front Contact Switch Two Pressed",
					frontContactSwitchTwo.get());
		}
	}

	public void frontContactSwitchThree() {
		if (frontContactSwitchThree.get() == true) {
			WaitCommmand(0.005);
			SmartDashboard.putBoolean("Front Contact Switch Three Pressed",
					frontContactSwitchThree.get());
		}
	}

	public void frontContactSwitchFour() {
		if (frontContactSwitchFour.get() == true) {
			WaitCommmand(0.005);
			SmartDashboard.putBoolean("Front Contact Switch Four Pressed",
					frontContactSwitchFour.get());
		}
	}

	// made it so Contact Switches would return true when pressed
	protected boolean frontContactSwitchOneReturnTrue() {
		if (frontContactSwitchOne.get() == true) {
			return true;

		} else {
			return false;
		}
	}

	protected boolean frontContactSwitchTwoReturnTrue() {
		if (frontContactSwitchTwo.get() == true) {
			return true;

		} else {
			return false;
		}
	}

	protected boolean frontContactSwitchThreeReturnTrue() {
		if (frontContactSwitchThree.get() == true) {
			return true;

		} else {
			return false;
		}
	}

	protected boolean frontContactSwitchFourReturnTrue() {
		if (frontContactSwitchFour.get() == true) {
			return true;

		} else {
			return false;
		}
	}
	public void rearContactSwitchOne() {
		if (rearContactSwitchOne.get() == true) {
			WaitCommmand(0.005);
			SmartDashboard.putBoolean("Rear Contact Switch One Pressed",
					rearContactSwitchOne.get());
		}
	}

	public void rearContactSwitchTwo() {
		if (rearContactSwitchTwo.get() == true) {
			WaitCommmand(0.005);
			SmartDashboard.putBoolean("Rear Contact Switch Two Pressed",
					rearContactSwitchTwo.get());
		}
	}

	public void rearContactSwitchThree() {
		if (rearContactSwitchThree.get() == true) {
			WaitCommmand(0.005);
			SmartDashboard.putBoolean("Rear Contact Switch Three Pressed",
					rearContactSwitchThree.get());
		}
	}

	public void rearContactSwitchFour() {
		if (rearContactSwitchFour.get() == true) {
			WaitCommmand(0.005);
			SmartDashboard.putBoolean("Rear Contact Switch Four Pressed",
					rearContactSwitchFour.get());
		}
	}

	// made it so Contact Switches would return true when pressed
	protected boolean rearContactSwitchOneReturnTrue() {
		if (rearContactSwitchOne.get() == true) {
			return true;

		} else {
			return false;
		}
	}

	protected boolean rearContactSwitchTwoReturnTrue() {
		if (rearContactSwitchTwo.get() == true) {
			return true;

		} else {
			return false;
		}
	}

	protected boolean rearContactSwitchThreeReturnTrue() {
		if (rearContactSwitchThree.get() == true) {
			return true;

		} else {
			return false;
		}
	}

	protected boolean rearContactSwitchFourReturnTrue() {
		if (rearContactSwitchFour.get() == true) {
			return true;

		} else {
			return false;
		}
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
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
