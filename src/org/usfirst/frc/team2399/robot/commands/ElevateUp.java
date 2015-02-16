package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;

//EXTENSION OF ELEVATE
//Elevates Up

public class ElevateUp extends Elevate {

	protected double speed;
	protected Elevator elevator;

	private RobotDrive drive;
	private CANJaguar elevatorMotor;

	private boolean positionValid;

	private double positionOffset;

	private Encoder elevatorEncoder;

	private int encoderCounts;

	private boolean enabled;

	public double getElevatorPosition() {
		return (elevatorMotor.getPosition());
	}

	public double getElevatorSpeed() {
		return (elevatorMotor.getSpeed());
	}

	public ElevateUp(Elevator elevator, Elevator elevator, double speed,
			int elevatorMotorNum, int encoderCounts) {
		super(elevator, .65);
		setInterruptible(false);
	
	setInterruptible(true);
	this.elevator = elevator;
	requires(elevator);
	
	elevatorMotor.setPercentMode(CANJaguar.kQuadEncoder, encoderCounts);
	elevatorMotor.enableControl();
	
	elevatorMotor.setPosition(7);
	
	
	
	this.encoderCounts = encoderCounts;
	

	
}