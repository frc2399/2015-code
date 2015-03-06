package org.usfirst.frc.team2399.robot;

import org.usfirst.frc.team2399.robot.commands.*;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	Joystick driveStick = new Joystick(1);// new joystick
	Joystick twistStick = new Joystick(2);//


	// reset gyro button
	private Button resetGyroButt = new JoystickButton(driveStick, 7);

	// buttons for sliding up and down are assigned, could be reassigned for
	// clarity.

	//made a button called reduceSpeedButt and mapped it to the joystick
	//i made it public so I could use it in JoystickDrive
	//probably shouldn't have done that but right now I don't know how to work around that
	private Button slideUpFrontButt = new JoystickButton(driveStick, 3);
	private Button slideDownFrontButt = new JoystickButton(driveStick, 2);
	private Button slideUpRearButt = new JoystickButton(twistStick, 3);
	private Button slideDownRearButt = new JoystickButton(twistStick, 2);
	public Button reduceSpeedButt = new JoystickButton(driveStick, 1);
	private Button robotOrientedButt = new JoystickButton(driveStick, 8);
	private Button fieldOrientedButt = new JoystickButton(driveStick, 9);
	
	private Button automaticUpFrontLiftButt = new JoystickButton(driveStick, 4);
	private Button automaticDownFrontLiftButt = new JoystickButton(driveStick, 5);
	private Button automaticUpRearLiftButt = new JoystickButton(twistStick, 4);
	private Button automaticDownRearLiftButt = new JoystickButton(twistStick, 5);
	private Button liftTurboMode = new JoystickButton(twistStick, 1);
	
//driveStick port is 1 and is also known as the blue side of robot
//twistStick port is 2 and is also known as the pink side of robot

	double x;// est doubles so we can use them in other parts of the program
	double y;
	double twist;

	private Button automaticLiftFrontButt = new JoystickButton(twistStick, 8);
	private Button automaticLiftRearButt = new JoystickButton(twistStick, 9);

	// established doubles so we can use them in other parts of the
	// program
	// buttons for gyro reset, elevator up and down
	public OI() {
		resetGyroButt.whenPressed(new GyroReset());		
		robotOrientedButt.whenPressed(new JoystickDrive());
		fieldOrientedButt.whenPressed(new FieldOrientedDrive());
		
		automaticUpFrontLiftButt.whenPressed(new ElevateToTop(Robot.elevatorFront));
		automaticDownFrontLiftButt.whenPressed(new ElevateToBottom(Robot.elevatorFront));
		automaticUpRearLiftButt.whenPressed(new ElevateToTop(Robot.elevatorRear));
		automaticDownRearLiftButt.whenPressed(new ElevateToBottom(Robot.elevatorRear));
		
		
		slideUpFrontButt.whileHeld(new ElevateUp(Robot.elevatorFront));
		slideDownFrontButt.whileHeld(new ElevateDown(Robot.elevatorFront));
		slideUpRearButt.whileHeld(new ElevateUp(Robot.elevatorRear));
		slideDownRearButt.whileHeld(new ElevateDown(Robot.elevatorRear));


		automaticLiftFrontButt.whileHeld(new ElevateUpWhenTouchingTote(
				Robot.elevatorFront));
		automaticLiftRearButt.whileHeld(new ElevateUpWhenTouchingTote(
				Robot.elevatorRear));
		
		
		

	}

	// doubles and booleans for joystick values
	// these get the "speed" from how far the joystick is pushed
	public double getForwardSpeed() {
		return -driveStick.getY();
	}

	public double getSideSpeed() {
		return -driveStick.getX();
	}

	public double getTwistSpeed() {
		return twistStick.getX();
	}
	
	public boolean getReduceSpeed() {
		return reduceSpeedButt.get();
	}
	public boolean getLiftTurboMode(){
		return liftTurboMode.get();
	}
	/*OTHER BOOLEANS
	 * button for the front lift that makes it go to the top and stop
	 * button for the front lift that makes it go to the bottom and stop
	 * button for the bottom lift that makes it go to the top and stop
	 * button for the bottom lift that makes it go to the bottom and stop
	 * make each of them call commands?
	 * that would involve making commands for each of them
	 * but what's all of four commands that would say the same thing
	 * the hard part would be figuring out what each would say
	 * wait
	 * could each of the buttons call the elevateUp or elevateDown command?
	 * that would make it a lot easier
	 * let's try that
	 */
	

	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
