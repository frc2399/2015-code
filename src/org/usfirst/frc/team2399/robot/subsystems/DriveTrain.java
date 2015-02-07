package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private Encoder drivetrainEncoder;
	
	public CANJaguar leftfront;
	public CANJaguar rightfront;
	public CANJaguar leftback;
	public CANJaguar rightback;
	
	public static RobotDrive drive;
	
	
	public DriveTrain(){
		leftfront = new CANJaguar(RobotMap.driveLeftFront);
		rightfront = new CANJaguar(RobotMap.driveRightFront);
		leftback = new CANJaguar(RobotMap.driveLeftBack);
		rightback= new CANJaguar(RobotMap.driveRightBack);
		
		drive= new RobotDrive(leftfront, leftback, rightfront, rightback);
		
		//set up smartdash later
		drivetrainEncoder=RobotMap.MOTOR_ENCODER;
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public static double getGyroAngle() {
		// TODO Auto-generated method stub
		return 0;
	}
    

}

