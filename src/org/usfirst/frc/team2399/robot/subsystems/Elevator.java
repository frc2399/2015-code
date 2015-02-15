package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;
import org.usfirst.frc.team2399.robot.commands.ElevateNot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	private RobotDrive drive;
	private CANJaguar elevatorMotor;
	private boolean positionValid;
	private double upperLimit;
	private double lowerLimt;

	// sets elevator to one from Robot Map
	// this was moved from RobotMap to here to fix an error- working fine now!
	// this refers to the current instance of the class
	// encoder position is a double
	public Elevator(int elevatorMotorNum, int encoderCounts, double upperLimit,
			double lowerLimit) {
		elevatorMotor = new CANJaguar(elevatorMotorNum);
		positionValid = false;
		// this. refers to the object's variables
		if (upperLimit > lowerLimit) {
			this.upperLimit = upperLimit;
			this.lowerLimt = lowerLimit;
		} else {
			this.upperLimit = lowerLimit;
			this.lowerLimt = upperLimit;
		} // this if block checks to make sure that the two limit values are
			// correct
			// makes sure upperLimit is actually the bigger and vice versa with
			// lowerLimit
			// kQuad tells it that it has a Quad encoder attached
		elevatorMotor.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
		elevatorMotor.enableControl();

	}

	// elevator motor is set to the up speed
	// elevator depend on the motor thats been passed to it- now works for all
	// of the motors
	public void setSpeed(double elevatorSpeed) {
		// up is forward (+)
		// down is reverse (-)
		// this means that we are touching the bottom (reverse) limit switch
		if (elevatorMotor.getReverseLimitOK() == false) {
			elevatorMotor.enableControl(0);
			positionValid = true;
		}
		if (positionValid == true) {
			if(elevatorMotor.getSpeed() > 0){
				if(elevatorMotor.getPosition() > upperLimit){
					elevatorSpeed = 0;
				}
			}
			if(elevatorMotor.getSpeed() < 0){
				if(elevatorMotor.getPosition() < lowerLimit)
					elevatorSpeed = 0;
			}

		}
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
}
