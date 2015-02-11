package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;
import org.usfirst.frc.team2399.robot.commands.ElevateNot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

//ALL LIMIT SWITCH THINGS HAVE BEEN REMOVED BC JAGS DO IT FOR US
public class Elevator extends Subsystem {
	//private instances of drive, elevatormotor/encoder
	private RobotDrive drive;
	private CANJaguar elevatorFrontMotor;
	//private CANJaguar elevatorRearMotor;
	//private CANJaguar elevatorRightMotor;
	//private CANJaguar elevatorLeftMotor;
	private Encoder elevatorEncoder;
	
	//sets elevator to one from Robot Map
	//this was moved from RobotMap to here to fix an error- working fine now!
	public Elevator() {
		elevatorFrontMotor = new CANJaguar(RobotMap.ELEVATORFRONT_JAGUARID);
		//elevatorRearMotor = new CANJaguar(RobotMap.ELEVATORREAR_JAGUARID);
		//elevatorRightMotor = new CANJaguar(RobotMap.ELEVATORRIGHT_JAGUARID);
		//elevatorLeftMotor = new CANJaguar(RobotMap.ELEVATORLEFT_JAGUARID);

	}
	//elevator motor is set to the up speed 
	public void setSpeed(double elevatorUpSpeed) {
		elevatorFrontMotor.set(elevatorUpSpeed);
		//elevatorRearMotor.set(elevatorUpSpeed);
		//elevatorRightMotor.set(elevatorUpSpeed);
		//elevatorLeftMotor.set(elevatorUpSpeed);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	//default command is no movement
	public void initDefaultCommand() {

		setDefaultCommand(new ElevateNot());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

}
