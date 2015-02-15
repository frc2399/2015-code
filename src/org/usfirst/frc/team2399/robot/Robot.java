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
	// public static Button reduceSpeedButt;

	public static Elevator elevatorFront;
	public static Elevator elevatorRear;

	public static Joystick joystick;

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

		driveTrain = new DriveTrain();

		elevatorFront = new Elevator(RobotMap.ELEVATORFRONT_JAGUARID,
				RobotMap.FRONTCONTACT_SWITCH1ID,
				RobotMap.FRONTCONTACT_SWITCH2ID,
				RobotMap.FRONTCONTACT_SWITCH3ID,
				RobotMap.FRONTCONTACT_SWITCH4ID);
		elevatorRear = new Elevator(RobotMap.ELEVATORREAR_JAGUARID,
				RobotMap.REARCONTACT_SWITCH1ID, RobotMap.REARCONTACT_SWITCH2ID,
				RobotMap.REARCONTACT_SWITCH3ID, RobotMap.REARCONTACT_SWITCH4ID);

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

	// public void reduceSpeedButt() {
	// if (reduceSpeedButt.get() == true){
	// WaitCommmand(0.005);
	// x = .5 * x;
	// y = .5 * y;
	// twist = .5 * twist;
	// driveTrain.driveFieldOriented(x, y, twist);
	// }
	// }

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

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
