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
	
	// new joystick
	private Joystick driveStick = new Joystick(0);
	
	// reset gyro button
	private Button resetGyroButt = new JoystickButton(driveStick, 12);

	// buttons for sliding up and down are assigned, could be reassigned for
	// clarity.
	private Button slideUpFrontButt = new JoystickButton(driveStick, 5);
	private Button slideDownFrontButt = new JoystickButton(driveStick, 3);
	private Button slideUpRearButt = new JoystickButton(driveStick, 6);
	private Button slideDownRearButt = new JoystickButton(driveStick, 4);
	private Button reduceSpeedButt = new JoystickButton(driveStick, 1);

	// established doubles so we can use them in other parts of the
	// program
	// buttons for gyro reset, elevator up and down
	public OI() {
		resetGyroButt.whenPressed(new GyroReset());

		slideUpFrontButt.whileHeld(new ElevateUp(Robot.elevatorFront));
		slideDownFrontButt.whileHeld(new ElevateDown(Robot.elevatorFront));
		slideUpRearButt.whileHeld(new ElevateUp(Robot.elevatorRear));
		slideDownRearButt.whileHeld(new ElevateDown(Robot.elevatorRear));

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
		return driveStick.getTwist();
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
