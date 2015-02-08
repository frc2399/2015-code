package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
// things to do: subsystems and commands for subsystems; elevator should be
// done; do drive train; make a mecanum drive obj so you can use the library
// method for if limit switch is pressed, driving motor
// speed; config encoders, possibly jaguars
// by tomorrow night: do the same process for drivetrain system (4 CANJaguars
// for encoders)

public class Elevator extends Subsystem {
	private CANJaguar elevatorMotor;// private sets them so that they're only
									// visible in this class
	private Encoder elevatorEncoder;//encoder and switch est
	private DigitalInput elevatorSwitch;
	
	public Elevator() {// () bc value needs to be put in
		elevatorMotor = RobotMap.ELEVATOR_JAGUAR;// sets elevator motor= to the
													// one created in RobotMap
		elevatorEncoder = RobotMap.ELEVATOR_ENCODER;//encoder and switch = ones in RobotMap
		elevatorSwitch = RobotMap.ELEVATOR_SWITCH;
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	
	
	

	if (elevatorSwitch.get() == true) //this is the command for stopping the slides
										 //so they don't fly off the robot or fall off
		{
			elevatorMotor.set(0);       //this will stop the motor controlling the slides 
		}
	
	else 
		{
			elevatorMotor.set(0); // this will be the speed the slides are traveling at when
			                     // when the switches are not pressed. WILL NEED TO INPUT VALUE
		}
	
	}

	public static void set(double d) {
		// TODO Auto-generated method stub
		
	}
		
	}
	

	
	
	





