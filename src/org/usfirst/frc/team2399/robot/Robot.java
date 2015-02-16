package org.usfirst.frc.team2399.robot;

import org.usfirst.frc.team2399.robot.commands.DriveAutoZone;
import org.usfirst.frc.team2399.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
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
//THIS HAS NEW STUFF. YOU SHOULD LOOK AT THE THING
//new public static elevators here/ they have been assigned to their ID's from RobotMap
//have also been added to SmartDash
// THIS CLASS HAS REPLACED COMMANDBASE/COMMANDS
public class Robot extends IterativeRobot {
	// est static variables
	public static OI oi;
	public static DriveTrain driveTrain;
	public static Elevator elevatorFront;
	public static Elevator elevatorRear;
	public static Elevator elevatorRight;
	public static Elevator elevatorLeft;
	public static Joystick joystick;
	public static Gyro gyro;
	public static Joystick twistStick;
	
	private Command autoncommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	//if you want to take out an auton mode, comment out autoncommand = new
	//gyro deleted bc assigned to driveTrain
	public void robotInit() {
		// est new instances of drivetrain and elevator
		driveTrain = new DriveTrain();
		elevatorFront = new Elevator(RobotMap.ELEVATORFRONT_JAGUAR);
		elevatorRear = new Elevator(RobotMap.ELEVATORREAR_JAGUAR);
		elevatorRight = new Elevator(RobotMap.ELEVATORRIGHT_JAGUAR);
		elevatorLeft = new Elevator(RobotMap.ELEVATORLEFT_JAGUAR);
		oi = new OI();// oi orange juice
		autoncommand= new DriveAutoZone();

		// smartdash values for drivetrain and elevator
		SmartDashboard.putData("Drive Train", driveTrain);// smartdash values
		SmartDashboard.putData("Elevator", elevatorFront);
		SmartDashboard.putData("Elevator", elevatorRear);
		SmartDashboard.putData("Elevator", elevatorRight);
		SmartDashboard.putData("Elevator", elevatorLeft);

	

		// frontLeft = new drivetrainMotor
		// instantiate the command used for the autonomous period

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		if (autoncommand != null){
			autoncommand.start();
		}
	
		// schedule the autonomous command (example)

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
