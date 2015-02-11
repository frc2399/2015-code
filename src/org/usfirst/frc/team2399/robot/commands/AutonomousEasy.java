package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.Robot;
import org.usfirst.frc.team2399.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousEasy extends Command {
	private DriveTrain driveTrain = Robot.driveTrain;
	private Joystick driveStick = Robot.joystick;
	private Gyro gyro = Robot.gyro;
	//requires driveTrain from Robot.java
    public AutonomousEasy() {
    	requires(Robot.driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.resetGyro();
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double x;
    	double y;
    
    	//DriveTrain.mechanumDrive_Cartesian(15, 0, 0, 0);//TODO figure out problem with mentors and a less lazy Amanda
    	//no, Sara, DO NOT USE AUTOFILL. Will has said this. It is not good for our code.
    	
    	}
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
