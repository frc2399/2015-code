package org.usfirst.frc.team2399.robot.subsystems;

import org.usfirst.frc.team2399.robot.RobotMap;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {//extends DriveTrain
	private Encoder drivetrainEncoder;//encoder est
	
	public CANJaguar leftfront;//Jags est
	public CANJaguar rightfront;
	public CANJaguar leftback;
	public CANJaguar rightback;
	
	public static RobotDrive drive;//drive est as static
	
	
	public DriveTrain(){
		leftfront = new CANJaguar(RobotMap.driveLeftFront);//Jags take values from RobotMap
		rightfront = new CANJaguar(RobotMap.driveRightFront);//est new CANJags
		leftback = new CANJaguar(RobotMap.driveLeftBack);
		rightback= new CANJaguar(RobotMap.driveRightBack);
		
		drive= new RobotDrive(leftfront, leftback, rightfront, rightback);//says what Drive is
		
		//set up smartdash later
		drivetrainEncoder=RobotMap.MOTOR_ENCODER;//what the drivetrain encoder is
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

