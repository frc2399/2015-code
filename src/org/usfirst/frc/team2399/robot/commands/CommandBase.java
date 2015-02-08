package org.usfirst.frc.team2399.robot.commands;

import java.sql.Driver;

import org.usfirst.frc.team2399.robot.OI;
import org.usfirst.frc.team2399.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.templates.OI;
//import edu.wpi.first.wpilibj.templates.subsystems.*;

/**
 *
 */



public abstract class CommandBase extends Command {
	

	//static instances of all subsystems
	public static  OI oi;
	public static  DriveTrain driveTrain;
	public static  Elevator elevator;
	
	
	public void init()
	{
		driveTrain = new DriveTrain();//driveTain
		elevator = new Elevator();//elevator
		
		oi= new OI();//oi orange juice
		SmartDashboard.putData("Drive Train", driveTrain);//smartdash values
		SmartDashboard.putData("Elevator", elevator);
		
	}
    public CommandBase() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
