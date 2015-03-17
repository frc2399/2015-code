package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;
import org.usfirst.frc.team2399.robot.commands.ElevateNot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

//object: collection of both variables and methods
//methods: a set of steps
//instance variables: data contained within that object
/**
 *
 */
// sets this instance of elevatorMotor to the public instance of elevatorMotor
// this code is much simpler and it's very nice
// All limit switch code has been removed, because limit switches stop Jags
// automatically when pressed.
public class Elevator extends Subsystem {
	// private instances of drive, elevatormotor/encoder
	private CANJaguar elevatorMotor;

	private boolean positionValid;
	private double upperLimit;
	private double lowerLimit;
	
	private double positionOffset;

	private DigitalInput leftOuterSwitch;
	private DigitalInput leftInnerSwitch;
	private DigitalInput rightInnerSwitch;
	private DigitalInput rightOuterSwitch;
	
	private int encoderCounts;
	
	private double toteSpot;
	private boolean enabled;

	// sets elevator to one from Robot Map
	// this was moved from RobotMap to here to fix an error- working fine now!
	// this refers to the current instance of the class
	// encoder position is a double
	public Elevator(int elevatorMotorNum, 
			int leftOuterSwitchNum,
			int leftInnerSwitchNum, 
			int rightInnerSwitchNum,
			int rightOuterSwitchNum, 
			int encoderCounts, 
			double upperLimit,
			double lowerLimit) {
		elevatorMotor = new CANJaguar(elevatorMotorNum);
		positionValid = false;
		enabled = false;
		
		toteSpot = RobotMap.TOTESPOT;
		// this. refers to the object's variables
		if (upperLimit > lowerLimit) {
			this.upperLimit = upperLimit;
			this.lowerLimit = lowerLimit;
		} else {
			this.upperLimit = lowerLimit;
			this.lowerLimit = upperLimit;
		} // this if block checks to make sure that the two limit values are
			// correct
			// makes sure upperLimit is actually the bigger and vice versa with
			// lowerLimit
			// kQuad tells it that it has a Quad encoder attached
		this.encoderCounts = encoderCounts;
		
		positionOffset = 0;
		
		leftOuterSwitch = new DigitalInput(leftOuterSwitchNum);
		leftInnerSwitch = new DigitalInput(leftInnerSwitchNum);
		rightInnerSwitch = new DigitalInput(rightInnerSwitchNum);
		rightOuterSwitch = new DigitalInput(rightOuterSwitchNum);
		
		elevatorMotor.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		elevatorMotor.enableControl();
		
		checkLowerLimit();
	}
	private void checkLowerLimit()
	{
		// up is forward (+)
		// down is reverse (-)
		// this means that we are touching the bottom (reverse) limit switch
		
		
		enabled = false;
		if (elevatorMotor.getReverseLimitOK() == false && positionValid == false) {
			//reverseLimitOK works with the bottom switches and makes sure they are correct (false)
			//false until it touches the bottom switches
			//makes sure the swithces are accurate
			positionOffset = elevatorMotor.getPosition();
			
			positionValid = true;
		}
		
		
		enabled = true;
	}
	
	public boolean hasReachedTop(){
		return !elevatorMotor.getForwardLimitOK();
	}
	public boolean hasReachedBottom(){
		return !elevatorMotor.getReverseLimitOK();
	}
	
	private void zeroJagEncoderCount()
	{
		elevatorMotor.set(0);
		elevatorMotor.setPositionMode(CANJaguar.kQuadEncoder, encoderCounts, 0, 0, 0);
		elevatorMotor.enableControl(0.0);

		elevatorMotor.set(0.0);
		elevatorMotor.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		elevatorMotor.enableControl();
		elevatorMotor.set(0);
	}
	
	// elevator motor is set to the up speed
	// elevator depend on the motor thats been passed to it- now works for all
	// of the motors
	public void setSpeed(double elevatorSpeed) {
		
		checkLowerLimit();
		enforceLimits(elevatorSpeed);
		elevatorMotor.set(elevatorSpeed);
}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	// default command is no movement
	public void initDefaultCommand() {

		setDefaultCommand(new ElevateNot(this));
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void putSwitchesToDashboard(String prefix) {
//		SmartDashboard.putBoolean(prefix + " Left Outer Switch Pressed",
//				leftOuterSwitch.get());
//		SmartDashboard.putBoolean(prefix + " Left Inner Switch Pressed",
//				leftInnerSwitch.get());
//		SmartDashboard.putBoolean(prefix + " Right Inner Switch Pressed",
//				rightInnerSwitch.get());
//		SmartDashboard.putBoolean(prefix + " Right Outer Switch Pressed",
//				rightOuterSwitch.get());

	}
	
	public void putPositionToDashboard(String prefix)
	{
//		SmartDashboard.putNumber(prefix + " Elevator Height (turns)", getPosition());
//		SmartDashboard.putBoolean(prefix + " Elevator Position Valid", positionValid);
//		SmartDashboard.putNumber(prefix + " Elevator Height (inches)", getPosition() * 1.194 * Math.PI + 8.5);
	}

	
	public double getPosition()
	{
		return elevatorMotor.getPosition() - positionOffset;
	}
	public boolean isTouchingTote() {
		return !leftOuterSwitch.get() && !rightOuterSwitch.get()
				&& leftInnerSwitch.get() && rightInnerSwitch.get();
	}
	public double enforceLimits(double elevatorSpeed){
		if (positionValid == true) {
			if (elevatorSpeed > 0) {
				if (getPosition() > upperLimit) {
					elevatorSpeed = 0;
				}
			}
			if (elevatorSpeed < 0) {
				if (getPosition() < lowerLimit)
					elevatorSpeed = 0;
			}
		}
		return elevatorSpeed;
	}
	public void contactTote(Elevator elevator){
		if(isTouchingTote() == true && getPosition() < toteSpot){
			elevatorMotor.set(toteSpot);
		}
	}
}
