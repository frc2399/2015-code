package org.usfirst.frc.team2399.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
<<<<<<< Updated upstream
	
	// EVERYTHING HERE WILL BE CHANGED AT A LATER DATE
	
	Joystick driveStick = new Joystick (0);
	
	Button slideOneButt = new JoystickButton(driveStick, 6);
	Button slideTwoButt = new JoystickButton(driveStick, 7);
	Button slideThreeButt = new JoystickButton(driveStick, 11);
	Button slideFourButt = new JoystickButton(driveStick, 10);

	Button strafeLeftButt = new JoystickButton(driveStick, 4);
	Button strafeRightButt = new JoystickButton(driveStick, 5);

	
	public double getForwardSpeeds()
	{
		return driveStick.getY();
	}
	
	public double getSideSpeed()
	{
		return driveStick.getX();
	}

	
	
    //// CREATING BUTTONS
=======
	public double getForwardSpeed(){
		return driveStick.getRawAxis();
	}
	
	public double getSideSpeed(){
		return driveStick.getRawAxis();
	}
	
	public double getTwistSpeed(){
		return driveyStick.getRawAxis(3);
	}
	
	public double getDriveyStickThrottle(){
		return driveyStick.getRawAxis(4);
	}
	public double getLeftStickThrottle(){
		return leftStick.getRawAxis(3);
	}
	public double getRightStickThrottle(){
		return rightStick.getRawAxis(3);
	}
	public boolean shouldStrafe() {
		if(strafeButt.get()==true){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	//// CREATING BUTTONS
>>>>>>> Stashed changes
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	
}

