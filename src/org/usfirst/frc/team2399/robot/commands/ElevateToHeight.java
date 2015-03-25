package org.usfirst.frc.team2399.robot.commands;

import org.usfirst.frc.team2399.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevateToHeight extends Elevate {
	private double height;

    public ElevateToHeight(Elevator elevator, double height) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super(elevator, 0); 
    	this.height = height; //the variable height is equal to the parameter height
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double currentPos = elevator.getPositionInches(); //getting the current position
    	if (currentPos < height){
    		speed = .65; //figure out if we have a positive or a negative speed aka going up or down
    	} else { 
    		speed = -.65;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (elevator.isPositionValid() == false){ //if we're at a bad spot then stop moving
    		return true;
    	} if (speed < 0){
    		if (elevator.getPositionInches() <= height){
    			return true; 
    			//if we are moving down and our current position is less then where we want to be then stop
    			}
    	} if (speed > 0){
    		if (elevator.getPositionInches() >= height){
    			return true;
    			//if we are moving up and our current position is more then where we want to be then stop
    		}
    	}
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
