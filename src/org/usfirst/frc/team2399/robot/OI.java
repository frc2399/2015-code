package org.usfirst.frc.team2399.robot;

import org.usfirst.frc.team2399.robot.commands.ElevateDown;
import org.usfirst.frc.team2399.robot.commands.ElevateUp;
import org.usfirst.frc.team2399.robot.commands.GyroReset;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	// EVERYTHING HERE WILL BE CHANGED AT A LATER DATE
	// minor change testing

	Joystick driveStick = new Joystick(0);// new joystick

	Button slideOneButt = new JoystickButton(driveStick, 6);// all the buttons
															// yayyy
	Button slideTwoButt = new JoystickButton(driveStick, 7);// buttons are
															// assigned to ports
	Button slideThreeButt = new JoystickButton(driveStick, 11);
	Button slideFourButt = new JoystickButton(driveStick, 10);
	Button resetGyroButt = new JoystickButton(driveStick, 5);

	Button strafeButt = new JoystickButton(driveStick, 2);

	Button slideUpButt = new JoystickButton(driveStick, 3);
	Button slideDownButt = new JoystickButton(driveStick, 4);

	double x;// est doubles so we can use them in other parts of the program
	double y;
	double twist;

	public OI() {
		resetGyroButt.whenPressed(new GyroReset());
		slideUpButt.whileHeld(new ElevateUp());
		slideDownButt.whileHeld(new ElevateDown());

	}

	public double getForwardSpeed()// forward speed returns the y value from the
									// joystick
	{
		return driveStick.getY();
	}

	public double getSideSpeed()// side speed returns the x value from the
								// joystick
	{
		return driveStick.getX();
	}

	public boolean shouldStrafe() {// if it strafes, return the value false
		if (strafeButt.get() == true) {
			return true;
		} else {
			return false;
		}
	}

	public double getTwistSpeed() {//	
		return driveStick.getTwist();
	}

	public static double getForwardSpeed1() {// gets the forward speed
		return 0;
		// TODO Auto-generated method stub

	}

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
