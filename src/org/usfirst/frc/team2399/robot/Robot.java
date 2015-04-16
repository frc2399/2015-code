package org.usfirst.frc.team2399.robot;

import org.usfirst.frc.team2399.robot.commands.AutoBin;
import org.usfirst.frc.team2399.robot.commands.AutoStrafe;
import org.usfirst.frc.team2399.robot.commands.AutoTote;
import org.usfirst.frc.team2399.robot.commands.DriveAutoZone;
//import org.usfirst.frc.team2399.robot.OI;
import org.usfirst.frc.team2399.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;
import org.usfirst.frc.team2399.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;
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
	public static Joystick joystick;
	public static Gyro gyro;
	public static Joystick twistStick;
	
	public static DigitalInput autoToteSelect;
	public static DigitalInput autoBinSelect;
	public static DigitalInput autoDriveSelect;
	public static DigitalInput autoStrafeSelect;
	//defining the digital inputs
	
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
									RobotMap.ENCODER_COUNTS_FRONT_ELEVATOR,
									RobotMap.FRONT_ELEVATOR_UPPER_LIMIT,
									RobotMap.FRONT_ELEVATOR_LOWER_LIMIT);

		//leftFront = new CANJaguar(RobotMap.LEFTFRONT_JAGUARID);
		/*
		 * AUTO_STRAFE_SELECT_INPUT; //TO DO INPUT NUMBERS
	public static final int AUTO_TOTE_SELECT_INPUT; 
	public static final int AUTO_BIN_SELECT_INPUT; 
	public static final int AUTO_DRIVE_AUTOZONE_SELECT_INPUT
		 */ 
		   autoToteSelect = new DigitalInput(RobotMap.AUTO_TOTE_SELECT_INPUT);
		   autoBinSelect = new DigitalInput(RobotMap.AUTO_BIN_SELECT_INPUT);
		   autoDriveSelect = new DigitalInput(RobotMap.AUTO_DRIVE_AUTOZONE_SELECT_INPUT);
		   autoStrafeSelect = new DigitalInput(RobotMap.AUTO_STRAFE_SELECT_INPUT);
		  



		oi = new OI();
		

		
		cam0 = CameraServer.getInstance();
		cam0.setQuality(25);
		cam0.setSize(100);
		cam0.startAutomaticCapture();

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
	/*
	 * autoToteSelect = new DigitalInput(RobotMap.AUTO_TOTE_SELECT_INPUT);
		   autoBinSelect = new DigitalInput(RobotMap.AUTO_BIN_SELECT_INPUT);
		   autoDriveSelect = new DigitalInput(RobotMap.AUTO_DRIVE_AUTOZONE_SELECT_INPUT);
		   autoStrafeSelect = new DigitalInput(RobotMap.AUTO_STRAFE_SELECT_INPUT);
		  (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.IterativeRobot#autonomousInit()
	 */

	// schedule the autonomous command (example)
	public void autonomousInit() {
		if (autoToteSelect.get() == false){
			autoncommand = new AutoTote();
		} else if (autoBinSelect.get() == false){
			autoncommand = new AutoBin();
		} else if (autoDriveSelect.get() == false){
			autoncommand = new DriveAutoZone();
		} else if (autoStrafeSelect.get() == false){
			autoncommand = new AutoStrafe();
		} else {
			autoncommand = null;
		}
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
		new WaitCommand(.0001); //added a 1 milisecond delay when teleop starts to get the DS laptop
		//to reduce CPU usage of the DS laptop when teleop starts so we don't lose comms
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
		elevatorFront.putPositionToDashboard("Front");

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
