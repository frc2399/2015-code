package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.OI;
import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class JoystickDrive extends Command {
	// private instance of drive train and brings in drive train from Robot.Java
	private DriveTrain driveTrain = Robot.driveTrain;
	private Joystick driveStick = Robot.joystick;
    private Button reduceSpeedButt = Robot.oi.reduceSpeedButt; 
    //creating an instance of reduceSpeedButt
    //the code accesses the button as follows:
    //through Robot it gets to OI and finds the button in OI
    //not sure why this is a thing but the code seems to be happy
    
	public JoystickDrive() {

		requires(Robot.driveTrain);

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	// sets drivetrain to get values from joysticks
	protected void execute() {
		double twist;
		double x;
		double y;

		// dead-bands set individually to their values
		twist = deadband(Robot.oi.getTwistSpeed(), .5, .5);
		x = deadband(Robot.oi.getSideSpeed(), .25, 1);
		y = deadband(Robot.oi.getForwardSpeed(), .25, 1);
		SmartDashboard.putNumber("X is: ", x);
		SmartDashboard.putNumber("Y is: ", y);
		SmartDashboard.putNumber("Twist is: ", twist);
	
		if (reduceSpeedButt.get() == true){
			double speedAdjust = .3;
			//speedAdjust is the amount speed is divided by
			double halfX = speedAdjust * x;
			double halfY = speedAdjust * y;
			double halfTwist = speedAdjust * twist;
			//TODO figure out a way that this works for robot and field oriented drive
			//WITHOUT overriding the current mode (robot or field oriented)
			//maybe ask the drive train what mode it's it--have an if statement so mode isn't overridden
			driveTrain.driveFieldOriented(halfX, halfY, halfTwist);
			//this says that if the button is pressed
			//set the speed of the x y and twist
			//to half of their original values
	} else{ //if it isn't pressed then use the actual x y and twist values
		driveTrain.driveFieldOriented(x, y, twist);
		//driveTrain.driveRobotOriented(x, y, twist);
	}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

	// establishes constant deadbandpercent so different calculations can be
	// made for different motions individually.
	// established deadbandscale so twist motor power can be scaled (makes turns
	// less jerky)
	// TODO ask drivers if they want the scaling on a switch/button (later)
	// scaling for drive as well that can be turned on and off

	public static double deadband(double input, double deadbandpercent,
			double deadbandscale) {
		double deadbandconstant = deadbandpercent;

		if (Math.abs(input) < deadbandconstant) { // abs = absolute value
			return 0;
		}

		else {
			return (deadbandscale * (input / (Math.abs(input)) * (((Math
					.abs(input) - deadbandconstant)) / (1 - deadbandconstant))));
		}
	}
//	protected boolean HalfSpeed(){
//		if (reduceHalfSpeed.isPressed()){
//			return true;
//			
//		}else{
//			return false;
//		}
//	}
}
